package vn.funix.fx16823.java.asm02;

import java.util.Scanner;

public class Asm02 {

    private static final Bank bank = new Bank();

    // ==== FUNCTION ===
    // == Chuc nang 1 ==
    // Check CCCD(id) is valid
    public static boolean setCustommerID(String id){
        boolean checkId = true;
        // Id.length = 12 character.
        if(id.length() != 12) checkId = false;

        // Id is Number or notNumber?
        for (int i = 0; i < id.length(); i++) {
            String s = "";
            s += id.charAt(i);
            int intValue;
            try {
                intValue = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                checkId = false;
                break;
            }
        }

        // The first 3 characters of a valid ID
        String noisinh = "None";
        String maNoiSinh = "";
        if (id.length() > 3)
            for (int i = 0; i <= 2; i++) {
                maNoiSinh += id.charAt(i);
            }

        switch (maNoiSinh) {
            case "001":
                noisinh = "Ha Noi";
                break;
            case "002":
                noisinh = "Ha Giang";
                break;
            case "004":
                noisinh = "Cao Bang";
                break;
            case "006":
                noisinh = "Bac Kan";
                break;
            case "008":
                noisinh = "Tuyen Quang";
                break;
            case "010":
                noisinh = "Lao Cai";
                break;
            case "011":
                noisinh = "Dien Bien";
                break;
            case "012":
                noisinh = "Lai Chau";
                break;
            case "014":
                noisinh = "Son La";
                break;
            case "015":
                noisinh = "Yen Bai";
                break;
            case "017":
                noisinh = "Hoa Binh";
                break;
            case "019":
                noisinh = "Thai Nguyen";
                break;
            case "020":
                noisinh = "Lang Son";
                break;
            case "022":
                noisinh = "Quang Ninh";
                break;
            case "024":
                noisinh = "Bac Giang";
                break;
            case "025":
                noisinh = "Phu Tho";
                break;
            case "026":
                noisinh = "Vinh Phuc";
                break;
            case "027":
                noisinh = "Bac Ninh";
                break;
            case "030":
                noisinh = "Hai Duong";
                break;
            case "031":
                noisinh = "Hai Phong";
                break;
            case "033":
                noisinh = "Hung Yen";
                break;
            case "034":
                noisinh = "Thai Binh";
                break;
            case "035":
                noisinh = "Ha Nam";
                break;
            case "036":
                noisinh = "Nam Dinh";
                break;
            case "037":
                noisinh = "Ninh Binh";
                break;
            case "038":
                noisinh = "Thanh Hoa";
                break;
            case "040":
                noisinh = "Nghe An";
                break;
            case "042":
                noisinh = "Ha Tinh";
                break;
            case "044":
                noisinh = "Quang Binh";
                break;
            case "045":
                noisinh = "Quang Tri";
                break;
            case "046":
                noisinh = "Thua Thien Hue";
                break;
            case "048":
                noisinh = "Da Nang";
                break;
            case "049":
                noisinh = "Quang Nam";
                break;
            case "051":
                noisinh = "Quang Ngai";
                break;
            case "052":
                noisinh = "Binh Dinh";
                break;
            case "054":
                noisinh = "Phu Yen";
                break;
            case "056":
                noisinh = "Khanh Hoa";
                break;
            case "058":
                noisinh = "Ninh Thuan";
                break;
            case "060":
                noisinh = "Binh Thuan";
                break;
            case "062":
                noisinh = "Kon Tum";
                break;
            case "064":
                noisinh = "Gia Lai";
                break;
            case "066":
                noisinh = "Dak Lak";
                break;
            case "067":
                noisinh = "Dak Nong";
                break;
            case "068":
                noisinh = "Lam Dong";
                break;
            case "070":
                noisinh = "Binh Phuoc";
                break;
            case "072":
                noisinh = "Tay Ninh";
                break;
            case "074":
                noisinh = "Binh Duong";
                break;
            case "075":
                noisinh = "Dong Nai";
                break;
            case "077":
                noisinh = "Ba Ria - Vung Tau";
                break;
            case "079":
                noisinh = "Ho Chi Minh";
                break;
            case "080":
                noisinh = "Long An";
                break;
            case "082":
                noisinh = "Tien Giang";
                break;
            case "083":
                noisinh = "Ben Tre";
                break;
            case "084":
                noisinh = "Tra Vinh";
                break;
            case "086":
                noisinh = "Vinh Long";
                break;
            case "087":
                noisinh = "Dong Thap";
                break;
            case "089":
                noisinh = "An Giang";
                break;
            case "091":
                noisinh = "Kien Giang";
                break;
            case "092":
                noisinh = "Can Tho";
                break;
            case "093":
                noisinh = "Hau Giang";
                break;
            case "094":
                noisinh = "Soc Trang";
                break;
            case "095":
                noisinh = "Bac Lieu";
                break;
            case "096":
                noisinh = "Ca Mau";
                break;
        }
        if(noisinh.equals("None") == true) checkId = false;

        return checkId;
    }

