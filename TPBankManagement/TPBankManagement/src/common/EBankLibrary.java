/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import Model.EBankAccount;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author THANH HUYEN
 */
public class EBankLibrary {

    public void setLocate(Locale locale) {
        Locale.setDefault(locale);
//        ResourceBundle bun = ResourceBundle.getBundle("common.MyBundle");
    }

    public String generateCaptcha() {
        ResourceBundle bun = ResourceBundle.getBundle("common.MyBundle");

        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            sb.append(randomChar);
        }
        return bun.getString("captcha") + sb.toString();
    }

    public void addLoggedAccount(HashMap<String, EBankAccount> hash, EBankAccount e) {
        hash.put(e.getAccNum(), e);
    }

}
