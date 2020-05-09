package controller;

import dao.BookDAO;
import model.Book;
import model.Document;

import java.util.Scanner;

public class BookCtrl extends DocumentCtrl {
    private boolean checkID(String id) {
        String regex = "^DCMT_\\d{6}$";
        if (id.matches(regex)) {
            return true;
        }
        System.out.println("sai mã sách. Mời nhập lại: ");
        return false;
    }

    @Override
    public void show(Document p) {
        super.show(p);
    }


    @Override
    public Book addFromKeyBroad() {
        Document doc = super.addFromKeyBroad();
        Scanner sc = new Scanner(System.in);
        String bookID = "";
        System.out.println("Nhập mã sách:(ví dụ : DCMT_xxxxxx)");
        do {
            bookID = sc.nextLine();
        } while (!checkID(bookID));
        BookDAO bookDAO = new BookDAO();
        boolean idValid = bookDAO.isIDValid(bookID, "dbo.Book");
        while (!idValid) {
            System.out.println("Mã sách đã tồn tại!");
            System.out.println("Nhập mã sách:(ví dụ : DCMT_xxxxxx)");
            bookID = sc.nextLine();
            idValid = bookDAO.isIDValid(bookID, "dbo.Book");
        }
        doc.setDocID(bookID);
        String bookType;
        String kinds[] = {"Khoa học", "Nghệ thuật", "Kinh tế", "Ẩm thực", "Công nghệ thông tin"};
        boolean isOK = false;
        int choice = 0;
        do {
            try {
                System.out.println("Nhập loại sách:");
                System.out.println("1. Khoa học");
                System.out.println("2. Nghệ thuật");
                System.out.println("3. Kinh tế");
                System.out.println("4. Ẩm thực");
                System.out.println("5. Công nghệ thông tin");
                choice = Integer.parseInt(sc.nextLine());
                isOK = true;
            } catch (Exception e) {
                System.out.println("Nhập lại thể loại sách");
            }
        } while (!isOK);
        bookType = kinds[choice - 1];
        Book b = new Book(doc.getDocID(), doc.getDocumentName(), doc.getAuthor(), doc.getPublishYear(), doc.getQuantity()
                , bookID, bookType);
        return b;
    }

    public void editBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sách muốn sửa: ví dụ (DCMT_xxxxxx)");
        String bookID = "";
        do {
            bookID = sc.nextLine();
        } while (!checkID(bookID));
        BookDAO bookDAO = new BookDAO();

        boolean idValid = bookDAO.isIDValid(bookID, "dbo.Book");
        while (idValid) {
            System.out.println("Nhập lại mã sách muốn sửa: ví dụ (DCMT_xxxxxx)");
            bookID = sc.nextLine();
            idValid = bookDAO.isIDValid(bookID, "dbo.Book");
        }
//        DocumentCtrl documentCtrl = new DocumentCtrl();
//        Document doc = documentCtrl.addFromKeyBroad();
        Document doc = new Document(bookID);
//        doc.setDocID(bookID);
        String bookType;
        String kinds[] = {"Khoa học", "Nghệ thuật", "Kinh tế", "Ẩm thực", "Công nghệ thông tin"};
        boolean isOK = false;
        int choice = 0;
        do {
            try {
                System.out.println("Nhập loại sách:");
                System.out.println("1. Khoa học");
                System.out.println("2. Nghệ thuật");
                System.out.println("3. Kinh tế");
                System.out.println("4. Ẩm thực");
                System.out.println("5. Công nghệ thông tin");
                choice = Integer.parseInt(sc.nextLine());
                isOK = true;
            } catch (Exception e) {
                System.out.println("Nhập lại thể loại sách");
            }
        } while (!isOK);
        bookType = kinds[choice - 1];
        Book b = new Book(doc.getDocID(), bookID, bookType);
        boolean result = bookDAO.edit(bookID, b);
        if (result) {
            System.out.println("Sửa lại thông tin thành công");
        } else {
            System.out.println("Sửa lại thông tin thất bại");
        }
    }
}
