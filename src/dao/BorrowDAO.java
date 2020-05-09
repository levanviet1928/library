package dao;

import model.Borrow;

import java.util.List;

public class BorrowDAO implements DAO<Borrow> {



	@Override
	public void add(Borrow key) {

	}

	/**
     *
	 * @param id
     * @return
	 */
    public boolean edit(String id, Borrow key) {
		// TODO - implement BorrowDAO.edit
		throw new UnsupportedOperationException();
	}

	/**
     *
     * @param id
     * @return
     */
    public boolean remove(String id) {
		// TODO - implement BorrowDAO.remove
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Borrow findByID(String id) {
		// TODO - implement BorrowDAO.findByID
		throw new UnsupportedOperationException();
	}

	public List<Borrow> sortByReaderName() {
		// TODO - implement BorrowDAO.sortByReaderName
		throw new UnsupportedOperationException();
	}

	public List<Borrow> sortByQuantity() {
		// TODO - implement BorrowDAO.sortByQuantity
		throw new UnsupportedOperationException();
	}

	public List<Borrow> searchByReaderName() {
		// TODO - implement BorrowDAO.searchByReaderName
		throw new UnsupportedOperationException();
	}

	public List<Borrow> getAll() {
		// TODO - implement BorrowDAO.getAll
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Borrow> findByName(String name) {
		return null;
	}
}