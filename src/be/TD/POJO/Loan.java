package be.TD.POJO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import be.TD.Dao.DAO;
import be.TD.Dao.DaoFactory;

public class Loan implements Serializable{

	
	private static final long serialVersionUID = 4434575581981169475L;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean onGoing;
	private Player borrower;
	private Player lender;
	private Copy copy;
	
	public Loan(LocalDate startDate, LocalDate endDate, boolean onGoing, Player borrower, Player lender, Copy copy) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.onGoing = onGoing;
		this.borrower = borrower;
		this.lender = lender;
		this.copy = copy;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
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

	public boolean Create(Loan loan) {
		DaoFactory daoFactory= new DaoFactory();
		DAO<Loan> loanDAO = daoFactory.getLoanDAO();
		return loanDAO.create(loan);
		
	}
}