    public static void chucnang1() {
        Scanner sc = new Scanner(System.in);

        // Enter customer name and customerId
        System.out.println("Nhap ten khach hang: ");
        String customerName = sc.next();
        System.out.println("Nhap so CCCD: ");
        String customerId = sc.next();

        // Check customerId
        while (!setCustommerID(customerId)) {
            System.out.println("Ma CCCD chua hop le, vui long nhap lai");
            customerId = sc.next();
        }

        // Add New Customer
        Customer customerNew = new Customer(customerName, customerId);
        while (!bank.addCustomer(customerNew)){
            customerId = sc.next();
            customerNew = new Customer(customerName, customerId);
        }
    }

    // == Chuc nang 2 ==
    // Check accountNumber is valid
    public static boolean checkAccountNumber(String accountNumber) {
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

        for (int i = 0; i < bank.getCustomers().size(); i++) {
            for (int j = 0; j < bank.getCustomers().get(i).getAccounts().size(); j++) {
                if(accountNumber.equals(bank.getCustomers().get(i).getAccounts().get(j).getAccountNumber())) checkAccountNumber = false;
            }
        }
        return checkAccountNumber;
    }

    // Enter accountNumber and accountBalance => New Account
    public static Account enterNewAccountCustomer(){
        Scanner sc = new Scanner(System.in);

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
        Account account = new Account(accountNumber, accountBalance);

        return account;
    }

    public static void chucnang2() {
        Scanner sc = new Scanner(System.in);

        // Enter customerId
        System.out.println("Nhap CCCD khach hang: ");
        String customerId = sc.next();
        // Check customerId
        while(!setCustommerID(customerId) || !bank.isCustomerExisted(customerId)) {
            System.out.println("CCCD chua chinh xac hoac khong ton tai vui long nhap lai: ");
            customerId = sc.next();
        }

        // Enter accountNumber and accountBalance =>
        Account accountNew = enterNewAccountCustomer();

        // Add accountNumber
        bank.addAccount(customerId, accountNew);
        System.out.println("Them thanh cong STK " + accountNew.getAccountNumber() + " voi so du : " + String.format("%,d", (long)accountNew.getBalance()) + "vnd vao khach hang co ma CCCD : " + customerId );
    }

