package common;

import java.util.Collections;
import model.*;

public class libraryTax {

    public boolean getSex(String s) {
        return s.equalsIgnoreCase("FM");
    }

    public int takeTotalResource(person p) {//chưa khấu trừ
        int res = 0;
        for (resources d : p.getResourcesTotal()) {
            res += d.getAmount();
        }
        return res;
    }

    public int calDeductionChild(person p) {
        //tính deduction con        
        int deductionChild = 0;
        for (child c : p.getChildren()) {
            if (c.getAge() <= 18) {
                c.setDeduction(4400000);
            }else if ( c.getAge() <= 22 && c.isIsStudying()) {
                c.setDeduction(6000000);
            }else if (c.getAge() <= 22 && !c.isIsStudying() || c.getAge() > 22) {
                c.setDeduction(0);
            }
        }
        //nếu có hơn 2 con thì deduction chỉ tính 2 đứa có deduction cao nhất thôi
        if (p.getNoChildren() > 2) {
            Collections.sort(p.getChildren());
            deductionChild = p.getChildren().stream().map(d -> d.getDeduction()).limit(2).reduce(deductionChild, Integer::sum);
        } else {
            deductionChild = p.getChildren().stream().map(d -> d.getDeduction()).reduce(deductionChild, Integer::sum);
        }
        return deductionChild;
    }

    public int calDeductionParent(person p) {
        int totalDeduction = takeTotalResource(p) - p.getDeductionSelf();
        //tính deduction bố mẹ
        int deductionParent = 0;
        for (parent pr : p.getParents()) {
            if (pr.isIsRetire()) {
                if (pr.isHavePension()) {
                    pr.setDeduction(0);
                }else{
                pr.setDeduction(4400000);}
            } else {
                pr.setDeduction(0);
            }
        }
        deductionParent = p.getParents().stream().map(d -> d.getDeduction()).reduce(deductionParent, Integer::sum);
        //nếu bố mẹ có nhiều hơn 1 con và thu nhập chịu thế > 4M thì chia đều khấu trừ cho anh em
        if (p.getNoBrSis() > 1 && totalDeduction > 4000000) {
            deductionParent /= p.getNoBrSis();
        }
        return deductionParent;
    }

    public int calTaxableIncome(person p) {
        int totalDeduction = takeTotalResource(p) - p.getDeductionSelf();
        return totalDeduction - (calDeductionChild(p) + calDeductionParent(p));
    }

    public int calTotalTax(person p) {//tính theo cách tính thuế của cục thuế Việt Nam
        int taxableIncome = calTaxableIncome(p);
        if(taxableIncome<11000000){
            return 0;
        }
        int tempTI = 0;
        if (taxableIncome < 5000000) {
            tempTI = degreeOne(taxableIncome);
        } else if (taxableIncome < 10000000) {//5-10
            tempTI += degreeOne(0);
            tempTI += degreeTwo(taxableIncome);
        } else if (taxableIncome < 18000000) {//10-18
            tempTI += degreeOne(0);
            tempTI += degreeTwo(0);
            tempTI += degreeThree(taxableIncome);
        } else if (taxableIncome < 32000000) {//18-32
            tempTI += degreeOne(0);
            tempTI += degreeTwo(0);
            tempTI += degreeThree(0);
            tempTI += degreeFour(taxableIncome);
        } else if (taxableIncome < 52000000) {//32-52
            tempTI += degreeOne(0);
            tempTI += degreeTwo(0);
            tempTI += degreeThree(0);
            tempTI += degreeFour(0);
            tempTI += degreeFive(taxableIncome);
        } else if (taxableIncome < 80000000) {//52-80
            tempTI += degreeOne(0);
            tempTI += degreeTwo(0);
            tempTI += degreeThree(0);
            tempTI += degreeFour(0);
            tempTI += degreeFive(0);
            tempTI += degreeSix(taxableIncome);
        } else {//>80
            tempTI += degreeOne(0);
            tempTI += degreeTwo(0);
            tempTI += degreeThree(0);
            tempTI += degreeFour(0);
            tempTI += degreeFive(0);
            tempTI += degreeSix(0);
            tempTI += degreeSeven(taxableIncome);
        }
        return tempTI;
    }

    private int degreeOne(int x) {
        if (x == 0) {
            x = 5000000;
        }
        return (int) (x * 0.05);
    }

    private int degreeTwo(int x) {
        if (x == 0) {
            x = 10000000;
        }
        return (int) ((x - 5000000) * 0.1);
    }

    private int degreeThree(int x) {
        if (x == 0) {
            x = 18000000;
        }
        return (int) ((x - 10000000) * 0.15);
    }

    private int degreeFour(int x) {
        if (x == 0) {
            x = 32000000;
        }
        return (int) ((x - 18000000) * 0.2);
    }

    private int degreeFive(int x) {
        if (x == 0) {
            x = 52000000;
        }
        return (int) ((x - 32000000) * 0.25);
    }

    private int degreeSix(int x) {
        if (x == 0) {
            x = 80000000;
        }
        return (int) ((x - 52000000) * 0.3);
    }

    private int degreeSeven(int x) {
        return (int) ((x - 80000000) * 0.35);
    }

    public static void main(String[] args) {
        libraryTax l = new libraryTax();
        System.out.println(l.degreeOne(0));
    }
}
