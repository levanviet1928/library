package view;

import controller.BookCtrl;
import controller.ReaderCtrl;
import dao.BookDAO;
import dao.DocumentDAO;
import model.Book;
import model.Person;

import java.util.Scanner;


public class view {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        view v = new view();

        int choice = 0;
        do {
            System.out.println("----------------- QUẢN LÝ THƯ VIỆN -----------------");
            System.out.println("1. Quản lý thông tin tài liệu");
            System.out.println("2. Quản lý bạn đọc ");
            System.out.println("3. Quản lý nhân viên");
            System.out.println("4. Quản lý thông tin mượn trả ");
            System.out.println("5. Quản lý phiếu mượn");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);


            switch (choice) {
                case 1:
                    v.docFunction();
                    break;
                case 2:
                    v.readerFun();
                    break;
                case 3:
                    v.EmployeeFun();
                    break;
                case 4:
                    v.borrowFun();
                    break;
                case 5:
                    v.billFun();
                    break;
                case 0:
                    System.out.println("-------------------CẢM ƠN QUÝ KHÁCH-------------------");
                    System.exit(0);
                default:
                    System.out.println("Nhập sai chức năng!");
            }
        } while (choice != 0);

    }


    private int docFunction() {
        int n = 0;
        do {
            System.out.println("----------------- QUẢN LÝ THÔNG TIN TÀI LIỆU -----------------");
            System.out.println("1. Nhập thêm sách mới");
            System.out.println("2. Sửa thông tin đầu sách theo mã");
            System.out.println("3. Xóa sách ");
            System.out.println("4. Tìm kiếm sách theo thông tin:");
            System.out.println("0. Quay lại");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            switch (n) {
                case 1:
                    System.out.println("Nhập thông tin sách");
                    BookCtrl bookCtrl = new BookCtrl();
                    Book book = bookCtrl.addFromKeyBroad();
                    BookDAO bookDAO = new BookDAO();
                    bookDAO.add(book);
                    bookCtrl.show(book);
                    break;
                case 2:
                    System.out.println("Sửa thông tin sách");
                    BookCtrl bookCtrlEdit = new BookCtrl();
                    bookCtrlEdit.editBook();
                    break;
                case 3:
                    System.out.println("Xóa sách");
                    deleteBook();
                    break;
                case 4:
                    System.out.println("Tìm kiếm sách theo thông tin");
                    searchBookMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;

    }

    private void deleteBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sách muốn xóa: ví dụ (DCMT_xxxxxx)");
        String bookID = sc.nextLine();
        BookDAO bookDAO = new BookDAO();
        DocumentDAO documentDAO = new DocumentDAO();
        boolean idValid = bookDAO.isIDValid(bookID, "dbo.Book");
        while (idValid) {
            System.out.println("Mã không tồn tại. Nhập lại:");
            bookID = sc.nextLine();
            idValid = bookDAO.isIDValid(bookID, "dbo.Book");
        }
        boolean result = bookDAO.remove(bookID);
        boolean resultDoc = documentDAO.remove(bookID);
        if (result && resultDoc) {
            System.out.println("Xóa sách thành công");
        } else {
            System.out.println("Xóa sách thất bại");
        }
    }

    private int searchBookMenu() {
        int n = 0;

        do {
            System.out.println("-----------------TÌM KIẾM SÁCH -----------------");
            System.out.println("1. Theo tên sách");
            System.out.println("2. Theo tên tác giả");
            System.out.println("3. Năm xuất bản ");
            System.out.println("4. Thể loại");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            switch (n) {
                case 1:
                    System.out.println("Tìm kiếm theo tên");
                    BookCtrl bookCtrl = new BookCtrl();
                    bookCtrl.findByName();
                    break;
                case 2:
                    System.out.println("Tìm kiếm theo tác giả");
                    BookCtrl bookCtrlAuthor = new BookCtrl();
                    bookCtrlAuthor.findByAuthor();
                    break;
                case 3:
                    System.out.println("Tìm kiếm theo năm xuất bản");
                    BookCtrl bookCtrlYear = new BookCtrl();
                    bookCtrlYear.findByYear();
                    break;
                case 4:
                    System.out.println("Tìm kiếm theo thể loại sách");
                    BookCtrl bookCtrlType = new BookCtrl();
                    bookCtrlType.findByType();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;
    }


    private int readerFun() {
        int n = 0;
        do {
            System.out.println("----------------- QUẢN LÝ THÔNG TIN BẠN ĐỌC -----------------");
            System.out.println("1. Nhập thêm bạn đọc mới mới");
            System.out.println("2. Sửa thông tin bạn đọc");
            System.out.println("3. Xóa bạn đọc ");
            System.out.println("4. Tìm kiếm bạn đọc theo thông tin:");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            switch (n) {
                case 1:
                    System.out.println("Nhập mới bạn đọc");
                    ReaderCtrl readerCtrl = new ReaderCtrl();
                    Person reader = readerCtrl.addFromKeyBroad();
                    if (reader != null) {
                        readerCtrl.show(reader);
                        System.out.println("Thêm dữ liệu thành công");
                    }

                    break;
                case 2:
                    ReaderCtrl readerCtrlEdit = new ReaderCtrl();
                    readerCtrlEdit.editReader();
                    break;
                case 3:
                    System.out.println("Xóa bạn đọc");
                    ReaderCtrl readerCtrlDelete = new ReaderCtrl();
                    readerCtrlDelete.delete();
                    break;
                case 4:
                    System.out.println("Tìm kiếm bạn đọc");
                    searchReader();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;
    }

    private int searchReader() {
        int n = 0;
        do {
            System.out.println("-----------------TÌM KIẾM BẠN ĐỌC -----------------");
            System.out.println("1. Theo tên bạn đọc");
            System.out.println("2. Theo mã bạn đọc");
            System.out.println("3. Theo loại bạn đọc ");
            System.out.println("0. Quay lại");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            ReaderCtrl readerCtrl = new ReaderCtrl();
            switch (n) {

                case 1:
                    System.out.println("Tìm kiếm theo tên bạn đọc");
                    readerCtrl.findByName();

                    break;
                case 2:
                    System.out.println("Tìm kiếm theo mã bạn đọc");
                    readerCtrl.findByID();
                    break;
                case 3:
                    System.out.println("Tìm theo loại bạn đọc");
                    readerCtrl.findByType();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;

    }

    private int EmployeeFun() {
        int n = 0;
        do {

            System.out.println("----------------- QUẢN LÝ THÔNG TIN NHÂN VIÊN -----------------");
            System.out.println("1. Nhập thêm nhân viên mới");
            System.out.println("2. Sửa thông tin nhân viên");
            System.out.println("3. Xóa nhân viên ");
            System.out.println("4. Tìm kiếm nhân viên theo thông tin:");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            switch (n) {
                case 1:
                    System.out.println("Nhập mới nhân viên");
                    break;
                case 2:
                    System.out.println("Sửa thông tin nhân viên");
                    break;
                case 3:
                    System.out.println("Xóa nhân viên");
                    break;
                case 4:
                    System.out.println("Tìm kiếm nhân viên");
                    searchEmployee();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;
    }

    private int searchEmployee() {
        int n = 0;
        do {
            System.out.println("-----------------TÌM KIẾM BẠN ĐỌC -----------------");
            System.out.println("1. Theo tên nhân viên");
            System.out.println("2. Theo mã nhân viên");
            System.out.println("3. Theo loại nhân viên ");
            System.out.println("0. Quay lại");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            switch (n) {
                case 1:
                    System.out.println("Tìm kiếm theo tên nhân viên");
                    break;
                case 2:
                    System.out.println("Tìm kiếm theo mã nhân viên");
                    break;
                case 3:
                    System.out.println("Tìm theo loại nhân viên");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;

    }

    private int borrowFun() {
        int n = 0;
        do {
            System.out.println("----------------- QUẢN LÝ THÔNG TIN MƯỢN TRẢ-----------------");
            System.out.println("1. Tạo thông tin");
            System.out.println("2. Sắp xếp danh sách");
            System.out.println("3. Tìm kiếm theo tên bạn đọc:");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            switch (n) {
                case 1:
                    System.out.println("Tạo thông tin");
                    createInfo();
                    break;
                case 2:
                    System.out.println("Sắp xếp danh sách");
                    sortList();
                    break;
                case 3:
                    System.out.println("Tìm kiếm theo tên bạn đọc");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;
    }

    private int createInfo() {
        int n = 0;
        do {
            System.out.println("-----------------TẠO THÔNG TIN QUẢN LÝ MƯỢN TRẢ -----------------");
            System.out.println("1. Thêm thông tin");
            System.out.println("2. Sửa thông tin");
            System.out.println("3. Xóa thông tin ");
            System.out.println("0. Quay lại");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            switch (n) {
                case 1:
                    System.out.println("Thêm thông tin");
                    break;
                case 2:
                    System.out.println("Sửa thông tin");
                    break;
                case 3:
                    System.out.println("Xóa thông tin");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;
    }

    private int sortList() {
        int n = 0;
        do {
            System.out.println("-----------------SẮP XẾP DANH SÁCH-----------------");
            System.out.println("1. Theo tên bạn đọc");
            System.out.println("2. Theo số lượng đầu sách được mượn(Giảm dần)");
            System.out.println("0. Quay lại");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            switch (n) {
                case 1:
                    System.out.println("Sắp xếp theo tên bạn đọc");
                    break;
                case 2:
                    System.out.println("Theo đầu sách được mượn (giảm dần)");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;
    }

    private int billFun() {
        int n = 0;
        do {
            System.out.println("----------------- QUẢN LÝ THÔNG TIN PHIẾU MƯỢN -----------------");
            System.out.println("1. Xuất thông tin phiếu mượn  cho bạn đọc hiện thời");
            System.out.println("2. Xuất thông tin đầu sách mượn");
            System.out.println("3. Xuất thông tin bạn đọc mượn sách  ");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            switch (n) {
                case 1:
                    System.out.println("Xuất thông tin phiếu mượn");
                    break;
                case 2:
                    System.out.println("Xuất thông tin đầu sách mượn");
                    showBookBorrow();
                    break;
                case 3:
                    System.out.println("Xuất thông tin bạn đọc mượn sách");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;
    }

    private int showBookBorrow() {
        int n = 0;
        do {
            System.out.println("-----------------HIỂN THỊ SÁCH ĐƯỢC MƯỢN-----------------");
            System.out.println("1. Nhiều nhất");
            System.out.println("2. Ít nhất");
            System.out.println("0. Quay lại");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            switch (n) {
                case 1:
                    System.out.println("Thông tin sách được mượn nhiều nhất");
                    break;
                case 2:
                    System.out.println("Thông tin sách được mượn ít nhất");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;
    }

    private int showReaderBorrow() {
        int n = 0;
        do {
            System.out.println("-----------------HIỂN THỊ BẠN ĐỌC MƯỢN SÁCH-----------------");
            System.out.println("1. Nhiều nhất");
            System.out.println("2. Ít nhất");
            System.out.println("0. Quay lại");
            System.out.println("Mời bạn chọn chức năng: ");
            boolean isOK = false;
            do {
                try {
                    n = Integer.parseInt(sc.nextLine());
                    isOK = true;
                } catch (Exception e) {
                    System.out.println("Nhập sai chức năng. Mời nhập lại: ");
                }
            } while (!isOK);
            switch (n) {
                case 1:
                    System.out.println("Thông tin bạn đọc mượn nhiều sách nhất");
                    break;
                case 2:
                    System.out.println("Thông tin bạn đọc mượn ít nhất");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("sai chức năng. Mời nhập lại");
            }
        } while (n != 0);
        return n;
    }


}
