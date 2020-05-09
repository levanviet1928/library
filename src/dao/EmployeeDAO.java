package dao;

import model.Employee;
import model.Person;

import java.util.List;

public class EmployeeDAO extends PersonDAO {

	@Override
	public void add(Person key) {
		super.add(key);
	}

	/**
     *
     * @param id
     * @return
     */
    public boolean remove(String id) {
		// TODO - implement EmployeeDAO.remove
		throw new UnsupportedOperationException();
	}

	/**
     *
	 * @param id
     * @return
	 */
    public boolean edit(String id, Person key) {
		// TODO - implement EmployeeDAO.edit
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public List<Person> findByName(String name) {
		// TODO - implement EmployeeDAO.findByName
		throw new UnsupportedOperationException();
	}

	public List<Employee> getAll() {
		// TODO - implement EmployeeDAO.getAll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param position
	 */
	public List<Employee> findByPosition(String position) {
		// TODO - implement EmployeeDAO.findByPosition
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param shift
	 */
	public List<Employee> findByShift(String shift) {
		// TODO - implement EmployeeDAO.findByShift
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public Person findByID(String id) {
		return super.findByID(id);
	}
}