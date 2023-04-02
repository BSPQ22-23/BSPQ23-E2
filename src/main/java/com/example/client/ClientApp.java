package com.example.client;

import java.util.*;
import java.util.Scanner;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.pojo.User;

public class ClientApp {

    private static final String SERVER_ENDPOINT = "http://localhost:8080/webapi";
    private static final String USERS_RESOURCE ="users";
    private static final String REGISTER ="users/register";

    public static void main(String[] args) {
        // create the jersey client and configure the application endpoint
        Client client = ClientBuilder.newClient();
        final WebTarget appTarget = client.target(SERVER_ENDPOINT);


        // sending a POST with a new user
        try {
            Response res = appTarget.path(USERS_RESOURCE)
            .queryParam("order", "desc")
            .request(MediaType.APPLICATION_JSON)
            .get();
            int number = 0;
            // check that the response was HTTP OK
            if (res.getStatusInfo().toEnum() == Status.OK) {
                // the response is a generic type (a List<User>)
                GenericType<List<User>> listType = new GenericType<List<User>>(){};
                List<User> listusers = res.readEntity(listType);
                number = listusers.size();
            } else {
                System.out.format("Error obtaining user list. %s%n", res);
            }


            Scanner sc = new Scanner(System.in);
            int code = number + 1;
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Surname: ");
            String surname = sc.nextLine();
            System.out.print("E-mail: ");
            String email = sc.nextLine();
            System.out.print("Password: ");
            String pass = sc.nextLine();
            sc.close();

            User user = new User(code, name, surname, email, pass);
            Response response = appTarget.path(REGISTER)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(user, MediaType.APPLICATION_JSON)
            );

            // check if the response was ok
            if (response.getStatusInfo().toEnum() == Status.OK) {
                // obtain the response data (contains a user with the new code)
                User userCode = response.readEntity(User.class);
                System.out.format("User registered with code %d%n", userCode.getCode());
            } else {
                System.out.format("Error posting a user list. %s%n", response);
            }
        } catch (ProcessingException e) {
            System.out.format("Error posting a new user. %s%n", e.getMessage());
        }
         
        try {
            User user = new User(0, "John", "Smith", "jonhn@smith.com", "pass1");
            Response response = appTarget.path(REGISTER)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(user, MediaType.APPLICATION_JSON)
            );

            // check if the response was ok
            if (response.getStatusInfo().toEnum() == Status.OK) {
                // obtain the response data (contains a user with the new code)
                User userCode = response.readEntity(User.class);
                System.out.format("User registered with code %d%n", userCode.getCode());
            } else {
                System.out.format("Error posting a user list. %s%n", response);
            }
        } catch (ProcessingException e) {
            System.out.format("Error posting a new user. %s%n", e.getMessage());
        }
        
        
     // issuing a GET request to the users endpoint with some query parameters
        try {
            Response response = appTarget.path(USERS_RESOURCE)
                //.queryParam("filter", "e") //here is made that only the users with last surname letter "e" are shown
                .queryParam("order", "desc") 
                .request(MediaType.APPLICATION_JSON)
                .get();

            // check that the response was HTTP OK
            if (response.getStatusInfo().toEnum() == Status.OK) {
                // the response is a generic type (a List<User>)
                GenericType<List<User>> listType = new GenericType<List<User>>(){};
                List<User> users = response.readEntity(listType);
                System.out.println(users);
            } else {
                System.out.format("Error obtaining user list. %s%n", response);
            }
        } catch (ProcessingException e) {
            System.out.format("Error obtaining user list. %s%n", e.getMessage());
        }

        // sending a DELETE request to the server

        try {
            int code = 1;
            Response response = appTarget.path(USERS_RESOURCE)
                .path("delete=" + Integer.toString(code))
                .request()
                .delete();

            // check if the response was ok
            if (response.getStatusInfo().toEnum() == Status.OK) {
                System.out.println("User correctly deleted from server");
            } else {
                System.out.format("Error deleting a user list. %s%n", response);
            }
        } catch (ProcessingException e) {
            System.out.format("Error posting a new user. %s%n", e.getMessage());
        }
        
        try {
            Response response = appTarget.path(USERS_RESOURCE)
                //.queryParam("filter", "e") //here is made that only the users with last surname letter "e" are shown
                .queryParam("order", "desc") 
                .request(MediaType.APPLICATION_JSON)
                .get();

            // check that the response was HTTP OK
            if (response.getStatusInfo().toEnum() == Status.OK) {
                // the response is a generic type (a List<User>)
                GenericType<List<User>> listType = new GenericType<List<User>>(){};
                List<User> users = response.readEntity(listType);
                System.out.println(users);
            } else {
                System.out.format("Error obtaining user list. %s%n", response);
            }
        } catch (ProcessingException e) {
            System.out.format("Error obtaining user list. %s%n", e.getMessage());
        }
        
        try {
        	String name = "John";
        	String password = "pass1";
            Response response = appTarget.path(USERS_RESOURCE)
                .path("login="+ name + "&" + password)
                //.queryParam("name", "John")
                //.queryParam("pass", "pass1")
                .request(MediaType.APPLICATION_JSON)
                .get();
            
            
            
            // check that the response was HTTP OK
            if (response.getStatusInfo().toEnum() == Status.OK) {
                System.out.println("User successfully logged");
            } else {
                System.out.format("Error logging in. %s%n", response);
            }
        } catch (ProcessingException e) {
            System.out.format("Error logging in. %s%n", e.getMessage());
        }
        
        try {
        	String email = "jonhn@smith.com";
        	String password = "pass1";
            Response response = appTarget.path(USERS_RESOURCE)
                .path("elogin="+ email + "&" + password)
                //.queryParam("name", "John")
                //.queryParam("pass", "pass1")
                .request(MediaType.APPLICATION_JSON)
                .get();
            
            
            
            // check that the response was HTTP OK
            if (response.getStatusInfo().toEnum() == Status.OK) {
                System.out.println("User successfully logged");
            } else {
                System.out.format("Error logging in. %s%n", response);
            }
        } catch (ProcessingException e) {
            System.out.format("Error logging in. %s%n", e.getMessage());
        }
    }
}
