package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.example.pojo.Session;
import com.example.pojo.User;

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
        Query<Session> q = pm.newQuery(Session.class);
        return (List<Session>)q.execute(20);
	}

	@Override
	public Session find(String param) {
		return null;
	}

}