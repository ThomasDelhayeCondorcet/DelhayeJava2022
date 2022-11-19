package be.TD.Dao;

import java.sql.Connection;

import be.TD.POJO.Loan;

public class LoanDAO extends DAO<Loan>{

	public LoanDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Loan obj) {
		// TODO Auto-generated method stub
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

}
