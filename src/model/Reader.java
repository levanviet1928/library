package model;
import java.util.Date;

public class Reader extends Person {

	private String readerID;
	private String type;
    private String phoneNumber;
	private String email;

	public Reader() {
		}

    public Reader(String personID, String fullName, String address, Date dateOfBirth, String gender,
                  String readerID, String type, String phoneNumber, String email) {
		super(personID, fullName, address, dateOfBirth, gender);
		this.readerID = readerID;
		this.type = type;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Reader(String readerID) {
		this.readerID = readerID;
	}

	public String getReaderID() {
		return readerID;
	}

	public void setReaderID(String readerID) {
		this.readerID = readerID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public String getPhoneNumber() {
		return phoneNumber;
	}

    public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    @Override
    public String toString() {
        return super.toString() +
                "readerID='" + readerID + '\'' +
                ", type='" + type + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email;
    }
}