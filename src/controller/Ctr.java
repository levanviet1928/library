package controller;

public interface Ctr<T> {

	/**
	 * 
	 * @param p
	 */
	void show(T p);

	T addFromKeyBroad();

}