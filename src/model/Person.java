package model;

import java.util.Date;

public class Person {

	private int personID;
	private String fullName;
	private String address;
	private Date dateOfBirth;
	private String gender;


	public Person() {
	}

	public Person(int personID) {
		this.personID = personID;
	}

	public Person(String fullName) {
		this.fullName = fullName;
	}

	public Person(int personID, String fullName, String address, Date dateOfBirth, String gender) {
		this.personID = personID;
		this.fullName = fullName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}