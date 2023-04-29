package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.example.pojo.Film;
import com.example.pojo.Reservation;

public class FilmDAO extends DataAccessObjectBase implements IDataAccessObject<Film>{
	
	private static FilmDAO instance;
	
	private FilmDAO() {}
	public static FilmDAO getInstance() {
		if(instance == null) {
			instance = new FilmDAO();
		}
		return instance;
	}
	
	
	@Override
	public void save(Film object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Film object) {
		super.deleteObject(object);
	}

	@Override
	public List<Film> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
        Query<Film> q = pm.newQuery(Film.class);
        return (List<Film>)q.execute(20);
	}

	@Override
	public Film find(String param) {
		return null;
	}

}