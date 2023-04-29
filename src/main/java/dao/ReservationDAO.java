package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.example.pojo.Reservation;
import com.example.pojo.Session;

public class ReservationDAO extends DataAccessObjectBase implements IDataAccessObject<Reservation>{
	
	private static ReservationDAO instance;
	
	private ReservationDAO() {}
	public static ReservationDAO getInstance() {
		if(instance == null) {
			instance = new ReservationDAO();
		}
		return instance;
	}
	
	
	@Override
	public void save(Reservation object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Reservation object) {
		super.deleteObject(object);
	}

	@Override
	public List<Reservation> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
        Query<Reservation> q = pm.newQuery(Reservation.class);
        return (List<Reservation>)q.execute(20);
	}

	@Override
	public Reservation find(String param) {
		return null;
	}

}