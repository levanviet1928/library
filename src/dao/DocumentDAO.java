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
        String sql = "SELECT ID, docName, author, publishYear, quantity FROM dbo.Document WHERE docName = ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, name);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                String docID = result.getString("ID");
                String docName = result.getString("docName");
                String author = result.getString("author");
                int publishYear = result.getInt(4);
                int quantity = result.getInt(5);
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
        // TODO - implement DocumentDAO.findByAuthor
        throw new UnsupportedOperationException();
    }

    /**
     * @param id
     */
    public Document findByID(String id) {
        // TODO - implement DocumentDAO.findByID
        throw new UnsupportedOperationException();
    }

}