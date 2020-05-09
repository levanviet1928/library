package model;


import java.util.Date;

public class Bill {

	private String billID;
	private Date startDate;
	private Date duration;
	private float deposit;
	private Borrow borrow;

	public Bill() {

	}

	public Bill(String billID) {
		this.billID = billID;
	}

	public Bill(String billID, Date startDate, Date duration, float deposit, Borrow borrow) {
		this.billID = billID;
		this.startDate = startDate;
		this.duration = duration;
		this.deposit = deposit;
		this.borrow = borrow;
	}

	public String getBillID() {
		return billID;
	}

	public void setBillID(String billID) {
		this.billID = billID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public float getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
}