package com.interfaces;

import javax.swing.*;

import com.example.client.ClientApp;

import java.awt.*;
import java.awt.event.*;
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

    public LoginWindow() {
        // Configurar la ventana
        // Crear los componentes
        JLabel usernameLabel = new JLabel("Name:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel surenameLabel = new JLabel("Surename:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        emailField = new JTextField(30);
        surenameField = new JTextField(20);
        registerButton = new JButton("Registrarse");
        registerButton.setSize(50,50);
        loginButton = new JButton("Iniciar sesión con nombre");
        loginButton.setSize(50,50);
        eloginButton = new JButton("Iniciar sesión con email");
        eloginButton.setSize(50,50);

        // Agregar los componentes a la ventana
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
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.add(labelPanel);
        mainPanel.add(buttonPanel);
        container.add(mainPanel);

        // Agregar los listeners a los botones
        registerButton.addActionListener(this);
        loginButton.addActionListener(this);
        eloginButton.addActionListener(this);

        // Mostrar la ventana
        setTitle("Login/Register");
    	setLocation(550, 150);
		setSize(500, 500);
		setResizable(false);
        setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

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
            // Lógica para iniciar sesión con el usuario
            ClientApp.searchUser(name, password);
            
        } else if (e.getSource() == eloginButton) {
        	
        	ClientApp.loadUsers();
        	
        	String email = emailField.getText();
        	String password = new String(passwordField.getPassword());
        	
        	ClientApp.esearchUser(email, password);
        	
        }
        
        
    }
    public static void main(String[] args) {
        LoginWindow lw = new LoginWindow();
      }
}
