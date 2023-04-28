package com.interfaces;

import javax.swing.*;

import com.example.client.ClientApp;

import java.awt.*;
import java.awt.event.*;

public class LoginWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField surenameField;
    private JButton registerButton;
    private JButton loginButton;

    public LoginWindow() {
        // Configurar la ventana
        setTitle("Registro e inicio de sesión");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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
        loginButton = new JButton("Iniciar sesión");

        // Agregar los componentes a la ventana
        Container container = getContentPane();
        container.setLayout(new GridLayout(3, 2));
        container.add(usernameLabel);
        container.add(usernameField);
        container.add(surenameLabel);
        container.add(surenameField);
        container.add(emailLabel);
        container.add(emailField);
        container.add(passwordLabel);
        container.add(passwordField);
        
        container.add(registerButton);
        container.add(loginButton);

        // Agregar los listeners a los botones
        registerButton.addActionListener(this);
        loginButton.addActionListener(this);

        // Mostrar la ventana
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
        	
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();
            String surename = surenameField.getText();
            ClientApp.newUser(1, username, surename, email, password);
            
            
            
        } else if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            // Lógica para iniciar sesión con el usuario
            // ...
        }
        
        
    }
    
    public static void main(String[] args) {
        LoginWindow window = new LoginWindow();
     }
}
