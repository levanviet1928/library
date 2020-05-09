package model;

import java.util.Date;

public class Employee extends Person {

	private String empID;
	private String position;
	private String shift;

	public Employee() {
	}

	public Employee(String fullName, String empID) {
		super(fullName);
		this.empID = empID;
	}

	public Employee(String fullName) {
		super(fullName);
	}

	public Employee(int personID, String fullName, String address, Date dateOfBirth, String gender, String empID,
					String position, String shift) {
		super(personID, fullName, address, dateOfBirth, gender);
		this.empID = empID;
		this.position = position;
		this.shift = shift;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}
}