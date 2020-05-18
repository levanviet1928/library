package controller;


import dao.PersonDAO;
import model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonCtrl implements Ctr<Person> {
    private boolean checkID(String id) {
        String regex = "^\\d{12}$";
        if (id.matches(regex)) {
			return true;
		}
		return false;
	}

	@Override
	public void show(Person p) {

	}

	@Override
	public Person addFromKeyBroad() {
		Scanner sc = new Scanner(System.in);
		String perID = "";
		do {
            System.out.println("Nhập căn cước công dân/chứng minh nhân dân VD: 001234567891");
			perID = sc.nextLine();
		} while (!checkID(perID));

        PersonDAO personDAO = new PersonDAO();
        boolean check = personDAO.checkValidID(perID);
        while (check) {
            System.out.println("Căn cước đã tồn tại. Mời nhập lại: ");
            perID = sc.nextLine();
            check = personDAO.checkValidID(perID);
        }

		System.out.println("Nhập họ và tên");
		String fullName = sc.nextLine();
		System.out.println("Nhập địa chỉ");
		String address = sc.nextLine();
		String DOB;
		do {
			System.out.println("Nhập ngày tháng năm sinh: dạng dd-MM-yyyy(ví dụ 1999-12-22)");
			DOB = sc.nextLine();
		} while (!checkDate(DOB));
        Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = format.parse(DOB);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Nhập giới tính");
		String gender = sc.nextLine();
        Person per = new Person(perID, fullName, address, date, gender);
        return per;
	}

	private boolean checkDate(String date) {
        String regexDate = "^\\d{4}-[0,1]?\\d{1}-[0-3]{1}\\d{1}";
		if (date.matches(regexDate)) {
			return true;
		}
		return false;
	}
}