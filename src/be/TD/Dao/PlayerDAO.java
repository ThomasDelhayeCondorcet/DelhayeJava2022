package be.TD.Dao;

import java.sql.Connection;

import be.TD.POJO.Player;

public class PlayerDAO extends DAO<Player> {

	public PlayerDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Player obj) {
		// TODO Auto-generated method stub
		return false;
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

}
