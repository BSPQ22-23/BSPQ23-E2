package com.interfaces;

import javax.swing.*;

import com.example.client.ClientApp;
import com.example.pojo.Reservation;
import com.example.pojo.Session;

import dao.SessionDAO;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class ReservationWindow extends JFrame implements ActionListener{
    
    static List<Session> sessi = new ArrayList<Session>();
    public static final SessionDAO se = SessionDAO.getInstance();

    public ReservationWindow(){

        setTitle("Reservation");
        setSize(400, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        JLabel datelabel = new JLabel("Date:");
        datelabel.setBounds(50, 50, 100, 30);
        add(datelabel);

        JLabel seatlabel = new JLabel("Seat number:");
        seatlabel.setBounds(50, 150, 100, 30);
        add(seatlabel);

        JLabel rowlabel = new JLabel("Row:");
        rowlabel.setBounds(50, 100, 150, 30);
        add(rowlabel);

        JButton reserveButton = new JButton("Reserve");
        reserveButton.setBounds(50, 200, 100, 30);
        add(reserveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 200, 100, 30);
        add(cancelButton);

        JTextField dateTextField = new JTextField();
        dateTextField.setBounds(150, 50, 200, 30);
        add(dateTextField);
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
            public void actionPerformed(ActionEvent e) {
                
                    String session =  dateTextField.getText();
                    int seat = (Integer)firstComboBox.getSelectedItem();
                    int row = (Integer)secondComboBox.getSelectedItem();
                    
                    Reservation r = new Reservation();
                    
                    dispose();
                    MainWindow mw = new MainWindow();

            }
        });

        cancelButton.addActionListener(new ActionListener() {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


    public static void main(String[] args) {
        ReservationWindow rw = new ReservationWindow();
      }
}
