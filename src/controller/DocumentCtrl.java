package controller;

import dao.DocumentDAO;
import model.Document;

import java.util.Scanner;

public class DocumentCtrl implements Ctr<Document> {

//    private boolean checkID(String id) {
//        String regex = "^DOC_\\d{6}$";
//        if (id.matches(regex)) {
//            return true;
//        }
//        System.out.println("sai mã tài liệu. Mời nhập lại: ");
//        return false;
//    }

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
                System.out.println("hello");
            } catch (Exception e) {
                System.out.println("Nhập sai số lượng hoặc năm xuất bản");
            }
        } while (!isOK);
        Document doc = new Document(docId, docName, author, publishYear, amount);
        return doc;

    }

}
