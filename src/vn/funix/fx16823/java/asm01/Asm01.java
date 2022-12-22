package vn.funix.fx16823.java.asm01;
import java.util.Scanner;


public class Asm01 {


    // Kiem tra tung ky tu trong Ma CCCD
    public static boolean checkMaCCCD(String maCCCD) {
        boolean checkMaCCCD = true;
        for (int i = 0; i < maCCCD.length(); i++) {
            String s = "";
            s += maCCCD.charAt(i);
            int intValue;
            try {
                intValue = Integer.parseInt(s);
                checkMaCCCD = true;
            } catch (NumberFormatException e) {
                checkMaCCCD = false;
                break;
            }
        }
        return checkMaCCCD;
    }

    public static int  taoMaXacThuc() {
        double random = 1;
        while (random  < 100) {
            random = Math.random()*1000+1;
        }
        int maxacthuc = (int) random;
        return maxacthuc;
    }

    //Function chuc nang CCCD
    public static int  chucnangCCCD() {
        Scanner sc = new Scanner(System.in);
        int maChucNangCCCD;
        System.out.println("     | 1. Kiem tra noi sinh");
        System.out.println("     | 2. Kiem tra tuoi, gioi tinh");
        System.out.println("     | 3. Kiem tra so ngau nhien");
        System.out.println("     | 0. Thoat");
        System.out.print("Chuc nang:  ");
        maChucNangCCCD = sc.nextInt();
        return maChucNangCCCD;
    }

    public static String ktNoiSinh(String maCCCD) {
        String noisinh = "None";
        String maNoiSinh = "";
        if(maCCCD.length() == 12)
            for (int i = 0; i <= 2; i++) {
                maNoiSinh += maCCCD.charAt(i);
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
        return noisinh;
    }

    public static void ktTuoi_GioiTinh(String maCCCD) {
        String maGioiTinhS = "";
        maGioiTinhS +=  maCCCD.charAt(3);
        int maGioiTinh = Integer.parseInt(maGioiTinhS);
        String gioitinh = "";

        String maTuoi = "";
        maTuoi += maCCCD.charAt(4);
        maTuoi += maCCCD.charAt(5);
        int tuoi = Integer.parseInt(maTuoi);

        if (maGioiTinh == 0 || maGioiTinh == 2 || maGioiTinh == 4 || maGioiTinh == 6 || maGioiTinh == 8) gioitinh = "Nam";
        else gioitinh = "Nu";

        if (maGioiTinh == 0 || maGioiTinh == 1) tuoi += 1900;
        else if (maGioiTinh == 2 || maGioiTinh == 3) tuoi += 2000;
        else if (maGioiTinh == 4 || maGioiTinh == 5) tuoi += 2100;
        else if (maGioiTinh == 6 || maGioiTinh == 7) tuoi += 2200;
        else if (maGioiTinh == 8 || maGioiTinh == 9) tuoi += 2300;
        System.out.println("Gioi tinh: " + gioitinh + " | " + tuoi);
    }

    public static void ktSoNgauNhien(String maCCCD) {
        String maSoNgauNhien = "";
        for (int i = 6 ; i <= 11; i++) {
            maSoNgauNhien += maCCCD.charAt(i);
        }
//        int songaunhien;
//        songaunhien = Integer.parseInt(maSoNgauNhien);
//        System.out.println(songaunhien);
        System.out.println("So Ngau Nhien: " + maSoNgauNhien);
    }


    public static void main(String[] args) {
        // Giao dien
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| NGAN HANG SO | FX16823@v1.0.0            |");
        System.out.println("+----------+--------------------+----------+");
        System.out.println("| 1. Nhap CCCD                             |");
        System.out.println("| 0. Thoat                                 |");
        System.out.println("+----------+--------------------+----------+");

        // Nhap chuc nang
        Scanner sc = new Scanner(System.in);
        System.out.print("Chuc nang:  ");
        int chucnang  = sc.nextInt();
        while ((chucnang != 0) && (chucnang != 1)) {
            System.out.println("-------------------------------------------");
            System.out.println("Ban da nhap sai, xin hay nhap lai ");
            System.out.println("| 1. Nhap CCCD");
            System.out.println("| 0. Thoat");
            System.out.print("Chuc nang:  ");
            chucnang  = sc.nextInt();
        }

        // Chuong trinh chon chuc nang la 1
        if (chucnang == 1) {
            //Tao ma xac thuc
            int maxacthuc = taoMaXacThuc();
            System.out.println("Nhap ma xac thuc: " + maxacthuc );

            // Nhap ma xac thuc
            int maxacnhan = sc.nextInt();
            while (maxacnhan != maxacthuc) {
                System.out.println("Ma xac thuc khong dung, vui long thu lai: " + maxacthuc);
                maxacnhan = sc.nextInt();
            }

            // Nhap so CCCD
            System.out.print("Vui long nhap CCCD:  ");
            String maCCCD = sc.next();
            String checkNoiSinh = ktNoiSinh(maCCCD);
            boolean checkNumMaCCCD = checkMaCCCD(maCCCD);

            // Kiem tra nhap CCCD
            while ( maCCCD.length() != 12 || checkNoiSinh == "None" || checkNumMaCCCD == false) {
                System.out.print("So CCCD khong hop le hoac khong ton tai,vui long nhap lai CCCD: ");
                maCCCD = sc.next();
                checkNoiSinh = ktNoiSinh(maCCCD);
                checkNumMaCCCD = checkMaCCCD(maCCCD);
            }

            // Chuc nang CCCD
            int maChucNangCCCD;
            maChucNangCCCD = chucnangCCCD();
            while (maChucNangCCCD != 0) {
                if (maChucNangCCCD < 0 || maChucNangCCCD > 3) {
                    System.out.println("Nhap chuc nang khong chinh xac, vui long nhap lai!");
                }
                else {
                    switch (maChucNangCCCD) {
                        case 1:
                            System.out.println("Noi sinh: " + ktNoiSinh(maCCCD));
                            break;
                        case 2:
                            ktTuoi_GioiTinh(maCCCD);
                            break;
                        case 3:
                            ktSoNgauNhien(maCCCD);
                            break;
                        case 0:
                            break;
                    }

                }
                maChucNangCCCD = chucnangCCCD();
            }
        }


    }
}

