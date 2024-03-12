/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.EBankAccount;
import View.EBankMenu;
import View.EBankView;
import common.EBankLibrary;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author THANH HUYEN
 */
public class EBankController extends EBankMenu {
 HashMap<String,EBankAccount> hash = new HashMap<>();
    EBankView view = new EBankView();
    EBankLibrary lib = new EBankLibrary();

    public EBankController() {
        super("Login Program", Arrays.asList(new String[]{"Vietnamese", "English", "Exit"}));
    }

    @Override
    public void execute(int choice) {
       
        switch (choice) {
            case 1 -> {
                lib.setLocate(new Locale("vi", "VN"));
                lib.addLoggedAccount(hash, view.inputAccount());
                view.displayHash(hash);
            }
            case 2 -> {
                lib.setLocate(new Locale("en", "US"));
                lib.addLoggedAccount(hash, view.inputAccount());
                view.displayHash(hash);
            }
            case 3->{
                System.exit(0);
            }
        }
    }
}
