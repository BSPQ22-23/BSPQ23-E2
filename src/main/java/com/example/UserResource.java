package com.example;

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

@Path("users")
public class UserResource {

    public enum Order {
        ASC,
        DESC;        

        // case insensitive values for order parameter
        public static Order fromString(String value) {
            return Order.valueOf(value.toUpperCase());
        }
    }
    
    static List<User> users = new ArrayList<>();
    static User loggedUser;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(@QueryParam("filter") String str,
        @QueryParam("order") @DefaultValue("ASC") Order order) {
        
            // This data SHOULD be retrieved from a database
        /*users.add(new User(0, "John", "Smith", "jonhn@smith.com", "pass1"));
        users.add(new User(1, "Isaac", "Newton", "isaac@newton.es", "pass2"));
        users.add(new User(2, "Albert", "Einstein", "albert@einstein.es", "pass3"));*/

        Stream<User> stream = users.stream();
        // check if the query parameter was passed in the URL
        if (str != null) {
            stream = stream.filter(user -> user.getSurname().contains(str));
        }

        // sort the stream by the passed parameter
        // as the parameter has a default value there is no need to
        // check if the parameter is null
        if (order == Order.DESC) {
            stream = stream.sorted(Comparator.comparing(User::getSurname).reversed()); //Here is stated that the parameter to compare is 
        } else {																	   //the surname starting from the last character 
            stream = stream.sorted(Comparator.comparing(User::getSurname));
        }

        // return the resulting stream as a list
        return stream.collect(Collectors.toList());
    }

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
        // return a response containing a user with the user
        return Response.ok(user).build();
    }
    
    @GET
    @Path("/login={name}&{pass}")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response logIn(@PathParam("name") String username, @PathParam("pass") String password) {
    	for (int i=0; i<users.size(); i++) {
    		//System.out.println(username);
    		//System.out.println(users.get(i).getName());
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
    	for (int i=0; i<users.size(); i++) {
    		//System.out.println(email);
    		//System.out.println(users.get(i).getEmail());
    		if(users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password)) {
    			
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

    @DELETE
    @Path("/delete={code}")
    public Response deleteUser(@PathParam("code") int code) {
    	for (int i=0; i<users.size(); i++) {
    		if (users.get(i).getCode() == code) {
                System.out.println("Deleting user...");
                users.remove(i);
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
    	}
    	return Response.status(Response.Status.NOT_FOUND).build();
    }
}