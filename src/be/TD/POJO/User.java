package be.TD.POJO;

import java.io.Serializable;
import be.TD.Dao.*;

public abstract class User implements Serializable{

	private static final long serialVersionUID = 6556145450950437192L;
	private int id;
	private String username;
	private String password;
	
	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public User(int id) {
		this.id = id;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static User Login(String pseudo, String password) {
		DaoFactory daoFactory= new DaoFactory();
		DAO<User> userDao = daoFactory.getUserDAO();
		return ((UserDAO) userDao).find(pseudo, password);
		
	}

	public boolean Register(Player user) {
		DaoFactory daoFactory= new DaoFactory();
		DAO<Player> playerDao = daoFactory.getPlayerDAO();
		return playerDao.create(user);
	}
	
}
