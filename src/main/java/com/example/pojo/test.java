package com.example.pojo;

import java.sql.Date;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.FilmDAO;
import dao.SessionDAO;
import dao.UserDAO;

public class test {

	@Test
	public void databaseChecking() {
		User u1 = new User(1, "User", "Resu", "user@gmail.com", "password");
		User u2 = new User(2, "Jorge", "Alonso", "jorge.alonso@gmail.com", "jorgisimo");
		User u3 = new User(3, "Daniel", "Galean", "daniel.galean@gmail.com", "djlamentable");
		
		UserDAO.getInstance().save(u1);
		UserDAO.getInstance().save(u2);
		UserDAO.getInstance().save(u3);
		
		Session s1 = new Session(1, new Date(System.currentTimeMillis()));
		Session s2 = new Session(2, new Date(System.currentTimeMillis()));
		Session s3 = new Session(3, new Date(System.currentTimeMillis()));
		Session s4 = new Session(4, new Date(System.currentTimeMillis()));
		
		SessionDAO.getInstance().save(s1);
		SessionDAO.getInstance().save(s2);
		SessionDAO.getInstance().save(s3);
		SessionDAO.getInstance().save(s4);

		
		ArrayList<Session> sessionMap1 = new ArrayList<Session>();
		sessionMap1.add(s1);
		sessionMap1.add(s2);
		ArrayList<Session> sessionMap2 = new ArrayList<Session>();
		sessionMap2.add(s3);
		sessionMap2.add(s4);
		
		Film f1 = new Film(1, "PussynBoots", 2023, sessionMap1);
		Film f2 = new Film(2, "Zhon Vick", 2023, sessionMap2);
		
		FilmDAO.getInstance().save(f1);
		FilmDAO.getInstance().save(f2);

		

		
		//System.out.println(UserDAO.getInstance().getAll());		
		
		
	}
}
