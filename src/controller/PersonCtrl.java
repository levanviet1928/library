package controller;


import model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonCtrl implements Ctr<Person> {
	private boolean checkID(String id) {
		String regex = "^BD_\\d{6}$";
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
			System.out.println("Nhập mã bạn đọc dạng BD_xxxxxx: ví dụ BD_12345: ");
			perID = sc.nextLine();
		} while (!checkID(perID));
		System.out.println("Nhập họ và tên");
		String fullName = sc.nextLine();
		System.out.println("Nhập địa chỉ");
		String address = sc.nextLine();
		String DOB;
		do {
			System.out.println("Nhập ngày tháng năm sinh: dạng dd-MM-yyyy(ví dụ 1999-12-22)");
			DOB = sc.nextLine();
		} while (!checkDate(DOB));
		Date date;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        do {

		try {
			date = format.parse(DOB);
		} catch (ParseException e) {
			e.printStackTrace();
//                System.out.println("Nhập sai định dạng. Mời nhập lại");
		}
//        } while (!checkDate(DOB));
		System.out.println("Nhập giới tính");
		String gender = sc.nextLine();
		System.out.println("");
		return null;
	}

	private boolean checkDate(String date) {
		String regexDate = "^\\d{4}-[0,1]{1}\\d{1}-[0-3]{1}\\d{1}";
		if (date.matches(regexDate)) {
			return true;
		}
		return false;
	}
//	private boolean chec
}