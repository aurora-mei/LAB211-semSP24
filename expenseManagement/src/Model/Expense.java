/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author THANH HUYEN
 */
public class Expense {

    private int ID;
    private String date;
    private double number;
    private String content;

    public Expense() {
    }

    public Expense(int ID, String date, double number, String content) {
        this.ID = ID;
        this.date = date;
        this.number = number;
        this.content = content;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate(Date date) {
        return String.format("%s", date.getDate());
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("%-5s%-15s%-10s%s", ID, date, number, content);
    }

}
