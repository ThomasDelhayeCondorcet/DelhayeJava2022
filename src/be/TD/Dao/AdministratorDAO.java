package be.TD.Dao;

import java.sql.Connection;

import be.TD.POJO.Administrator;

public class AdministratorDAO extends DAO<Administrator> {

	public AdministratorDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Administrator obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Administrator obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Administrator obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Administrator find(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
