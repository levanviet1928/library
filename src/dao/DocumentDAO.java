package dao;

import model.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentDAO implements DAO<Document> {
    public boolean isIDValid(String id, String tableName) {
        String sql = "SELECT ID FROM " + tableName + " WHERE ID = ?";
        Connection conn = DBConnection.getInstance().getConnection();
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean isNameValid(String name) {
        String sql = "SELECT docName FROM dbo.Document WHERE docName = ?";
        Connection conn = DBConnection.getInstance().getConnection();
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, name);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * @param doc
     */
    public void add(Document doc) {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO dbo.Document(ID, docName, author, publishYear, quantity) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement prepare = connection.prepareStatement(sql);
            prepare.setString(1, doc.getDocID());
            prepare.setString(2, doc.getDocumentName());
            prepare.setString(3, doc.getAuthor());
            prepare.setInt(4, doc.getPublishYear());
            prepare.setInt(5, doc.getQuantity());
            prepare.executeUpdate();

        } catch (SQLException e) {
            System.out.println("không có dữ liệu");
            e.printStackTrace();
        }
    }

    /**
     * @param id
     * @return
     */
    public boolean remove(String id) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM dbo.Document WHERE ID = ?";
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

    @Override
    public Document findByID(String id) {
        return null;
    }

    /**
     * @param
     * @return
     */
    public boolean edit(Document doc) {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Document SET docName = ?, author = ? , publishYear = ?, quantity = ? WHERE ID = ?";
        try {
            PreparedStatement prepare = connection.prepareStatement(sql);
            prepare.setString(1, doc.getDocumentName());
            prepare.setString(2, doc.getAuthor());
            prepare.setInt(3, doc.getPublishYear());
            prepare.setInt(4, doc.getQuantity());
            prepare.setString(5, doc.getDocID());
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
    public List<Document> findByName(String name) {
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Document> listDoc = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Document WHERE docName like ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, "%" + name + "%");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                String docID = result.getString("ID");
                String docName = result.getString("docName");
                String author = result.getString("author");
                int publishYear = result.getInt("publishYear");
                int quantity = result.getInt("quantity");
                listDoc.add(new Document(docID, docName, author, publishYear, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDoc;
    }

    /**
     * @param author
     */
    public List<Document> findByAuthor(String author) {
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Document> listDoc = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Document WHERE author like ?";
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
                listDoc.add(new Document(docID, docName, author1, publishYear, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDoc;
    }

    /**
     * @param type
     */
    public List<Document> findByType(String type) {
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Document> listDoc = new ArrayList<>();
        String sql = "SELECT D.ID, d.docName, d.author, d.publishYear, d.quantity, b.ID\n" +
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
                listDoc.add(new Document(docID, docName, author1, publishYear, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDoc;
    }
}