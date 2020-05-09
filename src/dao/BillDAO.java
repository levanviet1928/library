package dao;

import model.Bill;

import java.util.List;

public class BillDAO implements DAO<Bill> {

    /**
     * @param id
     */
    public Bill getByID(String id) {
        // TODO - implement BillDAO.getByID
        throw new UnsupportedOperationException();
    }

    /**
     * @param moreOrLess
     */
    public List<Bill> getBorrow(String moreOrLess) {
        // TODO - implement BillDAO.getBorrow
        throw new UnsupportedOperationException();
    }

    /**
     * @param moreOrLess
     */
    public List<Bill> getBorrowPerson(String moreOrLess) {
        // TODO - implement BillDAO.getBorrowPerson
        throw new UnsupportedOperationException();
    }

    public List<Bill> getAll() {
        // TODO - implement BillDAO.getAll
        throw new UnsupportedOperationException();
    }

    /**
     * @param id
     * @return
     */
    public boolean remove(String id) {
        // TODO - implement BillDAO.remove
        throw new UnsupportedOperationException();
    }


    /**
     * @param b
     */
    public void add(Bill b) {
        // TODO - implement BillDAO.add
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean edit(String id, Bill key) {
        return false;
    }

    /**
     * @param name
     */
    public List<Bill> findByName(String name) {
        // TODO - implement BillDAO.findByName
        throw new UnsupportedOperationException();
    }

    /**
     * @param id
     */
    public Bill findByID(String id) {
        // TODO - implement BillDAO.findByID
        throw new UnsupportedOperationException();
    }

}