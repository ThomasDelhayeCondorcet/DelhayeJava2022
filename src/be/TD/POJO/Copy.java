package be.TD.POJO;

import java.io.Serializable;
import java.util.ArrayList;

import be.TD.Dao.DAO;
import be.TD.Dao.DaoFactory;

public class Copy implements Serializable{
	
	private static final long serialVersionUID = -4587535549659348913L;
	private int id;
	private VideoGame videoGame;
	private Player owner;
	private Loan loan;
	private int available;
	
	public Copy(VideoGame videoGame, Player owner, int id, int available) {
		this.videoGame = videoGame;
		this.owner = owner;
		this.id = id;
		this.available = available;
	}

	public Copy(VideoGame videoGame, Player owner) {
		this.videoGame = videoGame;
		this.owner = owner;
	}

	public VideoGame getVideoGame() {
		return videoGame;
	}

	public void setVideoGame(VideoGame videoGame) {
		this.videoGame = videoGame;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public void ReleaseCopy() {
		
	}
	
	public void Borrow() {
		
	}
	
	public boolean IsAvailable() {
		return false;
	}

	public boolean AddCopy(Copy copy) {
		DaoFactory daoFactory= new DaoFactory();
		DAO<Copy> copyrDao = daoFactory.getCopyDAO();
		return copyrDao.create(copy);
	}
	
	public static ArrayList<Copy> GetAll() {
		DaoFactory daoFactory= new DaoFactory();
		DAO<Copy> copyDao = daoFactory.getCopyDAO();
		return copyDao.findAll();
	}
}
