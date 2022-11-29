package be.TD.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import be.TD.POJO.Copy;

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

}
