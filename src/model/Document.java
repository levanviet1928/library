package model;

public class Document {
    private String docID;
    private String documentName;
    private String author;
    private int publishYear;
    private int quantity;

    public Document() {
    }

    public Document(String docID, String documentName, String author, int publishYear, int quantity) {
        this.docID = docID;
        this.documentName = documentName;
        this.author = author;
        this.publishYear = publishYear;
        this.quantity = quantity;
    }

    public Document(String docID) {
        this.docID = docID;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return " docID='" + docID + '\'' +
                ", documentName='" + documentName + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", quantity=" + quantity;
    }
}