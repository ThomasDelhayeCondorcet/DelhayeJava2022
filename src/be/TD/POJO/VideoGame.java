package be.TD.POJO;

import java.io.Serializable;
import java.util.ArrayList;

public class VideoGame implements Serializable{

	private static final long serialVersionUID = 1906612796673826900L;
    private String name;
    private String creditCost;
    private String console;
    private ArrayList<Booking>bookings;
    private ArrayList<Copy> copys;
    
    public VideoGame(String name, String creditCost, String console) {
		this.name = name;
		this.creditCost = creditCost;
		this.console = console;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreditCost() {
		return creditCost;
	}

	public void setCreditCost(String creditCost) {
		this.creditCost = creditCost;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
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

	public Copy CopyAvailable() {
		return null;
    }
    
    public void SelectBooking() {
    	
    }
    
    
	
}
