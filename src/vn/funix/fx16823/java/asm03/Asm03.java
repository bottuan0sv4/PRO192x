package vn.funix.fx16823.java.asm03;

import vn.funix.fx16823.java.asm03.models.*;


import java.util.Scanner;


public class Asm03 {
    // === Define variable ===
    private static final int EXIT_COMMAND_CODE = 0;
    private static final int EXIT_ERROR_CODE = -1;
    private static final Scanner sc = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "036099003551";
    private static final String CUSTOMER_NAME = "ANH TUAN";
    private static  Transaction[] transactions = new Transaction[1000];
    private static int transactionCount = 0;


    // === FUNCTION ===
    // Show Customer with CUSTOMER_ID;
    private static void showCustomer() {
        for(DigitalCustomer digitalCustomer : activeBank.getDigitalCustomers()) {
            if (CUSTOMER_ID.equals(digitalCustomer.getCustomerId())) {
                digitalCustomer.displayInformation();
            }
        }
    }

    // === FUNCTION 1 ===
    private static void function1() {
        showCustomer();
    }

    // === FUNCTION 2 ===
    // Check accountNumber is valid
    private static boolean checkAccountNumber(String accountNumber) {
        boolean checkAccountNumber = true;
        // Id.length = 12 character.
        if(accountNumber.length() != 6) checkAccountNumber = false;

        // Id is Number or notNumber?
        for (int i = 0; i < accountNumber.length(); i++) {
            String s = "";
            s += accountNumber.charAt(i);
            int intValue;
            try {
                intValue = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                checkAccountNumber = false;
                break;
            }
        }

        for (int i = 0; i < activeBank.getDigitalCustomers().size(); i++) {
            for (int j = 0; j < activeBank.getDigitalCustomers().get(i).getAccounts().size(); j++) {
                if(accountNumber.equals(activeBank.getDigitalCustomers().get(i).getLoanAccounts().get(j).getAccountNumber())) checkAccountNumber = false;
            }
        }

        for (int i = 0; i < activeBank.getDigitalCustomers().size(); i++) {
            for (int j = 0; j < activeBank.getDigitalCustomers().get(i).getAccounts().size(); j++) {
                if(accountNumber.equals(activeBank.getDigitalCustomers().get(i).getSavingsAccounts().get(j).getAccountNumber())) checkAccountNumber = false;
            }
        }
        return checkAccountNumber;
    }

    // Enter accountNumber and accountBalance => New Account
    private static vn.funix.fx16823.java.asm03.Account enterNewAccountCustomer(){
        // Enter accountNumber
        System.out.println("Nhap ma STK gom 6 chu so");
        String accountNumber = sc.next();
        // Check accountNumber
        while(!checkAccountNumber(accountNumber)) {
            System.out.println("STK chua chinh xac hoac da ton tai vui long nhap lai: ");
            accountNumber = sc.next();
        }
        // Enter the accountBalance
        System.out.println("Nhap so du: ");
        double accountBalance = sc.nextDouble();
        // Check accountBalance
        while(accountBalance < 50000) {
            System.out.println("So du tai khoan khong duoc thap hon 50,000đ, vui long nhap lai");
            accountBalance = sc.nextDouble();
        }
        vn.funix.fx16823.java.asm03.Account account = new vn.funix.fx16823.java.asm03.Account(accountNumber, accountBalance);

        return account;
    }

    private static void function2() {
        Transaction transaction = new Transaction();

        // Enter accountNumber and accountBalance =>
        vn.funix.fx16823.java.asm03.Account accountClassAccount = enterNewAccountCustomer();
        String accountNumber = accountClassAccount.getAccountNumber();
        double accountBalance = accountClassAccount.getBalance();

        // SavingsAccount
        SavingsAccount accountNew = new SavingsAccount(accountNumber, accountBalance );

        // Add SavingsAccount
        for(DigitalCustomer customer : activeBank.getDigitalCustomers()) {
            if (CUSTOMER_ID.equals(customer.getCustomerId())) {
                customer.addAccount(accountNew);
                transaction = new Transaction(accountNew.getAccountNumber(), accountBalance, accountNew.getDateTime(), true);
                transactions[transactionCount] = transaction;
                transactionCount++;
            }
        }
        System.out.println("Them thanh cong STK " + accountNew.getAccountNumber() + " voi so du : " + String.format("%,d", (long)accountNew.getBalance()) + " vnd" );
    }

