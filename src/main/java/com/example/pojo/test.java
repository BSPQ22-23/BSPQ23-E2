package com.example.pojo;


import org.junit.Test;

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
		
		System.out.println(UserDAO.getInstance().getAll());		
		
		
	}
}
