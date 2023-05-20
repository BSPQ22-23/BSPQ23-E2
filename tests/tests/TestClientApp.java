package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.PathParam;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.client.ClientApp;
import com.example.pojo.Film;
import com.example.pojo.Session;
import com.example.pojo.User;
import com.interfaces.MainWindow;

import dao.FilmDAO;
import dao.SessionDAO;
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
	@Test
    public void loadUsers() {
		List<User> users;
		users = UserDAO.getInstance().getAll();
		
		assertNotEquals(null, users);
    }
	
	@Test
	public void loadUsersC() {
		List<User> users = new ArrayList<User>();
		ClientApp.loadUsers(users);
		
		assertNotEquals(null, users);
	}
	
	@Test	
    public void getFilms() {
        
    	List<Film> films = FilmDAO.getInstance().getAll();
        Stream<Film> stream = films.stream();

        assertNotEquals(null, stream);
     }
	@Test
    public void loadSession() {
        List<Session> sessions = SessionDAO.getInstance().getAll();
        assertNotEquals(null, sessions);
        
    }
	@Test
    public void logIn() {
		User usertest = new User(10, "test", "test", "test@gmail.com", "test");
		UserDAO.getInstance().save(usertest);
		users = UserDAO.getInstance().getAll();
		
		
		for (int i=0; i<users.size(); i++) {
		
			if(users.get(i).getName().equals("test") && users.get(i).getPassword().equals("test")) {
				assertTrue(true);
			}
		}
		UserDAO.getInstance().delete(usertest);
		
    }
	
	/*@Test
	public void logInC() {
		ClientApp.newUser(10, "test2", "test2", "test2@gmail.com", "test2");
		users = UserDAO.getInstance().getAll();
		
		for (int i=0; i<users.size(); i++) {
			
			if(users.get(i).getName().equals("test2") && users.get(i).getPassword().equals("test2")) {
				assertTrue(true);
			}
		}
		UserDAO.getInstance().delete(usertest);
	}*/
}
