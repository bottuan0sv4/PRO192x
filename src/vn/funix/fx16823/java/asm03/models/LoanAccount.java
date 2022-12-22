package vn.funix.fx16823.java.asm03.models;

import vn.funix.fx16823.java.asm03.Account;
import vn.funix.fx16823.java.asm03.ReportService;
import vn.funix.fx16823.java.asm03.Withdraw;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LoanAccount extends Account implements ReportService, Withdraw {

    private static final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
    private static final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
    private static final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;
    private static final String name = "LOAN";


    public LoanAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }


    @Override
    public boolean withdraw(double amount) {
        if(this.isAccepted(amount)) {
            if (this.getBalance() >= 1000000 && this.getBalance() - amount - amount*LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE < 50000 ) {
                return false;
            }
            else if (this.getBalance() - amount - amount*LOAN_ACCOUNT_WITHDRAW_FEE < 50000) return false;

            return true;
        }
        return false;
    }

    public String getDateTime() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
    }

    public double getTransactionFee(double amount) {
        if (this.getBalance() > 10000000) return (amount*LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE);
        else return  (amount*LOAN_ACCOUNT_WITHDRAW_FEE);
    }

    @Override
    public void log(double amount) {
        System.out.println("------------------------------------------");
        System.out.printf("%30s%n", "BIEN LAI GIAO DICH LOAN");
        System.out.printf("NGAY GD: %30s%n", this.getDateTime() );
        System.out.printf("ATM ID: %31s%n", "DIGITAL_BANK_ATM 2022");
        System.out.printf("SO TK: %32s%n", this.getAccountNumber());
        System.out.printf("SO TIEN: %30s%n", String.format("%,d", (long)amount) + " vnd");
        System.out.printf("SO DU: %32s%n", String.format("%,d", (long)this.getBalance()) + " vnd");
        System.out.printf("PHI + VAT: %28s%n", String.format("%,d", (long)this.getTransactionFee(amount)) + " vnd");
        System.out.println("------------------------------------------");
    }

    @Override
    public boolean isAccepted(double amount) {
        if((amount >= 50000) && (amount % 10000 == 0)) {
            if ((amount > LOAN_ACCOUNT_MAX_BALANCE)) return false;
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

}
