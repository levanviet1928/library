package dao;

import model.Person;
import model.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return super.findByName(name);
    }

    /**
     * @param type
     */
    public List<Reader> findByType(String type) {
        // TODO - implement ReaderDAO.findByType
        throw new UnsupportedOperationException();
    }

    public List<Reader> getAll() {
        // TODO - implement ReaderDAO.getAll
        throw new UnsupportedOperationException();
    }

    @Override
    public Person findByID(String id) {
        return super.findByID(id);
    }
}