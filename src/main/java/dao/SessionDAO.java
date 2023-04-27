package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import com.example.pojo.Session;

public class SessionDAO extends DataAccessObjectBase implements IDataAccessObject<Session>{
	
	private static SessionDAO instance;
	
	private SessionDAO() {}
	public static SessionDAO getInstance() {
		if(instance == null) {
			instance = new SessionDAO();
		}
		return instance;
	}
	
	
	@Override
	public void save(Session object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Session object) {
		super.deleteObject(object);
	}

	@Override
	public List<Session> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Session> sessions = new ArrayList<>();
		try {
			tx.begin();
			Extent<Session> extent = pm.getExtent(Session.class, true);
			for (Session session : extent) {
				sessions.add(session);
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(" # ERROR GETTING THE SESSIONS.");
		} finally {
			if (tx != null && tx.isActive()) {
			tx.rollback();
		}

		pm.close();
	}

	return sessions;
	}

	@Override
	public Session find(String param) {
		return null;
	}

}