/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author THANH HUYEN
 */
public class EBankAccount {
    private String accNum;
    private String password;

    public EBankAccount() {
    }

    public EBankAccount(String accNum, String password) {
        this.accNum = accNum;
        this.password = password;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "accNum: " + accNum + "\npassword: " + password;
    }
    
}
