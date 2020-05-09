package dao;

import java.util.List;

public interface DAO<T> {

	/**
	 * 
	 * @param key
	 */
	void add(T key);

	/**
     *
	 * @param id
     * @return
	 */
    boolean edit(String id, T key);

	/**
	 * 
	 * @param name
	 */
	List<T> findByName(String name);

	/**
     *
     * @param id
     * @return
     */
    boolean remove(String id);

	/**
	 * 
	 * @param id
	 */
	T findByID(String id);

}