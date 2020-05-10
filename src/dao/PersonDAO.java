package dao;

import model.Person;

import java.util.List;

public class PersonDAO implements DAO<Person> {



	@Override
	public void add(Person key) {

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