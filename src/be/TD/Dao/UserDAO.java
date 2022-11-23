package be.TD.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import be.TD.POJO.Administrator;
import be.TD.POJO.Player;
import be.TD.POJO.User;

public class UserDAO extends DAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User find(String pseudo, String password) {
		User user = null;
		String query ="Select * From User Where Pseudo= and "+ pseudo + " and Password = " + password;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			if(result.first()) {
				String username = result.getString("UserName");
				String email = result.getString("Email");
				String adress = result.getString("Adress");
				
				LocalDate registrationDate = result.getDate("CreationDate").toLocalDate();
				LocalDate birthDay = result.getDate("BirthDay").toLocalDate();
				
				int balance = result.getInt("Balance");
				int moderator = result.getInt("Moderator");
				int id = result.getInt("Id");
				if(moderator == 0)
					return user = new Player(id, username, password, balance, pseudo, registrationDate, birthDay, email, adress );
				if(moderator == 1)
					return user= new Administrator(id, username, password);	
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
