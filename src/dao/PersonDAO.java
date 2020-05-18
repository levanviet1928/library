package dao;

import model.Person;

import java.sql.*;
import java.util.List;

public class PersonDAO implements DAO<Person> {
    public boolean checkValidID(String ID) {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT ID FROM dbo.Person WHERE ID = ?";
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
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO dbo.Person (ID,fullName,address,DOB,gender) VALUES (?,?,?,?,?)";
        Date sqlDate = new Date(key.getDateOfBirth().getTime());
        try {
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, key.getPersonID());
            prepare.setString(2, key.getFullName());
            prepare.setString(3, key.getAddress());
            prepare.setDate(4, sqlDate);
            prepare.setString(5, key.getGender());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	/**
     *
     * @return
	 */
	public boolean edit(Person key) {
		// TODO - implement PersonDAO.edit
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public List<Person> findByName(String name) {
		// TODO - implement PersonDAO.findByName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Person findByID(String id) {
		// TODO - implement PersonDAO.findByID
		throw new UnsupportedOperationException();
	}

	/**
     *
     * @param id
     * @return
     */
    public boolean remove(String id) {
		// TODO - implement PersonDAO.remove
		throw new UnsupportedOperationException();
	}

}