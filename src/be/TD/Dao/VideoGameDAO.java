package be.TD.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import be.TD.POJO.Administrator;
import be.TD.POJO.Player;
import be.TD.POJO.VideoGame;

public class VideoGameDAO extends DAO<VideoGame>{

	public VideoGameDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(VideoGame obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(VideoGame obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(VideoGame obj) {
		boolean success = false;
		
		String query ="Update VideoGame Set Price = '" + obj.getCreditCost() + "' Where Id = '" + obj.getId() + "'";
		
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
	public VideoGame find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<VideoGame> findAll() {
		ArrayList<VideoGame> games = new ArrayList<>();
		String query ="Select * From VideoGame";
		
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			while(result.next()) {
				int id = result.getInt("Id");
				String name = result.getString("Label");
				String cost = String.valueOf(result.getInt("Price"));
				String console = result.getString("Console");
				games.add(new VideoGame(id, name, cost, console));
			}
			return games;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
