/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Expense;
import View.Menu;
import View.viewExpense;
import common.libraryExpense;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class expenseController extends Menu {
    List<Expense> expenseList;
    viewExpense v = new viewExpense();
    libraryExpense lib = new libraryExpense();
    public expenseController() {
        super("Handy Expense program", Arrays.asList(new String[]{"Add an expense","Display all expenses","Delete an expense","Quit"}));
        expenseList = new ArrayList();
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1->{    
            try {
                v.displayResultFunction(v.createExpense(expenseList), "Add expense");
            } catch (Exception ex) {
                Logger.getLogger(expenseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            case 2->{
                v.displayAll(expenseList);
            }
            case 3->{
            try {
                v.displayResultFunction(lib.deleteExpense(expenseList, v.findExpense(expenseList)), "Delete expense");
            } catch (Exception ex) {
                Logger.getLogger(expenseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            case 4->{
                System.exit(0);
            }
            
        }
    }
    
}
