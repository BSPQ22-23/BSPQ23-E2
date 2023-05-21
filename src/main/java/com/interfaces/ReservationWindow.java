package com.interfaces;

import javax.swing.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.example.client.ClientApp;
import com.example.pojo.Reservation;
import com.example.pojo.Session;

import dao.SessionDAO;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import dao.SessionDAO;

public class ReservationWindow extends JFrame implements ActionListener{
    
    static List<Session> sessi = new ArrayList<Session>();
    public static final SessionDAO se = SessionDAO.getInstance();
    private JComboBox<String> langComboBox;
    private JLabel Fecha;
    private JLabel Hora;
    private JButton cancelButton;
    private JLabel seatLabel;
    private JLabel rowLabel;
    private JButton reserveButton;
    /**The window builder.
     * 
     */
    public ReservationWindow(){

        setTitle("Reservation");
        setSize(400, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String[] lang = { "English", "Español", "Francais" };
        langComboBox = new JComboBox<>(lang);
        langComboBox.addActionListener(e -> changeLan());
        
        Fecha = new JLabel();
        Hora = new JLabel();

        
        JTextField datetext = new JTextField();
        JTextField hourtext = new JTextField();
        
        datetext.setBounds(90, 50, 100, 30);
        add(datetext);
        
        hourtext.setBounds(250, 50, 100, 30);
        add(hourtext);
        
        Fecha.setBounds(50, 50, 100, 30);
        add(Fecha);
        
        Hora.setBounds(210, 50, 100, 30);
        add(Hora);

        seatLabel = new JLabel();
        seatLabel.setBounds(50, 150, 100, 30);
        add(seatLabel);

        rowLabel = new JLabel();
        rowLabel.setBounds(50, 100, 150, 30);
        add(rowLabel);

        reserveButton = new JButton();
        reserveButton.setBounds(50, 200, 100, 30);
      
        cancelButton = new JButton();
        cancelButton.setBounds(250, 200, 100, 30);
        
        langComboBox.setBounds(150,200, 100, 30);
        
        add(cancelButton);
        add(langComboBox);
        add(reserveButton);
        

        
        
        
        changeUi();
        /*
        JTextField seatTextField = new JTextField();
        seatTextField.setBounds(200, 100, 150, 30);
        add(seatTextField);

        JTextField rowTextField = new JTextField();
        rowTextField.setBounds(150, 150, 200, 30);
        add(rowTextField);
         */

        JComboBox firstComboBox = new JComboBox(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10});
        JComboBox secondComboBox = new JComboBox();
        

        reserveButton.addActionListener(new ActionListener() {
            /**Creates the reservation with the selected fields (date, hour, row and seat).
             *
             */
            public void actionPerformed(ActionEvent e) {
                
            		String dateS = (String)datetext.getText();
            		String hourS = (String)hourtext.getText();
            		
                    int seat = (Integer)firstComboBox.getSelectedItem();
                    int row = (Integer)secondComboBox.getSelectedItem();
                    
                    ClientApp.Makereservation(seat,row,dateS,hourS);
                    
                    dispose();
                    MainWindow mw = new MainWindow();

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            /**Closes the window and goes back to MainWindow.
             *
             */
            public void actionPerformed(ActionEvent e) {
                
                dispose();
                MainWindow mw = new MainWindow();

            }
        });

        
        secondComboBox.setBounds(150, 150, 200, 30);
        firstComboBox.setBounds(200, 100, 150, 30);
        add(firstComboBox);
        add(secondComboBox);

        firstComboBox.addActionListener(new ActionListener() {
            /**It is used to automatically fill the second combobox with the data of the firs one, just for avoiding null purposes.
             *
             */
            public void actionPerformed(ActionEvent e) {


                Integer[] numbersecondComboBox = new Integer[6];
                
                for(int i=1; i<7; i++){
                    numbersecondComboBox[i-1] = i * 2;
                }
                secondComboBox.setModel(new DefaultComboBoxModel(numbersecondComboBox));

            }
        });
        
        setVisible(true);


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
   	 String dateText = bundle.getString("date_label");
   	 String hourText = bundle.getString("hour_label");
   	 String backText = bundle.getString("back_button");
   	 String seatText = bundle.getString("seat_label");
   	 String rowText = bundle.getString("row_label");
   	 String reserveText = bundle.getString("reserve_button");
   	 Fecha.setText(dateText);
   	 Hora.setText(hourText);
   	 cancelButton.setText(backText);
   	 seatLabel.setText(seatText);
   	 rowLabel.setText(rowText);
   	 reserveButton.setText(reserveText);
   	 
   	 
		
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


    public static void main(String[] args) {
        ReservationWindow rw = new ReservationWindow();
      }
}
