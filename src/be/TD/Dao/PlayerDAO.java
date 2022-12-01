package be.TD.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import be.TD.POJO.Player;
import be.TD.POJO.User;

public class PlayerDAO extends DAO<Player> {

	public PlayerDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Player obj) {
		
		boolean success = false;
		
		String query = "Insert into User (UserName,Pseudo,Email,Password,BirthDay,Adress,CreationDate,Balance,Moderator) Values (?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = this.connect.prepareStatement(query);
			
			stmt.setString(1, obj.getUsername());
			stmt.setString(2, obj.getPseudo());
			stmt.setString(3, obj.getEmail());
			stmt.setString(4, obj.getPassword());
			stmt.setObject(5, obj.getDateOfBirth());
			stmt.setString(6, obj.getAdress());
			stmt.setObject(7, obj.getRegistrationDate());
			stmt.setInt(8, 10);
			stmt.setInt(9, 0);
			
			stmt.execute();
			stmt.close();
			success = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
		
	
	}

	@Override
	public boolean delete(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Player obj) {
		boolean success;
		String query = "Update User Set Balance = '" + obj.getCredit() + "' Where Id = '" + obj.getId() + "'";
		
		try {
			PreparedStatement stmt = this.connect.prepareStatement(query);
			
			stmt.executeUpdate();
			stmt.close();
			success = true;
			return success;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Player find(int id) {
		
		String query = "Select * from User Where Id = '" + id + "'";
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			
			if(result.first()){
				String username = result.getString("UserName");
				String pseudo = result.getString("Pseudo");
				
				int balance = result.getInt("Balance");
				User player = new Player(id, pseudo, balance);
				return (Player) player;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Player> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
