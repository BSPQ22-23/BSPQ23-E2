package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import com.example.pojo.Reservation;

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
		Transaction tx = pm.currentTransaction();
		List<Reservation> reservations = new ArrayList<>();
		try {
			tx.begin();
			Extent<Reservation> extent = pm.getExtent(Reservation.class, true);
			for (Reservation reservation : extent) {
				reservations.add(reservation);
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(" # ERROR GETTING THE RESERVATIONS.");
		} finally {
			if (tx != null && tx.isActive()) {
			tx.rollback();
		}

		pm.close();
	}

	return reservations;
	}

	@Override
	public Reservation find(String param) {
		return null;
	}

}