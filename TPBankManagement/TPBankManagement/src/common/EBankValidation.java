
package common;

import java.util.ResourceBundle;

public class EBankValidation {
    ResourceBundle bun ;
     public EBankValidation(ResourceBundle bun) {
        this.bun = bun;
    }
    

    public String checkAccountNumber(String accountNumber) {
        if (accountNumber.matches("[0-9]{10}")) {
            return null;
        }
        return bun.getString("emsgAccNum");
    }

    public String checkPassword(String password) {
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
    

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaGenerate.contains(captchaInput)) {
            return null;
        }
        return bun.getString("emsgCapcha");
    }
    
}
