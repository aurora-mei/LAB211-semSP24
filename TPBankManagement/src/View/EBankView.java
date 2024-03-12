/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.EBankAccount;
import common.EBankInputter;
import common.EBankLibrary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

public class EBankView {

    EBankInputter in = new EBankInputter();
    EBankLibrary lib = new EBankLibrary();

    public EBankAccount inputAccount() {
        ResourceBundle bun = ResourceBundle.getBundle("common.MyBundle");
        String accN, passW, captcha;
        String msg;
        do {
            accN = in.getStringFromInput(bun.getString("accNum"));
            msg = lib.checkAccountNumber(accN);
            if (msg != null) {
                System.out.println(msg);
            }
        } while (msg != null);
        do {
            passW = in.getStringFromInput(bun.getString("passw"));
            msg = lib.checkPassword(passW);
            if (msg != null) {
                System.out.println(msg);
            }
        } while (msg != null);
        String captchaGen = lib.generateCaptcha();
        System.out.println(captchaGen);
        do {
            captcha = in.getStringFromInput(bun.getString("enterCaptcha"));
            msg = lib.checkCaptcha(captcha, captchaGen);
            if (msg != null) {
                System.out.println(msg);
            }
        } while (msg != null);
        return new EBankAccount(accN,passW);
    }

    public void displayPro() {
        ResourceBundle bun = ResourceBundle.getBundle("common.MyBundle");
        Enumeration<String> keys = bun.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = bun.getString(key);
            System.out.println(key + ": " + value);
        }
    }
    public void displayHash(HashMap<String,EBankAccount> hash){
        System.out.println("\n===== LIST OF LOGGED USER =====");
        hash.forEach((key,value)->System.out.println(value.toString()+"\n"));
    }
}
