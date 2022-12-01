package be.TD.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import be.TD.POJO.Copy;
import be.TD.POJO.Loan;
import be.TD.POJO.Player;
import be.TD.POJO.User;

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
		ArrayList<Loan> loans = new ArrayList<>();
		String query = "Select * From Loan Inner join Copy On Loan.IdCopy = Copy.Id";
		
		ResultSet result;
		try {
			result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			while(result.next()) {
				int id = result.getInt("Id");
				LocalDate startDate = result.getDate("StartDate").toLocalDate();
				LocalDate endDate = result.getDate("EndDate").toLocalDate();
				if(result.getInt("OnGoing")==1);
					boolean onGoing = true;
				int idCopy = result.getInt("IdCopy");
				int idBorrower = result.getInt("IdBorrower");
				int idLender = result.getInt("Copy.IdUser");
				User borrower = Player.Find(idBorrower);
				Copy copy = Copy.Find(idCopy);
				Loan loan = new Loan(startDate, endDate, onGoing, (Player)borrower, copy.getOwner(), copy, id);
				loans.add(loan);
			}
			return loans;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
