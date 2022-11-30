package be.TD.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import be.TD.POJO.Player;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Player> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
