package vn.funix.fx16823.java.asm02;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    public Customer(String name, String customerId) {
        super(name, customerId);
        this.accounts = new ArrayList<>();
    }

    private final List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremium() {
        boolean isPremium = false;
        for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).isPremiumAccount()) isPremium = true;
        }
        return isPremium;
    }

    public void addAccount(Account newAccount) {
        if (newAccount.getBalance() >= 0 && isAccountExisted(newAccount.getAccountNumber()))
            accounts.add(newAccount);
        else {
            System.out.println("Them tai khoan " + newAccount.getAccountNumber() +" vao khach hang " + this.getName() +" => KHONG thanh cong!");
            System.out.println("=====================================================================");
        }

    }

    public double getSumBalance(){
        double sumBalance = 0;
        for (int i = 0; i < accounts.size(); i++) {
            sumBalance += accounts.get(i).getBalance();
        }
        return sumBalance;
    }

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


        // Display data accounts
        for (int i = 0; i < accounts.size(); i++) {
            int numberth = i+1;
            String accountNumber = accounts.get(i).getAccountNumber();
            double accountBalance = accounts.get(i).getBalance();
            String formattedAccountBalance = String.format("%,d", (long)accountBalance);

            System.out.print(numberth + "     ");
            System.out.print(accountNumber + " |");
            for (int j = 0; j < 42 - formattedAccountBalance.length(); j++ ) System.out.print(" ");
            System.out.println(formattedAccountBalance + " vnd");
        }
    }

    public boolean isAccountExisted(String accountNumber) {
        for (Account account: accounts) {
            if (account.getAccountNumber().equals(accountNumber))
                return false;
        }
        return true;
    }
}
