package be.TD.Dao;

import java.sql.Connection;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VideoGame find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
