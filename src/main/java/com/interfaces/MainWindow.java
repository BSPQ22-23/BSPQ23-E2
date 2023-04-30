package com.interfaces;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class MainWindow extends JFrame {


	private JPanel panel;
	private JToolBar bar;
	
	public MainWindow() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		bar = new JToolBar();
		
		JButton bBill = new JButton("Billboard");
		bar.add(bBill);
		JButton bRe = new JButton("Review");
		bar.add(bRe);
		JButton bReser = new JButton("Reserve");
		bar.add(bReser);
		
		bBill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BillboardWindow billw = new BillboardWindow();
				billw.setVisible( true );
				billw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				billw.setResizable(false);
				dispose();	
			}
			
			
		});

		bRe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					
			}
			
			
		});

		bReser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ReservationWindow rw = new ReservationWindow();
			}
			
			
		});
		
		panel.add(bar, BorderLayout.NORTH);
		add(panel);

		setTitle("MainWindow");
	    setVisible(true);
	    setLocation(550, 150);
		setSize(400, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	  public static void main(String[] args) {
		  MainWindow mw = new MainWindow();	
	    }
	
}

