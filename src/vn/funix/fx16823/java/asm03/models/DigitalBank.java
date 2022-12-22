package vn.funix.fx16823.java.asm03.models;

import vn.funix.fx16823.java.asm03.Bank;

import java.util.ArrayList;
import java.util.List;

public class DigitalBank extends Bank {

    private final List<DigitalCustomer> digitalCustomers;



    public DigitalBank() {
        this.digitalCustomers = new ArrayList<>();
    }

    public DigitalCustomer getCustomerById(String customerId) {
        DigitalCustomer customer = new DigitalCustomer(customerId);
        if(!this.isCustomerExisted(customerId)) {
            return customer;
        }
        else {
            return null;
        }
    }


    public boolean addDigitalCustomer(DigitalCustomer digitalCustomer) {
        if(!isCustomerExisted(digitalCustomer.getCustomerId())) {
            digitalCustomers.add(digitalCustomer);
            System.out.println("=== Them khach hang thanh cong! === ");
            System.out.println("Ten khach hang moi: " + digitalCustomers.get(digitalCustomers.size()-1).getName() + " | So CCCD: " + digitalCustomers.get(digitalCustomers.size()-1).getCustomerId());
            System.out.println("So luong khach hang trong Ngan Hang hien tai: " + digitalCustomers.size() + " khach hang.");
            return true;
        }
        else {
            System.out.println("Them khach hang KHONG thanh cong!");
            System.out.println("So CCCD da trung lap, vui long kiem tra lai! So CCCD: ");
            return false;
        }
    }



    public void withdraw(String customerId, String accountNumber, double amount ) {}

    public List<DigitalCustomer> getDigitalCustomers() {
        return digitalCustomers;
    }

}
