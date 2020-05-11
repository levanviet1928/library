package dao;

import model.Book;
import model.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookDAO extends DocumentDAO {


	/**
	 *
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
	 *
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
	 *
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
//        return
	}

	/**
	 * 
	 * @param name
	 */
	@Override
	public List<Document> findByName(String name) {
		return super.findByName(name);
	}

	@Override
	public List<Document> findByAuthor(String author) {
		return super.findByAuthor(author);
	}

	/**
	 * 
	 * @param year
	 */
	public List<Book> findByYear(int year) {
		// TODO - implement BookDAO.findByYear
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 */
	public List<Book> findByType(String type) {
		// TODO - implement BookDAO.findByType
		throw new UnsupportedOperationException();
	}

}