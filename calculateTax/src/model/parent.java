
package model;

public final class parent{
    private int age;
    private int sex;
    //1 is male,0 is female
    private boolean isRetire;
    private boolean havePension;
    private int deduction;

    public parent() {
    }

    public parent(int age, int sex, boolean havePension, int deduction) {
        this.age = age;
        this.sex = sex;
        setIsRetire();
        this.havePension = havePension;
        this.deduction = deduction;
    }


    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public boolean isIsRetire() {
        return isRetire;
    }

    public void setIsRetire() {
        if((this.age>=65 && sex == 1)||(this.age>=60 && sex ==0)){
            this.isRetire = true;
            return;
        }      
        this.isRetire = false;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public boolean isHavePension() {
        return havePension;
    }

    public void setHavePension(boolean havePension) {
        this.havePension = havePension;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    @Override
    public String toString() {
        return "parent{" + "age=" + age + ", sex=" + sex + ", isRetire=" + isRetire + ", havePension=" + havePension + ", deduction=" + deduction + '}';
    }


    
           
}
