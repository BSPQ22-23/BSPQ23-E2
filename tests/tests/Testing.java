package tests;

import java.sql.Date;
import org.junit.Test;

import com.example.pojo.Film;
import com.example.pojo.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.FilmDAO;
import dao.SessionDAO;
import dao.UserDAO;

public class Testing {

	@Test
	public void databaseChecking() {
		
		Session s1 = new Session(1, java.sql.Date.valueOf("2023-05-12"), "12:00", 1);
		Session s2 = new Session(2, java.sql.Date.valueOf("2023-05-12"), "15:00", 1);
		Session s3 = new Session(3, java.sql.Date.valueOf("2023-05-12"), "18:00", 1);
		
		Session s4 = new Session(4, java.sql.Date.valueOf("2023-05-13"), "12:00", 2);
		Session s5 = new Session(5, java.sql.Date.valueOf("2023-05-13"), "15:00", 2);
		Session s6 = new Session(6, java.sql.Date.valueOf("2023-05-13"), "18:00", 2);
		
		Session s7 = new Session(7, java.sql.Date.valueOf("2023-05-14"), "12:00", 3);
		Session s8 = new Session(8, java.sql.Date.valueOf("2023-05-14"), "15:00", 3);
		Session s9 = new Session(9, java.sql.Date.valueOf("2023-05-14"), "18:00", 3);
		
		Session s10 = new Session(10, java.sql.Date.valueOf("2023-05-15"), "12:00", 4);
		Session s11 = new Session(11, java.sql.Date.valueOf("2023-05-15"), "15:00", 4);
		Session s12 = new Session(12, java.sql.Date.valueOf("2023-05-15"), "18:00", 4);
		
		Session s13 = new Session(13, java.sql.Date.valueOf("2023-05-16"), "12:00", 5);
		Session s14 = new Session(14, java.sql.Date.valueOf("2023-05-16"), "15:00", 5);
		Session s15 = new Session(15, java.sql.Date.valueOf("2023-05-16"), "18:00", 5);
		
		SessionDAO.getInstance().save(s1);
		SessionDAO.getInstance().save(s2);
		SessionDAO.getInstance().save(s3);
		SessionDAO.getInstance().save(s4);
		SessionDAO.getInstance().save(s5);
		SessionDAO.getInstance().save(s6);
		SessionDAO.getInstance().save(s7);
		SessionDAO.getInstance().save(s8);
		SessionDAO.getInstance().save(s9);
		SessionDAO.getInstance().save(s10);
		SessionDAO.getInstance().save(s11);
		SessionDAO.getInstance().save(s12);
		SessionDAO.getInstance().save(s13);
		SessionDAO.getInstance().save(s14);
		SessionDAO.getInstance().save(s15);

		
		Film f1 = new Film(1, "Spiderman-No Way Home", 2023);
		Film f2 = new Film(2, "The Batman", 2023);
		Film f3 = new Film(3, "Avatar 2", 2023);
		Film f4 = new Film(4, "Jurassic World:Dominion", 2023);
		Film f5 = new Film(5, "Sonic the Hedgehog 2", 2023);
		
		FilmDAO.getInstance().save(f1);
		FilmDAO.getInstance().save(f2);
		FilmDAO.getInstance().save(f3);
		FilmDAO.getInstance().save(f4);
		FilmDAO.getInstance().save(f5);


		System.out.println(FilmDAO.getInstance().getAll());		
		
		
	}
}
