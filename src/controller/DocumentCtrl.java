package controller;

import dao.BookDAO;
import dao.DocumentDAO;
import model.Book;
import model.Document;

import java.util.List;
import java.util.Scanner;

public class DocumentCtrl implements Ctr<Document> {
    @Override
    public void show(Document p) {
        System.out.println(p);
    }

    @Override
    public Document addFromKeyBroad() {
        Scanner sc = new Scanner(System.in);
        String docId = "";
        DocumentDAO documentDAO = new DocumentDAO();
        System.out.println("Nhập tiêu đề: ");
        String docName = sc.nextLine();
        boolean isNamevalid = documentDAO.isNameValid(docName);
        while (!isNamevalid) {
            System.out.println("Tên tài liệu  đã tồn tại");
            System.out.println("Nhập tên  liệu:");
            docName = sc.nextLine();
            isNamevalid = documentDAO.isNameValid(docName);
        }
        System.out.println("Nhập tác giả: ");
        String author = sc.nextLine();
        boolean isOK = false;
        int amount = 0;
        int publishYear = 0;
        do {
            try {
                System.out.println("Nhập số lượng");
                amount = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập năm xuất bản");
                publishYear = Integer.parseInt(sc.nextLine());
                isOK = true;
            } catch (Exception e) {
                System.out.println("Nhập sai số lượng hoặc năm xuất bản");
            }
        } while (!isOK);
        Document doc = new Document(docId, docName, author, publishYear, amount);
        return doc;

    }

    public Document edit() {
        Scanner sc = new Scanner(System.in);
        String docId = "";
        System.out.println("Nhập tiêu đề: ");
        String docName = sc.nextLine();
        System.out.println("Nhập tác giả: ");
        String author = sc.nextLine();
        boolean isOK = false;
        int amount = 0;
        int publishYear = 0;
        do {
            try {
                System.out.println("Nhập số lượng");
                amount = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập năm xuất bản");
                publishYear = Integer.parseInt(sc.nextLine());
                isOK = true;
            } catch (Exception e) {
                System.out.println("Nhập sai số lượng hoặc năm xuất bản");
            }
        } while (!isOK);
        Document doc = new Document(docId, docName, author, publishYear, amount);
        return doc;
    }

    public void findByName() {
        System.out.println("Mời nhập tên cần tìm kiếm");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        BookDAO bookDAO = new BookDAO();
        List<Document> list = bookDAO.findByName(name);
        showList(list);
    }

    public void findByAuthor() {
        System.out.println("Mời nhập tên cần tìm kiếm");
        Scanner sc = new Scanner(System.in);
        String author = sc.nextLine();
        BookDAO bookDAOAuthor = new BookDAO();
        List<Document> listAuthor = bookDAOAuthor.findByAuthor(author);
        showList(listAuthor);
    }

    public void findByYear() {
        System.out.println("Mời nhập năm cần tìm kiếm");
        Scanner sc = new Scanner(System.in);
        int publishYear = 0;
        boolean isOK = false;
        do {
            try {
                publishYear = Integer.parseInt(sc.nextLine());
                isOK = true;
            } catch (Exception e) {
                System.out.println("Nhập sai năm xuất bản");
            }
        } while (!isOK);
        BookDAO bookDAOYear = new BookDAO();
        List<Book> listYear = bookDAOYear.findByYear(publishYear);
        if (listYear.size() > 0) {
            for (Document d : listYear) {
                System.out.println(d);
            }
        } else {
            System.out.println("Không có dữ liệu");
        }
    }

    public void findByType() {
        System.out.println("Mời nhập loại sách cần tìm kiếm");
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        BookDAO bookDAOType = new BookDAO();
        List<Document> listType = bookDAOType.findByType(type);
        showList(listType);
    }

    private void showList(List<Document> list) {
        if (list.size() > 0) {
            for (Document d : list) {
                System.out.println(d);
            }
        } else {
            System.out.println("Không có dữ liệu");
        }
    }
}
