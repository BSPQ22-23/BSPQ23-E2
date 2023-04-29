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
		
		panel.add(bar, BorderLayout.NORTH);
		add(panel);
		
	}
	
	  public static void main(String[] args) {
		  MainWindow mw = new MainWindow();
	       	mw.setTitle("MainWindow");
	    	mw.setVisible(true);
	    	mw.setLocation(550, 150);
			mw.setSize(400, 400);
			mw.setResizable(false);
			mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	
}
