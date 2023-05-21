package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.example.pojo.Reservation;
import com.example.pojo.Session;
import com.example.pojo.User;

public class ReservationDAO extends DataAccessObjectBase implements IDataAccessObject<Reservation>{
	
	private static ReservationDAO instance;
	PersistenceManager pm = pmf.getPersistenceManager();
	
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
		//pm.deletePersistent(object);
	}

	@Override
	public List<Reservation> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        List<Reservation> result = null;

        try {
            tx.begin();

            Query<Reservation> q = pm.newQuery(Reservation.class);
            result = (List<Reservation>) q.executeList();

            tx.commit();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            pm.close();
        }

        return result;
	}

	@Override
	public Reservation find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();

	    Reservation result = null;
	    try {

	        tx.begin();

	        Query<Reservation> q = pm.newQuery(Reservation.class);
	        q.setFilter("code == codeParam");
	        q.declareParameters("String codeParam");
	        q.setUnique(true);
	        result = (Reservation) q.execute(param);
	        tx.commit();
	    } catch (Exception ex) {
	        System.out.println("Error: " + ex.getMessage());
	        ex.printStackTrace();
	    } finally {
	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }

	        pm.close();
	    }
	    return (Reservation) result;
	}

}