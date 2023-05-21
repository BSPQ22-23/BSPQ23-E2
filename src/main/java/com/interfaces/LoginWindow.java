package com.interfaces;

import javax.swing.*;

import com.example.client.ClientApp;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;

import dao.UserDAO;

public class LoginWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField surenameField;
    private JButton registerButton;
    private JButton loginButton;
    private JButton eloginButton;
    private JComboBox<String> langComboBox;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JLabel surenameLabel;

    /**The window builder.
     * 
     */
    public LoginWindow() {
     
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        emailLabel = new JLabel();
        surenameLabel = new JLabel();
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        emailField = new JTextField(30);
        surenameField = new JTextField(20);
        registerButton = new JButton();
        registerButton.setSize(50,50);
        loginButton = new JButton();
        loginButton.setSize(50,50);
        eloginButton = new JButton();
        eloginButton.setSize(50,50);
        
        String[] lang = { "English", "Español", "Francais" };
        langComboBox = new JComboBox<>(lang);
        langComboBox.addActionListener(e -> changeLan());

        
        Container container = getContentPane();
        JPanel labelPanel = new JPanel(new GridLayout(2, 2));
        labelPanel.add(usernameLabel);
        labelPanel.add(usernameField);
        labelPanel.add(surenameLabel);
        labelPanel.add(surenameField);
        labelPanel.add(emailLabel);
        labelPanel.add(emailField);
        labelPanel.add(passwordLabel);
        labelPanel.add(passwordField);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);
        buttonPanel.add(eloginButton);
        buttonPanel.add(langComboBox);
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.add(labelPanel);
        mainPanel.add(buttonPanel);
        container.add(mainPanel);

      
        registerButton.addActionListener(this);
        loginButton.addActionListener(this);
        eloginButton.addActionListener(this);

        
        setTitle("Login/Register");
    	setLocation(550, 150);
		setSize(500, 500);
		setResizable(false);
        setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		changeUi();
    }

    /**Performs a different action depends on the pressed button. It can login with email and password, username and password, or register a user.
     * If for example the user wants to login with email, they can do it by filling the relevant fields.
     *
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
        	
        	ClientApp.loadUsers();
        	
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();
            String surename = surenameField.getText();
            ClientApp.newUser(1, username, surename, email, password);
            
            
            
            
        } else if (e.getSource() == loginButton) {
        	
        	ClientApp.loadUsers();
        	
            String name = usernameField.getText();
            String password = new String(passwordField.getPassword());
       
            ClientApp.searchUser(name, password);
            
        } else if (e.getSource() == eloginButton) {
        	
        	ClientApp.loadUsers();
        	
        	String email = emailField.getText();
        	String password = new String(passwordField.getPassword());
        	
        	ClientApp.esearchUser(email, password);
        	
        }
        
        
    }
    /**The function used to change the language of the app.
     * 
     */
    private void changeLan() {

        String lang = (String) langComboBox.getSelectedItem();
        Locale locale;
        switch (lang) {
            case "English":
            	locale = new Locale("en");
                break;
            case "Español":
            	locale = new Locale("es");    
            	break;
            case "Francais":
            	locale = new Locale("fr"); 
            	break;  
            default:
            	locale = Locale.ENGLISH;
          
        }
        
        Locale.setDefault(locale);
        changeUi();
    }
    
    /**Changes the UI of the window based on the current language.
     * 
     */
    private void changeUi() {
   	 ResourceBundle bundle = ResourceBundle.getBundle("language");
   	 String regisText = bundle.getString("register_button");
   	 String loginText = bundle.getString("login_button");
   	 String eloginText = bundle.getString("elogin_button");
   	 String nameText = bundle.getString("name_label");
   	 String surText = bundle.getString("surename_label");
   	 String passText = bundle.getString("pass_label");
   	 String emailText = bundle.getString("email_label");
   	 registerButton.setText(regisText);
   	 loginButton.setText(loginText);
   	 eloginButton.setText(eloginText);
   	 usernameLabel.setText(nameText);
   	 surenameLabel.setText(surText);
   	 passwordLabel.setText(passText);
   	 emailLabel.setText(emailText);
   	 
   	 
		
	}
    
    
    
    public static void main(String[] args) {
        LoginWindow lw = new LoginWindow();
      }
}
