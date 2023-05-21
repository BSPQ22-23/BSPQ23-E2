package com.interfaces;


import javax.swing.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.example.client.ClientApp;
import com.example.pojo.Reservation;
import com.example.pojo.Session;

import dao.ReservationDAO;
import dao.SessionDAO;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import dao.SessionDAO;



public class CancelReserveWindow extends JFrame implements ActionListener {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static List<Session> sessi = new ArrayList<Session>();
    public static final ReservationDAO re = ReservationDAO.getInstance();

    /**The window builder.
     * 
     */
    public CancelReserveWindow(){
		setTitle("Cancel Reservation");
	    setSize(400, 300);
	    getContentPane().setBackground(Color.WHITE);
	    setLayout(null);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		    
	    JLabel cancelation = new JLabel("Select Reserve:");
	    
	    cancelation.setBounds(50, 85, 100, 30);
	    add(cancelation);
	
        JComboBox<Reservation> firstComboBox = new JComboBox<Reservation>();
        
        List<Reservation> reserves = re.getAll();
        
        for (Reservation reservation : reserves) {
        	firstComboBox.addItem(reservation);
		}
	    
        JButton CancelreserveButton = new JButton("Cancel Reserve");
        CancelreserveButton.setBounds(50, 200, 100, 30);
        add(CancelreserveButton);
        firstComboBox.setBounds(150, 85, 250, 30);
        add(firstComboBox);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 200, 100, 30);
        add(cancelButton);
	
	    CancelreserveButton.addActionListener(new ActionListener() {
	        /**Calls the method to cancel the selected reservation, then goes back to the MainWindow.
	         *
	         */
	        public void actionPerformed(ActionEvent e) {
	            
	        		Reservation can = (Reservation) firstComboBox.getSelectedItem();
	        		ClientApp.CancelReservation(can);
	                dispose();
	                MainWindow mw = new MainWindow();
	
	        }
	    });
	
	    cancelButton.addActionListener(new ActionListener() {
	        /**Returns to the MainWindow.
	         *
	         */
	        public void actionPerformed(ActionEvent e) {
	            
	            dispose();
	            MainWindow mw = new MainWindow();
	
	        }
	    });
	    
	    setVisible(true);
	
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}
	
	
	public static void main(String[] args) {
		CancelReserveWindow crw = new CancelReserveWindow();
	  }
	
	
}
