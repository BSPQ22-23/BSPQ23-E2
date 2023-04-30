package com.example.pojo;

import java.sql.Date;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.FilmDAO;
import dao.SessionDAO;
import dao.UserDAO;

public class Testing {

	@Test
	public void databaseChecking() {
		
		Session s1 = new Session(1, java.sql.Date.valueOf("2023-05-12 12:00:00"));
		Session s2 = new Session(2, java.sql.Date.valueOf("2023-05-12 15:00:00"));
		Session s3 = new Session(3, java.sql.Date.valueOf("2023-05-12 18:00:00"));
		
		SessionDAO.getInstance().save(s1);
		SessionDAO.getInstance().save(s2);
		SessionDAO.getInstance().save(s3);

			
		ArrayList<Session> sessionMap1 = new ArrayList<Session>();
		sessionMap1.add(s1);
		sessionMap1.add(s2);
		sessionMap1.add(s3);
		ArrayList<Session> sessionMap2 = new ArrayList<Session>();
		sessionMap2.add(s1);
		sessionMap2.add(s2);
		sessionMap2.add(s3);
		ArrayList<Session> sessionMap3 = new ArrayList<Session>();
		sessionMap3.add(s1);
		sessionMap3.add(s2);
		sessionMap3.add(s3);
		ArrayList<Session> sessionMap4 = new ArrayList<Session>();
		sessionMap4.add(s1);
		sessionMap4.add(s2);
		sessionMap4.add(s3);
		ArrayList<Session> sessionMap5 = new ArrayList<Session>();
		sessionMap5.add(s1);
		sessionMap5.add(s2);
		sessionMap5.add(s3);
		
		Film f1 = new Film(1, "Spiderman-No Way Home", 2023);
//		f1.setSessions(sessionMap1);
		Film f2 = new Film(2, "The Batman", 2023);
//		f2.setSessions(sessionMap2);
		Film f3 = new Film(3, "Avatar 2", 2023);
//		f3.setSessions(sessionMap3);
		Film f4 = new Film(4, "Jurassic World:Dominion", 2023);
//		f4.setSessions(sessionMap4);
		Film f5 = new Film(5, "Sonic the Hedgehog 2", 2023);
//		f5.setSessions(sessionMap5);
		
		FilmDAO.getInstance().save(f1);
		FilmDAO.getInstance().save(f2);
		FilmDAO.getInstance().save(f3);
		FilmDAO.getInstance().save(f4);
		FilmDAO.getInstance().save(f5);


		

		
//		System.out.println(FilmDAO.getInstance().getAll());		
		
		
	}
}
