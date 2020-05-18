package controller;

import dao.ReaderDAO;
import model.Person;
import model.Reader;

import java.util.Scanner;

public class ReaderCtrl extends PersonCtrl {
    @Override
    public Person addFromKeyBroad() {

        Person per = super.addFromKeyBroad();
        Scanner sc = new Scanner(System.in);
        String readerID = "";
        do {
            System.out.println("Nhập ID bạn đọc theo mẫu BD_xxxxxx(VD BD_123456):");
            readerID = sc.nextLine();
        } while (!checkID(readerID));
        ReaderDAO readerDAO = new ReaderDAO();
        boolean check = readerDAO.checkValidID(readerID);
        while (check) {
            System.out.println("Nhập căn cước công dân/chứng minh nhân dân: VD: 001234567891");
            readerID = sc.nextLine();
            check = readerDAO.checkValidID(readerID);
        }
        boolean isOK = false;
        int choice = 0;
        do {
            try {
                System.out.println("Nhập loại bạn đọc:");
                System.out.println("1. Giáo viên");
                System.out.println("2. Sinh viên");
                System.out.println("3. Học sinh");
                System.out.println("4. Nhân viên văn phòng");
                System.out.println("5. Các cụ, bô lão");
                System.out.println("6. Khác");
                choice = Integer.parseInt(sc.nextLine());
                isOK = true;
            } catch (Exception e) {
                System.out.println("Chọn sai mời chọn lại");
            }
        } while (!isOK);
        String[] arrType = {"Giáo viên", "Sinh viên", "Học sinh", "Nhân viên văn phòng", "Các cụ, bô lão", "khác"};
        String type = arrType[choice - 1];


        String phone = "";
        do {
            System.out.println("Nhập số điện thoại: ");
            phone = sc.nextLine();
        } while (!checkPhone(phone));


        String mail = "";
        do {
            System.out.println("Nhập email: ");
            mail = sc.nextLine();
        } while (!checkMail(mail));
        Reader reader = new Reader(per.getPersonID(), per.getFullName(), per.getAddress(),

                per.getDateOfBirth(), per.getGender(), readerID, type, phone, mail);

        readerDAO.add(reader);
        return reader;

    }

    private boolean checkID(String id) {
        String regex = "^BD_\\d{6}$";
        if (id.matches(regex)) {
            return true;
        }
        return false;
    }


    private boolean checkPhone(String phone) {
        String regexPhone = "^0[3,9]{1}\\d{8}$";
        if (phone.matches(regexPhone)) {
            return true;
        }
        return false;
    }

    private boolean checkMail(String mail) {
        String regexMail = "^\\w+@gmail.com";
        if (mail.matches(regexMail)) {
            return true;
        }
        return false;
    }
	/**
	 * 
	 * @param p
	 */
	public void show(Person p) {
        System.out.println(p);
	}

}