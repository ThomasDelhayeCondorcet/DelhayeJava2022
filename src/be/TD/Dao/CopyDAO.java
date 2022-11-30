package be.TD.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import be.TD.POJO.Copy;
import be.TD.POJO.Player;
import be.TD.POJO.User;
import be.TD.POJO.VideoGame;

public class CopyDAO extends DAO<Copy>{

	public CopyDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Copy obj) {
		
		boolean success = false;
		
		String query = "Insert into copy (Idgame ,IdUser ,Available) Values (?,?,?)";
		
		try {
			PreparedStatement stmt = this.connect.prepareStatement(query);
			
			stmt.setInt(1, obj.getVideoGame().getId());
			stmt.setInt(2, obj.getOwner().getId());
			stmt.setInt(3, 1);

			
			stmt.execute();
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
	public boolean delete(Copy obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Copy obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Copy find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Copy> findAll() {
		ArrayList<Copy> copys = new ArrayList<>();
		String query = "Select * From Copy Inner join User On Copy.IdUser = User.Id Inner Join VideoGame on VideoGame.Id = Copy.IdGame";
		
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			while(result.next()) {
				int id = result.getInt("Copy.Id");
				int available = result.getInt("Copy.Available");
				
				int gameId = result.getInt("VideoGame.Id");
				String gameName = result.getString("VideoGame.Label");
				String Cost = String.valueOf(result.getInt("VideoGame.Price"));
				String console = result.getString("VideoGame.Console");
				VideoGame videoGame = new VideoGame(gameId, gameName, Cost, console);
				
				String pseudo = result.getString("User.Pseudo");
				int PlayerId = result.getInt("User.Id");
				
				User user = new Player(id, pseudo);
				
				copys.add(new Copy(videoGame, (Player) user, id, available));
			}
			return copys;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
