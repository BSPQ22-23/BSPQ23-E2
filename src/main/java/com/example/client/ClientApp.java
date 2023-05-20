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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.pojo.User;
import com.interfaces.*;

public class ClientApp {

    private static final String SERVER_ENDPOINT = "http://localhost:8080/webapi";
    private static final String USERS_RESOURCE ="users";
    private static final String REGISTER ="users/register";
    public static Client client = ClientBuilder.newClient();
    final static WebTarget appTarget = client.target(SERVER_ENDPOINT);
	protected static final Logger logger = LogManager.getLogger();
    static LoginWindow loginWIndow;
    
    public static void main(String[] args) {
        // create the jersey client and configure the application endpoint
        
        

        
        // sending a POST with a new user
        /*try {
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
        }*/
        
     /*   
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
        }*/
        
        loginWIndow = new LoginWindow();
    }
    
    public static void newUser(int code, String name, String surename, String email, String password) {
    	 try {
             Response res = appTarget.path(USERS_RESOURCE)
             .queryParam("order", "desc")
             .request(MediaType.APPLICATION_JSON)
             .get();
             int number = 0;
             // check that the response was HTTP OK
             if (res.getStatusInfo().toEnum() != null) {
                 // the response is a generic type (a List<User>)
                 GenericType<List<User>> listType = new GenericType<List<User>>(){};
                 List<User> listusers = res.readEntity(listType);
                 number = listusers.size();
             } else {
            	 logger.info("Error obtaining user list {}.", res);
             }


             User user = new User(number, name, surename, email, password);
             Response response = appTarget.path(REGISTER)
                 .request(MediaType.APPLICATION_JSON)
                 .post(Entity.entity(user, MediaType.APPLICATION_JSON)
             );

             // check if the response was ok
             if (response.getStatusInfo().toEnum() == Status.OK) {
                 // obtain the response data (contains a user with the new code)
                 User userCode = response.readEntity(User.class);
                 //logger.info("User registered with email: '{}'", userCode.getEmail());
             } else {
                 logger.info("Error posting a user list. '{}'", response);
             }
         } catch (ProcessingException e) {
             logger.info("Error posting a new user. '{}'", e.getMessage());
         }
          /* 
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
         */
    }

    public static void esearchUser( String email, String password){
        try {
            //System.out.println(email);
            //ystem.out.println(password);
            Response response = appTarget.path(USERS_RESOURCE)
                .path("/elogin="+ email + "&" + password)
                .request(MediaType.APPLICATION_JSON)
                .get();
                

            // check if the response was ok
            if (response.getStatusInfo().toEnum() == Status.OK) {
                // obtain the response data (contains a user with the new code)
                System.out.println("all ok");
                logger.info("All ok");
                MainWindow mw = new MainWindow();
                loginWIndow.dispose();
                mw.setVisible(true);
            } else {
                logger.info("Error posting user list: {}", response);
            }
        } catch (ProcessingException e) {
            logger.info("Erro posting a new user: {}", e.getMessage());
        }

    }
    
    public static void searchUser( String username, String password){
        try {
            logger.info(username);
            logger.info(password);
            Response response = appTarget.path(USERS_RESOURCE)
                .path("/login="+ username + "&" + password)
                .request(MediaType.APPLICATION_JSON)
                .get();
             
                

            // check if the response was ok
            if (response.getStatusInfo().toEnum() == Status.OK) {
                // obtain the response data (contains a user with the new code)
                System.out.println("all ok");
                logger.info("All ok");
                
                MainWindow mw = new MainWindow();
                loginWIndow.dispose();
                mw.setVisible(true);
            } else {
                System.out.format("Error posting a user list. %s%n", response);
                logger.info("Error posting a user list: {}", response);
            }
        } catch (ProcessingException e) {
        	logger.info("Error posting a new user: {}", e.getMessage());
        }

    }
    
    public static void loadUsers() {
    	try {
            Response response = appTarget.path(USERS_RESOURCE)
                .queryParam("order", "desc") 
                .request(MediaType.APPLICATION_JSON)
                .get();

            // check that the response was HTTP OK
            if (response.getStatusInfo().toEnum() == Status.OK) {
                // the response is a generic type (a List<User>)
                GenericType<List<User>> listType = new GenericType<List<User>>(){};
                List<User> users = response.readEntity(listType);
                //System.out.println(users);
            } else {
                logger.info("Error obtaining user list. '{}'", response);
            }
        } catch (ProcessingException e) {
            logger.info("Error obtaining user list. '{}'", e.getMessage());
        }
    }
}
