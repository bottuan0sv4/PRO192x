package vn.funix.fx16823.java.asm02;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {

    private final String id;
    private final List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return id;
    }

    public boolean addCustomer(Customer newCustomer) {
        String customerIdNew = newCustomer.getCustomerId();
        if(!isCustomerExisted(customerIdNew)) {
            customers.add(newCustomer);
            System.out.println("=== Them khach hang thanh cong! === ");
            System.out.println("Ten khach hang moi: " + customers.get(customers.size()-1).getName() + " | So CCCD: " + customers.get(customers.size()-1).getCustomerId());
            System.out.println("So luong khach hang trong Ngan Hang hien tai: " + customers.size() + " khach hang.");
            return true;
        }
        else {
            System.out.println("Them khach hang KHONG thanh cong!");
            System.out.println("So CCCD da trung lap, vui long kiem tra lai! So CCCD: ");
            return false;
        }
    }

    public boolean isCustomerExisted(String customerId) {
        boolean isDuplicate = false;
        for(int i = 0; i < customers.size(); i++) {
            if(customerId.equals(customers.get(i).getCustomerId()))  {
                isDuplicate = true;
            }
        }
        return isDuplicate;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addAccount(String customerId, Account account) {
        for (int i = 0; i < customers.size(); i++) {
            if(customerId.equals(customers.get(i).getCustomerId())) {
                customers.get(i).addAccount(account);
            }
        }
    }
}
