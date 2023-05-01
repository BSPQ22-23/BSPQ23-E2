package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.client.ClientApp;
import com.example.pojo.User;

import dao.UserDAO;

public class TestClientApp {
	List<User> users;

	@Before
	public void setUp() throws Exception {
		 MockitoAnnotations.openMocks(this);
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewUser() {
		User usertest = new User(10, "test", "test", "test@gmail.com", "test");
		ClientApp.newUser(10, "test", "test", "test@gmail.com", "test");
		users = UserDAO.getInstance().getAll();
		for (User u: users) {
			if (u.getCode() == usertest.getCode()) {
				assertEquals(u, usertest);	
			}
		}	
	}
}