    // === FUNCTION 3 ===
    private static void function3() {
        Transaction transaction = new Transaction();

        // Enter accountNumber and accountBalance =>
        vn.funix.fx16823.java.asm03.Account accountClassAccount = enterNewAccountCustomer();
        String accountNumber = accountClassAccount.getAccountNumber();
        double accountBalance = accountClassAccount.getBalance();

        // LoanAccount
        LoanAccount accountNew = new LoanAccount(accountNumber, accountBalance );


        // Add LoanAccount
        for(DigitalCustomer customer : activeBank.getDigitalCustomers()) {
            if (CUSTOMER_ID.equals(customer.getCustomerId())) {
                customer.addAccount(accountNew);
                transaction = new Transaction(accountNew.getAccountNumber(), accountBalance, accountNew.getDateTime(), true);
                transactions[transactionCount] = transaction;
                transactionCount++;
            }
        }
        System.out.println("Them thanh cong STK " + accountNew.getAccountNumber() + " voi so du : " + String.format("%,d", (long)accountNew.getBalance()) + " vnd" );
    }

    // === FUNCTION 4 ===

    private static void function4() {
        // Show all accounts
        showCustomer();
        System.out.println("0.    Thoat");
        Transaction transaction = new Transaction();

        // Enter for select the account to withdraw money
        System.out.println("Vui long chon tai khoan can rut tien");
        int accountOrder = sc.nextInt();

        // Check input data
        if (accountOrder == 0 ) return;
        int quantityAccount = 0;
        DigitalCustomer digitalCustomerCompare = new DigitalCustomer();
        for(DigitalCustomer digitalCustomer : activeBank.getDigitalCustomers()) {
            if (CUSTOMER_ID.equals(digitalCustomer.getCustomerId())) {
                quantityAccount = digitalCustomer.getLoanAccounts().size() +  digitalCustomer.getSavingsAccounts().size();
                digitalCustomerCompare = digitalCustomer;
            }
        }
        while (accountOrder < 0 || accountOrder > quantityAccount) {
            System.out.println("Chon KHONG THANH CONG, vui long chon lai tai khoan can rut tien");
            accountOrder = sc.nextInt();
            if (accountOrder == 0 ) return;
        }

        // Enter the amount to withdraw
        System.out.println("Nhap so tien can rut:");
        double amount = sc.nextDouble();
        boolean isWithdrawComplete = false;
//            while (!isWithdrawComplete) {
        if (accountOrder <= digitalCustomerCompare.getSavingsAccounts().size()) {
            SavingsAccount savingsAccountCompare = digitalCustomerCompare.getSavingsAccounts().get(accountOrder - 1);
            if (savingsAccountCompare.withdraw(amount)) {
                digitalCustomerCompare.withdraw(savingsAccountCompare.getAccountNumber(), amount);
                System.out.printf("%30s%n", "GIAO DICH THANH CONG");
                isWithdrawComplete = true;
                transaction = new Transaction(savingsAccountCompare.getAccountNumber(), -amount, savingsAccountCompare.getDateTime(), true);
            } else {
                transaction = new Transaction(savingsAccountCompare.getAccountNumber(), -amount, savingsAccountCompare.getDateTime(), false);
                System.out.println("Giao dich KHONG thanh cong, so tien con lai sau khi rut phai lon hon 50,000vnd va so tien can rut phai la boi so cua 10,000vnd  ");
//                        System.out.println("Vui long nhap lai so tien can rut (boi so cua 10,000 vnd):  ");
//                        amount = sc.nextDouble();
            }
        } else {
            LoanAccount loanAccountCompare = digitalCustomerCompare.getLoanAccounts().get(accountOrder - 1 - digitalCustomerCompare.getSavingsAccounts().size());
            if (loanAccountCompare.withdraw(amount)) {
                digitalCustomerCompare.withdraw(loanAccountCompare.getAccountNumber(), amount);
                System.out.printf("%30s%n", "GIAO DICH THANH CONG");
                isWithdrawComplete = true;
                transaction = new Transaction(loanAccountCompare.getAccountNumber(), -amount, loanAccountCompare.getDateTime(), true);
            } else {
                transaction = new Transaction(loanAccountCompare.getAccountNumber(), -amount, loanAccountCompare.getDateTime(), false);
                System.out.println("Giao dich KHONG thanh cong, so tien con lai sau khi rut phai lon hon 50,000vnd va so tien can rut phai la boi so cua 10,000vnd  ");
//                        System.out.println("Vui long nhap lai so tien can rut (boi so cua 10,000 vnd):  ");
//                        amount = sc.nextDouble();
            }
        }
//            }

        transactions[transactionCount] = transaction;
        transactionCount++;
    }