    // == Chuc nang 3 ==
    public static void chucnang3() {
        System.out.println("+----------+--------------------+----------+-----------------+");
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            bank.getCustomers().get(i).displayInformation();
            System.out.println("+----------+--------------------+----------+-----------------+");
        }


    }

    // == Chuc nang 4 ==

    public static void searchCustomerByCCCD(String customerId) {
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            if (customerId.equals(bank.getCustomers().get(i).getCustomerId())) {
                System.out.println("+----------+--------------------+----------+-----------------+");
                bank.getCustomers().get(i).displayInformation();
            }
        }
        System.out.println("+----------+--------------------+----------+-----------------+");
    }

    public static void chucnang4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("+----------+--------------------+----------+");

        // Enter customerId
        System.out.println("Nhap CCCD khach hang can tim (12 ky tu): ");
        String customerId = sc.next();
        // Check customerId
        while(!setCustommerID(customerId) || !bank.isCustomerExisted(customerId)) {
            System.out.println("CCCD chua chinh xac hoac khong ton tai vui long nhap lai (12 ky tu): ");
            customerId = sc.next();
        }

        // Check and display data acording to customerID
        searchCustomerByCCCD(customerId);
    }

    // == Chuc nang 5 ==

    public static void searchCustomerByName(String customerName) {
        boolean isFindFolowCustomerName = false;
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            if (bank.getCustomers().get(i).getName().toLowerCase().contains(customerName.toLowerCase())) {
                isFindFolowCustomerName = true;
                bank.getCustomers().get(i).displayInformation();
            }
        }
        if (!isFindFolowCustomerName)
            System.out.println("Khong tim duoc khach hang theo ky tu : " + customerName);
        System.out.println("+----------+--------------------+----------+-----------------+");
    }
    public static void chucnang5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("+----------+--------------------+----------+");

        // Enter customerName
        System.out.println("Nhap ten khach hang can tim: ");
        String customerName = sc.next();

        // searchCustomerByName
        searchCustomerByName(customerName);
    }

    // == Chon chuc nang ==
    public static int displayChooseFunction(int functionNumber) {
        Scanner sc = new Scanner(System.in);
        if ((functionNumber < 0) || (functionNumber > 5)) {
            System.out.println("-------------------------------------------");
            System.out.println("Ban da nhap sai chuc nang, xin hay nhap lai ");
        }

        System.out.println("+----------+--------------------+----------+");
        System.out.println("| 1. Them khach hang                       |");
        System.out.println("| 2. Them tai khoan cho khach hang         |");
        System.out.println("| 3. Hien thi danh sach khach hang         |");
        System.out.println("| 4. Tim theo CCCD                         |");
        System.out.println("| 5. Tim theo ten khac hang                |");
        System.out.println("| 0. Thoat                                 |");
        System.out.println("+----------+--------------------+----------+");
        System.out.print("Chuc nang:  ");
        functionNumber  = sc.nextInt();

        return functionNumber;
    }


    // === Main ===
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Display Ngan Hang So
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| NGAN HANG SO | FX16823@v2.0.0            |");
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| 1. Them khach hang                       |");
        System.out.println("| 2. Them tai khoan cho khach hang         |");
        System.out.println("| 3. Hien thi danh sach khach hang         |");
        System.out.println("| 4. Tim theo CCCD                         |");
        System.out.println("| 5. Tim theo ten khac hang                |");
        System.out.println("| 0. Thoat                                 |");
        System.out.println("+----------+--------------------+----------+");

        // Data test
        Customer customer1 = new Customer("AnhTuan","036099003551");
        Account accountCustomer1_1 = new Account("123451", 150000000);
        Account accountCustomer1_2 = new Account("123452", 5000000);
        Account accountCustomer1_3 = new Account("123453", 250000000);
        customer1.addAccount( accountCustomer1_1);
        customer1.addAccount( accountCustomer1_2);
        customer1.addAccount( accountCustomer1_3);
        bank.addCustomer(customer1);

        Customer customer2 = new Customer("TuanAnh","012345678911");
        Account accountCustomer2_1 = new Account("123461", 1000000);
        Account accountCustomer2_2 = new Account("123462", 9000000);
        Account accountCustomer2_3 = new Account("123463", 5000000);
        customer2.addAccount( accountCustomer2_1);
        customer2.addAccount( accountCustomer2_2);
        customer2.addAccount( accountCustomer2_3);
        bank.addCustomer(customer2);



        // Chose the function
        System.out.print("Chuc nang:  ");
        int chucnangNumber = sc.nextInt();

        while (chucnangNumber != 0) {
            switch (chucnangNumber) {
                case 0:
                    break;
                case 1:
                    chucnang1();
                    break;
                case 2:
                    chucnang2();
                    break;
                case 3:
                    chucnang3();
                    break;
                case 4:
                    chucnang4();
                    break;
                case 5:
                    chucnang5();
                    break;

            }
            chucnangNumber = displayChooseFunction(chucnangNumber);
        }

    }
}
