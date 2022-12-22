package vn.funix.fx16823.java.asm03.models;

import vn.funix.fx16823.java.asm03.Account;
import vn.funix.fx16823.java.asm03.Customer;

import java.util.ArrayList;
import java.util.List;

public class DigitalCustomer extends Customer {

    public DigitalCustomer() {
        this.loanAccounts = new ArrayList<>();
        this.savingsAccounts = new ArrayList<>();
    }

    public DigitalCustomer(String customerId) {
        this.setCustomerId(customerId);
        this.loanAccounts = new ArrayList<>();
        this.savingsAccounts = new ArrayList<>();
    }


    public DigitalCustomer(String customerId, String name) {
        super(customerId, name);
        this.loanAccounts = new ArrayList<>();
        this.savingsAccounts = new ArrayList<>();
    }
    private final List<LoanAccount> loanAccounts;
    private final List<SavingsAccount> savingsAccounts;

    public void addAccount(Account newAccount) {
        LoanAccount loanAccount = new LoanAccount(newAccount.getAccountNumber(), newAccount.getBalance());
        SavingsAccount savingsAccount = new SavingsAccount(newAccount.getAccountNumber(), newAccount.getBalance());

        if (newAccount.getBalance() >= 0 && isAccountExisted(newAccount.getAccountNumber()) && newAccount.getName().equals("LOAN"))
            loanAccounts.add(loanAccount);
        else if (newAccount.getBalance() >= 0 && isAccountExisted(newAccount.getAccountNumber()) && newAccount.getName().equals("SAVINGS"))
            savingsAccounts.add(savingsAccount);
        else {
            System.out.println("Them tai khoan " + newAccount.getAccountNumber() +" vao khach hang " + this.getName() +" => KHONG thanh cong!");
            System.out.println("=====================================================================");
        }
    }

    public List<LoanAccount> getLoanAccounts() {
        return loanAccounts;
    }
    public List<SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }

    @Override
    public void displayInformation(){
        // Get Data
        String customerId = this.getCustomerId();
        String customerName = this.getName();
        double customerBalance = this.getSumBalance();
        String formattedCustomerBalance = String.format("%,d", (long)customerBalance);


        boolean customerIsPremium = this.isPremium();
        String accountType = "Normal ";
        if (customerIsPremium) accountType = "Premium";

        // Display Data
        // Display data customers
        System.out.print(customerId + " | " + " ");
        for (int i = 0; i < 12 - customerName.length(); i++ ) System.out.print(" ");
        System.out.print(customerName);
        System.out.print("  | ");
        System.out.print(accountType + " | ");
        for (int i = 0; i < 14 - formattedCustomerBalance.length(); i++ ) System.out.print(" ");
        System.out.println(formattedCustomerBalance + " vnd");


        // Display data SavingsAccounts
        for (int i = 0; i < savingsAccounts.size(); i++) {
            int numberth = i+1;
            String accountNumber = savingsAccounts.get(i).getAccountNumber();
            String accountName = savingsAccounts.get(i).getName();
            double accountBalance = savingsAccounts.get(i).getBalance();
            String formattedAccountBalance = String.format("%,d", (long)accountBalance);

            System.out.print(numberth + ".    ");
            System.out.print(accountNumber + " |  ");
            for (int k = 0; k < 12 - accountName.length(); k++ ) System.out.print(" ");
            System.out.print(accountName);
            System.out.print("  | ");


            for (int j = 0; j < 24 - formattedAccountBalance.length(); j++ ) System.out.print(" ");
            System.out.println(formattedAccountBalance + " vnd");
        }

        // Display data LoanAccounts
        for (int i = 0; i < loanAccounts.size(); i++) {
            int numberth = savingsAccounts.size()+i+1;
            String accountNumber = loanAccounts.get(i).getAccountNumber();
            String accountName = loanAccounts.get(i).getName();
            double accountBalance = loanAccounts.get(i).getBalance();
            String formattedAccountBalance = String.format("%,d", (long)accountBalance);

            System.out.print(numberth + ".    ");
            System.out.print(accountNumber + " |  ");
            for (int k = 0; k < 12 - accountName.length(); k++ ) System.out.print(" ");
            System.out.print(accountName);
            System.out.print("  | ");


            for (int j = 0; j < 24 - formattedAccountBalance.length(); j++ ) System.out.print(" ");
            System.out.println(formattedAccountBalance + " vnd");
        }
    }


    public void withdraw(String accountNumber, double amount) {
        if(!this.isAccountExisted(accountNumber)) {
            for (SavingsAccount savingsAccount: savingsAccounts) {
                if(accountNumber.equals(savingsAccount.getAccountNumber())){
                    if(savingsAccount.withdraw(amount)) {
                        savingsAccount.setBalance(savingsAccount.getBalance()-amount);
                        savingsAccount.log(amount);
                    }
                    else System.out.println("Rut tien KHONG thanh cong");
                }
            }
            for (LoanAccount loanAccount: loanAccounts) {
                if(accountNumber.equals(loanAccount.getAccountNumber())){
                    if(loanAccount.withdraw(amount)) {
                        if (loanAccount.getBalance() >= 10000000)
                            loanAccount.setBalance(loanAccount.getBalance()-amount-amount*0.01);
                        else loanAccount.setBalance(loanAccount.getBalance()-amount-amount*0.05);
                        loanAccount.log(amount);
                    }
                    else System.out.println("Rut tien KHONG thanh cong");
                }
            }
        }
        else {
            System.out.println("Tai khoan khong ton tai");
        }
    }

    public double getSumBalance(){
        double sumBalance = 0;
        for (int i = 0; i < loanAccounts.size(); i++) {
            sumBalance += loanAccounts.get(i).getBalance();
        }
        for (int i = 0; i < savingsAccounts.size(); i++) {
            sumBalance += savingsAccounts.get(i).getBalance();
        }
        return sumBalance;
    }

    public boolean isAccountExisted(String accountNumber) {
        for (LoanAccount loanAccount: loanAccounts) {
            if (loanAccount.getAccountNumber().equals(accountNumber)){
                return false;
            }
        }
        for (SavingsAccount savingsAccount: savingsAccounts) {
            if (savingsAccount.getAccountNumber().equals(accountNumber)){
                return false;
            }
        }
        return true;
    }

    public boolean isPremium() {
        boolean isPremium = false;
        for (int i = 0; i < loanAccounts.size(); i++) {
            if(loanAccounts.get(i).isPremiumAccount()) isPremium = true;
        }
        for (int i = 0; i < savingsAccounts.size(); i++) {
            if(savingsAccounts.get(i).isPremiumAccount()) isPremium = true;
        }
        return isPremium;
    }
}
