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

import com.example.pojo.User;
import dao.UserDAO;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Path("users")

public class UserResource {
    public static final UserDAO a = UserDAO.getInstance();
	protected static final Logger logger = LogManager.getLogger();
	
	//private int cont = 0;
	private PersistenceManager pm=null;
	private Transaction tx=null;
    
    static List<User> users = new ArrayList<User>();
    public enum Order {
        ASC,
        DESC;        

        // case insensitive values for order parameter
        public static Order fromString(String value) {
            return Order.valueOf(value.toUpperCase());
        }
    }
    
    public UserResource() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction();
	}
    
    static User loggedUser;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        
        // This data SHOULD be retrieved from a database
        /*users.add(new User(0, "John", "Smith", "jonhn@smith.com", "pass1"));
        users.add(new User(1, "Isaac", "Newton", "isaac@newton.es", "pass2"));
        users.add(new User(2, "Albert", "Einstein", "albert@einstein.es", "pass3"));*/
        
    	users = UserDAO.getInstance().getAll();
    	
        System.out.println(users);
        Stream<User> stream = users.stream();

        // return the resulting stream as a list
        return stream.collect(Collectors.toList());
    }
    
    /*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register")
    public Response addUser(User user) {
        
        for (int i=0; i<users.size(); i++) {
        	if(users.get(i).getEmail().equals(user.getEmail())) {
        		return Response.status(Response.Status.FORBIDDEN).build();
        	}
        }
        System.out.println("Adding a new user: " + user.getName() + " " + user.getSurname() + " with email: " + user.getEmail());
        users.add(user);
        
        a.save(user);
        // return a response containing a user with the user
        return Response.ok(user).build();
    }*/
    
    
    //The same metohod but with databse
    @POST
	@Path("/register")
	public Response registerUser(User user) {
		try
        {	
            tx.begin();
            logger.info("Checking whether the user already exits or not");
            
            for (int i=0; i<users.size(); i++) {
            	if(users.get(i).getEmail().equals(user.getEmail())) {
            		return Response.status(Response.Status.FORBIDDEN).build();
            	}
            }
            user.setCode(users.size()+1);
            UserDAO.getInstance().save(user);
			return Response.ok().build();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
      
		}
	}
    
    @GET
    @Path("/login={name}&{pass}")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response logIn(@PathParam("name") String username, @PathParam("pass") String password) {
    	
    	for (int i=0; i<users.size(); i++) {
    		System.out.println(username);
    		System.out.println(users.get(i).getName());
    		if(users.get(i).getName().equals(username) && users.get(i).getPassword().equals(password)) {
    			
    			System.out.println("User found");
    			loggedUser = users.get(i);
    			System.out.println(users.get(i));
    			return Response.status(Response.Status.OK).build();
    		} else {
    			
    			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    		}
    	}
    	
    	return Response.status(Response.Status.NOT_FOUND).build();
    }
    

    @GET
    @Path("/elogin={email}&{pass}")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response elogIn(@PathParam("email") String email, @PathParam("pass") String password) {
        users = a.getAll();
        System.out.println(users);
    	for (int i=0; i<users.size(); i++) {
    		if(users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password)) {
    			
    			System.out.println("User found");
    			loggedUser = users.get(i);
    			System.out.println(users.get(i));
    			return Response.status(Response.Status.OK).build();
    		}
    	}
    	
    	return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/delete={code}")
    public Response deleteUser(@PathParam("code") int code) {
    	for (int i=0; i<users.size(); i++) {
    		if (users.get(i).getCode() == code) {
                System.out.println("Deleting user...");
                UserDAO.getInstance().delete(users.get(i));
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
    	}
    	return Response.status(Response.Status.NOT_FOUND).build();
    }
}