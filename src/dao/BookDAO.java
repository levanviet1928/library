package dao;

import model.Book;
import model.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends DocumentDAO {


    /**
     * @param doc
     */
    public void add(Document doc) {
        super.add(doc);

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO dbo.Book(ID, type, documentID) VALUES(?, ?, ?)";
        try {
            Book book = (Book) doc;
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, book.getBookID());
            prepare.setString(2, book.getType());
            prepare.setString(3, doc.getDocID());
            prepare.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param id
     * @return
     */
    public boolean remove(String id) {
        super.remove(id);
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM dbo.Book WHERE ID = ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, id);
            int result = prepare.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return false;
    }

    /**
     * @param
     * @return
     */
    public boolean edit(Document document) {
        super.edit(document);
        Connection conn = DBConnection.getInstance().getConnection();
        //ID, type, documentID
        String sql = "UPDATE dbo.Book SET type = ? WHERE ID = ?";
        try {
            Book b = (Book) document;
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, b.getType());
            prepare.setString(2, b.getBookID());
            int result = prepare.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param name
     */
    @Override
    public List<Document> findByName(String name) {
        ArrayList<Document> listdoc = new ArrayList<>();
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT D.ID, d.docName, d.author, d.publishYear, d.quantity, b.ID, b.type\n" +
                "FROM dbo.Document D inner join dbo.Book B\n" +
                "on D.ID = B.documentID\n" +
                "WHERE docName like  ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, "%" + name + "%");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                String docID = result.getString("ID");
                String docName = result.getString("docName");
                String author1 = result.getString("author");
                int publishYear = result.getInt("publishYear");
                int quantity = result.getInt("quantity");
                String bookID = result.getString("ID");
                String type = result.getString("type");
                listdoc.add(new Book(docID, docName, author1, publishYear, quantity, bookID, type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listdoc;
    }

    @Override
    public List<Document> findByAuthor(String author) {
        ArrayList<Document> listdoc = new ArrayList<>();
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT D.ID, d.docName, d.author, d.publishYear, d.quantity, b.ID, b.type\n" +
                "FROM dbo.Document D inner join dbo.Book B\n" +
                "on D.ID = B.documentID\n" +
                "WHERE author like  ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, "%" + author + "%");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                String docID = result.getString("ID");
                String docName = result.getString("docName");
                String author1 = result.getString("author");
                int publishYear = result.getInt("publishYear");
                int quantity = result.getInt("quantity");
                String bookID = result.getString("ID");
                String type = result.getString("type");
                listdoc.add(new Book(docID, docName, author1, publishYear, quantity, bookID, type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listdoc;
    }

    /**
     * @param year
     */
    public List<Book> findByYear(int year) {
        ArrayList<Book> listdoc = new ArrayList<>();
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT D.ID, d.docName, d.author, d.publishYear, d.quantity, b.ID, b.type\n" +
                "FROM dbo.Document D inner join dbo.Book B\n" +
                "on D.ID = B.documentID\n" +
                "WHERE publishYear like  ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, "%" + year + "%");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                String docID = result.getString("ID");
                String docName = result.getString("docName");
                String author1 = result.getString("author");
                int publishYear = result.getInt("publishYear");
                int quantity = result.getInt("quantity");
                String bookID = result.getString("ID");
                String type = result.getString("type");
                listdoc.add(new Book(docID, docName, author1, publishYear, quantity, bookID, type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listdoc;
    }

    /**
     * @param type
     */
    public List<Document> findByType(String type) {
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Document> listDoc = new ArrayList<>();
        String sql = "SELECT D.ID, d.docName, d.author, d.publishYear, d.quantity, b.ID,b.type\n" +
                "FROM dbo.Document D inner join dbo.Book B\n" +
                "on D.ID = B.documentID\n" +
                "WHERE type like ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, "%" + type + "%");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                String docID = result.getString("ID");
                String docName = result.getString("docName");
                String author1 = result.getString("author");
                int publishYear = result.getInt("publishYear");
                int quantity = result.getInt("quantity");
                String bookID = result.getString("ID");
                String type1 = result.getString("type");
                listDoc.add(new Book(docID, docName, author1, publishYear, quantity, bookID, type1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDoc;
    }

}