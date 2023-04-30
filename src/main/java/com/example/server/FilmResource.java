package com.example.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Comparator;

import dao.FilmDAO;
import dao.UserDAO;

import com.interfaces.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import com.example.pojo.Film;
import com.example.pojo.User;

@Path("films")
public class FilmResource {
	public static final FilmDAO a = FilmDAO.getInstance();
	protected static final Logger logger = LogManager.getLogger();
	
	private PersistenceManager pm=null;
	private Transaction tx=null;
	
	List<Film> films = new ArrayList<Film>();
	
	public FilmResource() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Film> getFilms() {
        
    	films = FilmDAO.getInstance().getAll();
        Stream<Film> stream = films.stream();

        // return the resulting stream as a list
        return stream.collect(Collectors.toList());
    }
}
