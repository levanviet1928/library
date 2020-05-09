package model;

import java.awt.print.Book;

public class BookState {

	private Book book;
	private int quantity;
	private String state;

	public BookState() {

	}

	public BookState(Book book, int quantity, String state) {
		this.book = book;
		this.quantity = quantity;
		this.state = state;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}