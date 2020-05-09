package model;

import java.util.List;

public class 	Borrow {

	private String brwID;
	private Employee emp;
	private int total;
	private Reader reader;
	private List<BookState> state;

	public Borrow() {
	}

	public Borrow(String brwID) {
		this.brwID = brwID;
	}

	public Borrow(String brwID, Employee emp, int total, Reader reader, List<BookState> state) {
		this.brwID = brwID;
		this.emp = emp;
		this.total = total;
		this.reader = reader;
		this.state = state;
	}

	public String getBrwID() {
		return brwID;
	}

	public void setBrwID(String brwID) {
		this.brwID = brwID;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public List<BookState> getState() {
		return state;
	}

	public void setState(List<BookState> state) {
		this.state = state;
	}
}