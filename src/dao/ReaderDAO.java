package dao;

import model.Person;
import model.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderDAO extends PersonDAO {


    /**
     * @param id
     * @return
     */
    public boolean remove(String id) {

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM dbo.Reader Where personID  = ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, id);
            int result = prepare.executeUpdate();
            boolean resultPer = super.remove(id);
            if (result > 0 && resultPer) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * @return
     */
    public boolean edit(Person key) {
        super.edit(key);
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "UPDATE dbo.Reader SET type = ? ,phoneNumber=?,email=? From Person p inner join Reader r " +
                "on p.ID = r.personID  WHERE p.ID = ?";
        try {
            Reader reader = (Reader) key;
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, reader.getType());
            prepare.setString(2, reader.getPhoneNumber());
            prepare.setString(3, reader.getEmail());
            prepare.setString(4, key.getPersonID());
            int result = prepare.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkValidID(String ID) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT ID FROM dbo.Reader WHERE ID = ?";
        try {
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, ID);
            ResultSet resultSet = prepared.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public void add(Person key) {
        super.add(key);
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Reader(ID,type,phoneNumber,email,personID) VALUES (?,?,?,?,?)";
        try {
            Reader reader = (Reader) key;
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, reader.getReaderID());
            prepare.setString(2, reader.getType());
            prepare.setString(3, reader.getPhoneNumber());
            prepare.setString(4, reader.getEmail());
            prepare.setString(5, key.getPersonID());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        ArrayList<Person> lstPer = new ArrayList<>();
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT p.ID, fullName,DOB,gender, address,r.ID, phoneNumber,email, type\n" +
                "FROM Person p INNER JOIN Reader r\n" +
                "on p.ID = r.personID\n" +
                "WHERE p.fullName LIKE ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, "%" + name + "%");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                String perID = result.getString(1);
                String fullName = result.getString("fullName");
                Date DOB = result.getDate("DOB");
                String gender = result.getString("gender");
                String address = result.getString("address");
                String readerID = result.getString(6);
                String phone = result.getString("phoneNumber");
                String email = result.getString("email");
                String type = result.getString("type");
                lstPer.add(new Reader(perID, fullName, address, DOB, gender, readerID, type, phone, email));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstPer;
    }

    /**
     * @param type
     */
    public ArrayList<Reader> findByType(String type) {
        ArrayList<Reader> lstPer = new ArrayList<>();

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT p.ID, fullName,DOB,gender, address,r.ID, phoneNumber,email, type\n" +
                "FROM Person p INNER JOIN Reader r\n" +
                "on p.ID = r.personID\n" +
                "WHERE type LIKE ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, "%" + type + "%");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                String perID = result.getString(1);
                String fullName = result.getString("fullName");
                Date DOB = result.getDate("DOB");
                String gender = result.getString("gender");
                String address = result.getString("address");
                String readerID = result.getString(6);
                String phone = result.getString("phoneNumber");
                String email = result.getString("email");
                String typeReader = result.getString("type");
                lstPer.add(new Reader(perID, fullName, address, DOB, gender, readerID, typeReader, phone, email));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstPer;
    }

    public List<Reader> getAll() {
        // TODO - implement ReaderDAO.getAll
        throw new UnsupportedOperationException();
    }

    @Override
    public Person findByID(String id) {
        Reader reader = null;
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT p.ID, fullName,DOB,gender, address,r.ID, phoneNumber,email, type \n " +
                " FROM Person p INNER JOIN Reader r \n" +
                " on p.ID = r.personID \n" +
                " WHERE r.ID = ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                String perID = result.getString(1);
                String fullName = result.getString("fullName");
                Date DOB = result.getDate("DOB");
                String gender = result.getString("gender");
                String address = result.getString("address");
                String readerID = result.getString(6);
                String phone = result.getString("phoneNumber");
                String email = result.getString("email");
                String typeReader = result.getString("type");
                reader = new Reader(perID, fullName, address, DOB, gender, readerID, typeReader, phone, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reader;
    }
}