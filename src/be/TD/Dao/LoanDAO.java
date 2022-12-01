package be.TD.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import be.TD.POJO.Loan;

public class LoanDAO extends DAO<Loan>{

	public LoanDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Loan obj) {
		
		boolean success = false;
		String query = "Insert into Loan (StartDate, EndDate, OnGoing, IdCopy, IdBorrower) Values (?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = this.connect.prepareStatement(query);
			
			stmt.setObject(1, obj.getStartDate());
			stmt.setObject(2, obj.getEndDate());
			stmt.setInt(3, 1);
			stmt.setInt(4, obj.getCopy().getId());
			stmt.setInt(5, obj.getBorrower().getId());
			
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
	public boolean delete(Loan obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Loan obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Loan find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Loan> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
