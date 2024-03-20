/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class child implements Comparable<child>{
        private String name;
       private int age;
       private boolean isStudying;
       private int deduction;

    public child() {
    }

    public child(String name, int age, boolean isStudying, int deduction) {
        this.name = name;
        this.age = age;
        this.isStudying = isStudying;
        this.deduction = deduction;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIsStudying() {
        return isStudying;
    }

    public void setIsStudying(boolean isStudying) {
        this.isStudying = isStudying;
    }

    @Override
    public String toString() {
        return "child{" + "name=" + name + ", age=" + age + ", isStudying=" + isStudying + ", deduction=" + deduction + '}';
    }


    @Override
    public int compareTo(child o) {
        return o.deduction -this.deduction;
    }
       
        }