    // === FUNCTION 5 ===
    private static void function5() {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("+            LICH SU GIAO DICH             +");
        System.out.println("+----------+--------------------+----------+");
        showCustomer();
        System.out.println("+----------+--------------------+----------+");
        System.out.println(" Lich su giao dich chi tiet: ");

        if (transactions[0] != null) {
            for (int i = 0; i < transactionCount; i++) {
                System.out.print(i+1 + ".   " + transactions[i].getAccountNumber() + " |");
                System.out.printf("%10s",transactions[i].getId() + " |");
                System.out.printf("%17s",String.format("%,d", (long)transactions[i].getAmount())+" vnd|");
                System.out.printf("%22s",transactions[i].getTime()+" |");
                System.out.printf("%5s%n",transactions[i].isStatus());
            }
        }
        else System.out.printf("%40s%n","THONG BAO! CHUA CO LICH SU GIAO DICH!");
    }

    private static int displayChooseFunction(int functionNumber) {
        if((functionNumber < 0) || (functionNumber > 5)) {
            // Display Ngan Hang So
            System.out.println("-------------------------------------------");
            System.out.println("Ban da nhap sai chuc nang, xin hay nhap lai! ");
            System.out.print("Chuc nang:  ");
            functionNumber  = sc.nextInt();
        }
        else {
            System.out.println("+----------+--------------------+----------+");
            System.out.println("| 1. Thong tin khach hang                  |");
            System.out.println("| 2. Them tai khoan ATM                    |");
            System.out.println("| 3. Them tai khoan tin dung               |");
            System.out.println("| 4. Rut tien                              |");
            System.out.println("| 5. Lich su giao dich                     |");
            System.out.println("| 0. Thoat                                 |");
            System.out.println("+----------+--------------------+----------+");
            System.out.print("Chuc nang:  ");
            functionNumber = sc.nextInt();
        }
        return functionNumber;
    }


    public static void main(String[] args) {
        // INIT
        DigitalCustomer customer = activeBank.getCustomerById(CUSTOMER_ID);
        customer.setName(CUSTOMER_NAME);
        SavingsAccount accountSave = new SavingsAccount("000001", 50000000); // 50,000,000 vnd
        LoanAccount accountLoan = new LoanAccount("000002", 2000000000); // 2,000,000,000 vnd
        activeBank.addDigitalCustomer(customer);
        customer.addAccount(accountLoan);
        customer.addAccount(accountSave);
        showCustomer();

        // Display Ngan Hang So
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| NGAN HANG SO | FX16823@v3.0.0            |");
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| 1. Thong tin khach hang                  |");
        System.out.println("| 2. Them tai khoan ATM                    |");
        System.out.println("| 3. Them tai khoan tin dung               |");
        System.out.println("| 4. Rut tien                              |");
        System.out.println("| 5. Lich su giao dich                     |");
        System.out.println("| 0. Thoat                                 |");
        System.out.println("+----------+--------------------+----------+");

        System.out.print("Chuc nang:  ");
        int functionNumber = sc.nextInt();

        while (functionNumber != 0) {
            switch (functionNumber) {
                case EXIT_COMMAND_CODE:
                    break;
                case 1:
                    function1();
                    break;
                case 2:
                    function2();
                    break;
                case 3:
                    function3();
                    break;
                case 4:
                    function4();
                    break;
                case 5:
                    function5();
                    break;

            }
            functionNumber = displayChooseFunction(functionNumber);
        }





    }


}
