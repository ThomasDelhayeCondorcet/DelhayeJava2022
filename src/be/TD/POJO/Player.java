package be.TD.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Player extends User implements Serializable{

	private static final long serialVersionUID = -8384386959180789873L;
	private int credit;
	private String pseudo;
	private Date registrayionDate;
	private Date dateOfBirth;
	private ArrayList<Booking> bookings;
	private ArrayList<Copy> copys;
	private ArrayList<Loan> loan;
	private ArrayList<Loan> borrow;
	
	public Player(String username, String password, int credit, String pseudo, Date registrayionDate,Date dateOfBirth) {
		super(username, password);
		this.credit = credit;
		this.pseudo = pseudo;
		this.registrayionDate = registrayionDate;
		this.dateOfBirth = dateOfBirth;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Date getRegistrayionDate() {
		return registrayionDate;
	}

	public void setRegistrayionDate(Date registrayionDate) {
		this.registrayionDate = registrayionDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	public ArrayList<Copy> getCopys() {
		return copys;
	}

	public void setCopys(ArrayList<Copy> copys) {
		this.copys = copys;
	}

	public ArrayList<Loan> getLoan() {
		return loan;
	}

	public void setLoan(ArrayList<Loan> loan) {
		this.loan = loan;
	}

	public ArrayList<Loan> getBorrow() {
		return borrow;
	}

	public void setBorrow(ArrayList<Loan> borrow) {
		this.borrow = borrow;
	}

	public boolean LoanAllowed() {
		return false;
	}
	
	public void AddBirthdayBonus() {
		
	}
	
	@Override
	public void Login() {
		
	}

}
