package vn.funix.fx16823.java.asm03.models;

import java.util.UUID;

public class Transaction {

    private  String id;
    private  String accountNumber;
    private  double amount;
    private  String time;
    private  boolean status;


    public Transaction() {
    }

    public Transaction(String accountNumber, double amount, String time, boolean status) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.time = time;
        this.status = status;
        this.id = getId();
    }

    public String getId() {
        id = String.valueOf(UUID.randomUUID()).substring(0,7);
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
