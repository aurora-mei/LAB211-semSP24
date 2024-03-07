/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Expense;
import java.util.Date;
import java.util.List;

import common.libraryExpense;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class viewExpense {

    libraryExpense lib = new libraryExpense();
    InputterExpense in = new InputterExpense();

    public Expense findExpense(List<Expense> list) {//tìm và trả về expense tương ứng
        displayTitle("Delete an expense",'-');
        int idK = in.getIntFromInput("Enter ID: ");
        List<Expense> res = list.stream().filter((aExpense) -> aExpense.getID() == idK).collect(Collectors.toList());
           if (res.isEmpty()) {
               System.out.println("Can not find the expense has ID "+idK);
            return null;
        }
        if (!res.isEmpty()) {
            return res.get(0);
        }   
        return null;
    }

    public boolean createExpense(List<Expense> list) throws Exception {
//nhập thông tin và truyền vào hàm check add có thành công không, nếu thành công trả về true, in ra succesfull,ngược lại fail
        displayTitle("Add an expense", '-');
        Date date = in.getFormattedDateFromInput("Enter Date (dd/mm/yyyy): ");
        double amount = in.getDoubleFromInput("Enter Amount: ");
        String content = in.getStringFromInput("Enter Content: ").trim();
        return lib.addExpense(list, date, amount, content);
    }

//display
    public void displayAll(List< Expense> list) throws NullPointerException {
        if (list.isEmpty()) {
            System.out.println("List expense is empty. There is nothing to display!");
            return;
        }
        displayTitle("Display all expenses", '-');
        System.out.println(String.format("%-5s%-15s%-10s%s", "ID", "Date", "Amount", "Content"));
        double total = 0;
        for (Expense con : list) {
            total += con.getNumber();
            System.out.println(con.toString());
        }
        System.out.println("Total: " + total);
    }

    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }

    public void displayResultFunction(boolean res, String functionName) {
        if (res) {
            System.out.println(functionName + " successfull!");
        } else {
            {
                System.out.println(functionName + " fail!");
            }
        }
    }

}
