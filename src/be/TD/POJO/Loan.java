package be.TD.POJO;

import java.io.Serializable;
import java.util.Date;

public class Loan implements Serializable{

	
	private static final long serialVersionUID = 4434575581981169475L;
	private Date startDate;
	private Date endDate;
	private boolean onGoing;
	private Player borrower;
	private Player lender;
	private Copy copy;
	
	public Loan(Date startDate, Date endDate, boolean onGoing, Player borrower, Player lender, Copy copy) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.onGoing = onGoing;
		this.borrower = borrower;
		this.lender = lender;
		this.copy = copy;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isOnGoing() {
		return onGoing;
	}

	public void setOnGoing(boolean onGoing) {
		this.onGoing = onGoing;
	}

	public Player getBorrower() {
		return borrower;
	}

	public void setBorrower(Player borrower) {
		this.borrower = borrower;
	}

	public Player getLender() {
		return lender;
	}

	public void setLender(Player lender) {
		this.lender = lender;
	}

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

	public void CalculateBalance() {
		
	}
	
	public void EndLoan() {
		
	}
}
