/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import Model.EBankAccount;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.UUID;

public class EBankLibrary {

    public void setLocate(Locale locale) {
        Locale.setDefault(locale);
//        ResourceBundle bun = ResourceBundle.getBundle("common.MyBundle");
    }

    public String checkAccountNumber(String accountNumber) {
        ResourceBundle bun = ResourceBundle.getBundle("common.MyBundle");
        if (accountNumber.matches("[0-9]{10}")) {
            return null;
        }
        return bun.getString("emsgAccNum");
    }

    public String checkPassword(String password) {
        ResourceBundle bun = ResourceBundle.getBundle("common.MyBundle");
        if (password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$")) {
            return null;
        }
        return bun.getString("emsgPassW");
    }

//    public String generateCaptcha() {
//        ResourceBundle bun = ResourceBundle.getBundle("common.MyBundle");
//        Set<Character> charSet = new LinkedHashSet<>();
//        String uuid = UUID.randomUUID().toString().replace("-", "");
//        for (char c : uuid.toCharArray()) {
//            charSet.add(c);
//            if (charSet.size() == 5) {
//                break;
//            }
//        }
//        StringBuilder sb = new StringBuilder(5);
//        for (Character c : charSet) {
//            sb.append(c);
//        }
//        return bun.getString("captcha") + sb.toString();
//    }
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

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        ResourceBundle bun = ResourceBundle.getBundle("common.MyBundle");
        if (captchaGenerate.contains(captchaInput)) {
            return null;
        }
        return bun.getString("emsgCapcha");
    }
    public void addLoggedAccount(HashMap<String,EBankAccount> hash,EBankAccount e){
         hash.put(e.getAccNum(), e);
    }
}
