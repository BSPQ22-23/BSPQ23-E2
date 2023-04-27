package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import com.example.pojo.Film;

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
		Transaction tx = pm.currentTransaction();
		List<Film> films = new ArrayList<>();
		try {
			tx.begin();
			Extent<Film> extent = pm.getExtent(Film.class, true);
			for (Film film : extent) {
				films.add(film);
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(" # ERROR GETTING THE FILM.");
		} finally {
			if (tx != null && tx.isActive()) {
			tx.rollback();
		}

		pm.close();
	}

	return films;
	}

	@Override
	public Film find(String param) {
		return null;
	}

}