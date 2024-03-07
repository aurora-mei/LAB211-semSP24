/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import Model.Expense;
import java.util.Date;
import java.util.List;

/**
 *
 * @author THANH HUYEN
 */
public class libraryExpense {

    private int counter = 1;

    public boolean addExpense(List<Expense> list, Date date, double amount, String content) throws Exception {
        //hàm add vào list, check xem add có thành công không
        Expense e = new Expense(autoID(), date.toString(), amount, content);
        try {
            list.add(e);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public int autoID() {
        return counter++;
    }

    public boolean deleteExpense(List<Expense> list, Expense exp) throws Exception{//thực thi xóa
        try {
            if(list.isEmpty()){
                System.out.println("List is empty.Can't delete any exp!");
                return false;
            }else if(exp==null){
                System.out.println("Expense want to delete is null!");
                return false;
            }
            list.remove(exp);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
