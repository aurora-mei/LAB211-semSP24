package view;

import common.InputterTax;
import common.libraryTax;
import java.util.ArrayList;
import java.util.List;
import model.*;
import model.resources;

public class viewTax<T> {

    InputterTax in = new InputterTax();
    libraryTax lib = new libraryTax();

    public person inputPerson() {
        String name = in.getStringFromInput("Enter name of worker: ");
        int NoResources = in.inputPositiveInt("Enter number of resources: ");
        List<resources> r = inputResources(NoResources);
        List<parent> p = inputParent();
        int NoBrSis = in.inputPositiveInt("Enter number of children of parent: ");
        System.out.println("----------------------Input Children----------------------");
        int NoChild = in.inputPositiveInt("Enter number of child: ");
        List<child> c = inputChild(NoChild);
        return new person(name, NoChild, r, c, p, NoBrSis);
        //nhập nguồn thu nhập: content, amount
        //nhập child: name, age,isStudying
        //nhập bố mẹ: age,sex,havePension
    }

    private List<resources> inputResources(int n) {
        System.out.println("----------------------Input Resource----------------------");
        List<resources> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String content = in.getStringFromInput("Enter resoures " + (i + 1) + ": ");
            int amount = in.inputPositiveInt("Enter amount of resources " + (i + 1) + ": ");
            l.add(new resources(content, amount));
        }
        return l;
    }

    private List<parent> inputParent() {
        System.out.println("----------------------Input Parent----------------------");
        List<parent> l = new ArrayList<>();
        int age = 0;
        for (int i = 0; i < 2; i++) {
            int sex = i;
            if (sex == 0) {
                age = in.getIntFromInput("Enter age of mother: ");
            } else {
                age = in.getIntFromInput("Enter age of father: ");
            }
            boolean hasPension = false;
            if (sex == 0 && age >= 60) {
                hasPension = in.checkYN("Parent has pension or not[Y/N]: ");
            }
            if (sex == 1 && age >= 65) {
                hasPension = in.checkYN("Parent has pension or not[Y/N]: ");
            }
            l.add(new parent(age, sex, hasPension, 0));
        }
        return l;
    }

    private List<child> inputChild(int n) {
//        System.out.println("----------------------Input Children----------------------");
        List<child> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = in.getStringFromInput("Enter name of child " + (i + 1) + ": ");
            int age = in.getIntFromInput("Enter age: ");
            boolean isStudying = true;
            if (age <= 18) {
                isStudying = true;
            } else if (age <= 22) {
                isStudying = in.checkYN("Child is studying or not[Y/N]: ");
            } else {
                isStudying = false;
            }
            l.add(new child(name, age, isStudying, 0));
        }
        return l;
    }

    public void printList(List<T> l) {
        for (T o : l) {
            System.out.println(o.toString());
        }
    }

    public void displayDetail(person p) {
        System.out.println("---------------------Result of calculate tax--------------------");
        System.out.println("Income before deduction: " + lib.takeTotalResource(p));
        System.out.println("Deduction self: " + p.getDeductionSelf());//in khấu trừ bản thân
        System.out.println("Deduction from children: " + lib.calDeductionChild(p));//in khấu trừ từ con   
        System.out.println("Deduction from parent: " + lib.calDeductionParent(p));//in khấu trừ từ bố mẹ
        System.out.println("Taxable Income: " + lib.calTaxableIncome(p));//in thu nhập chịu thuế
        System.out.println("Personal income tax: " + lib.calTotalTax(p));
    }

    public void displayPerson(person p) {
        System.out.println("----------Information of worker " + p.getName() + "----------");
        System.out.println("---------------------Resources--------------------");
        printList((List<T>) p.getResourcesTotal());
        System.out.println("---------------------Parent-----------------------");
        System.out.println("Sex: 0-mother, 1-father");
        printList((List<T>) p.getParents());
        System.out.println("---------------------Children---------------------");
        printList((List<T>) p.getChildren());
    }

}
