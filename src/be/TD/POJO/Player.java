package be.TD.POJO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Player extends User implements Serializable{

	private static final long serialVersionUID = -8384386959180789873L;
	private int credit;
	private String pseudo;
	private String email;
	private String adress;
	private LocalDate registrationDate;
	private LocalDate dateOfBirth;
	private ArrayList<Booking> bookings;
	private ArrayList<Copy> copys;
	private ArrayList<Loan> loan;
	private ArrayList<Loan> borrow;
	
	public Player(int id, String username, String password , int credit, String pseudo, LocalDate registrayionDate,LocalDate dateOfBirth, String email, String adress) {
		super(id, username, password);
		this.credit = credit;
		this.pseudo = pseudo;
		this.email = email;
		this.registrationDate = registrayionDate;
		this.dateOfBirth = dateOfBirth;
		this.adress = adress;
	}
	
	public Player(String username, String password, String pseudo, LocalDate registrationDate,LocalDate dateOfBirth, String email, String adress ) {
		super(username, password);
		this.pseudo = pseudo;
		this.registrationDate = registrationDate;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrayionDate) {
		this.registrationDate = registrayionDate;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
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
}
