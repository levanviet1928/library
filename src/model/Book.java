package model;

public class Book extends Document {

	private String bookID;
	private String type;

	public Book() {

	}

	public Book(String docID, String documentName, String author, int publishYear, int quantity, String bookID, String type) {
		super(docID, documentName, author, publishYear, quantity);
		this.bookID = bookID;
		this.type = type;
	}

    public Book(String docID, String bookID, String type) {
        super(docID);
        this.bookID = bookID;
        this.type = type;
    }

    public Book(String bookID) {
		this.bookID = bookID;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return super.toString() +
				"bookID='" + bookID + '\'' +
				", type='" + type + '\'';
	}
}