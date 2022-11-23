package be.TD.Dao;

import be.TD.POJO.*;
import java.sql.Connection;

public class DaoFactory extends AbstractDAOFactory {
	
	protected static final Connection conn = DbConnection.getInstance();

	@Override
	public DAO<Administrator> getAdministratorDAO() {
		// TODO Auto-generated method stub
		return new AdministratorDAO(conn);
	}

	@Override
	public DAO<Booking> getBookingDAO() {
		// TODO Auto-generated method stub
		return new BookingDAO(conn);
	}

	@Override
	public DAO<Copy> getCopyDAO() {
		// TODO Auto-generated method stub
		return new CopyDAO(conn);
	}

	@Override
	public DAO<Loan> getLoanDAO() {
		// TODO Auto-generated method stub
		return new LoanDAO(conn);
	}

	@Override
	public DAO<Player> getPlayerDAO() {
		// TODO Auto-generated method stub
		return new PlayerDAO(conn);
	}

	@Override
	public DAO<User> getUserDAO() {
		// TODO Auto-generated method stub
		return new UserDAO(conn);
	}

	@Override
	public DAO<VideoGame> getVideoGameDAO() {
		// TODO Auto-generated method stub
		return new VideoGameDAO(conn);
	}

}
