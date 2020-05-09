package dao;

import model.Person;
import model.Reader;

import java.util.List;

public class ReaderDAO extends PersonDAO {


    /**
     * @param id
     * @return
     */
    public boolean remove(String id) {
        // TODO - implement ReaderDAO.remove
        throw new UnsupportedOperationException();
    }

    /**
     * @param id
     * @return
     */
    public boolean edit(String id, Person key) {
        // TODO - implement ReaderDAO.edit
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Person key) {
        super.add(key);
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