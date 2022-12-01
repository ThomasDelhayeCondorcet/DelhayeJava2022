package be.TD.POJO;

import java.io.Serializable;

import java.util.ArrayList;

import be.TD.Dao.DAO;
import be.TD.Dao.DaoFactory;
import be.TD.Dao.VideoGameDAO;

public class VideoGame implements Serializable{

	private static final long serialVersionUID = 1906612796673826900L;
	private int id;
    private String name;
    private String creditCost;
    private String console;
    private ArrayList<Booking>bookings;
    private ArrayList<Copy> copys;
    
    public VideoGame(int id, String name, String creditCost, String console) {
    	this.id = id;
		this.name = name;
		this.creditCost = creditCost;
		this.console = console;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public static ArrayList<VideoGame> GetAll() {
		DaoFactory daoFactory= new DaoFactory();
		DAO<VideoGame> VideoGameDao = daoFactory.getVideoGameDAO();
		return VideoGameDao.findAll();
	}

	public boolean UpdateCost(VideoGame videoGame) {
		DaoFactory daoFactory= new DaoFactory();
		DAO<VideoGame> VideoGameDao = daoFactory.getVideoGameDAO();
		return VideoGameDao.update(videoGame);
	}

	public static VideoGame Find(int idGame) {
		DaoFactory daoFactory= new DaoFactory();
		DAO<VideoGame> VideoGameDao = daoFactory.getVideoGameDAO();
		return VideoGameDao.find(idGame);
	}
    
    
	
}
