package vn.funix.fx16823.java.asm03;

public class Account {

    private Account() {}

    private String accountNumber;
    private double balance;
    private String name;



    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isPremiumAccount() {
        if(balance >= 10000000) return true;
        else return false;
    }

    public void to_String() {
        System.out.println(accountNumber + " |                          " + balance + "đ");
    }

    public String getName() {
        return name;
    }

}
