package com.interfaces;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class MainWindow extends JFrame {


	private JPanel panel;
	private JToolBar bar;
	private JComboBox<String> langComboBox;
	private JButton bBill;
	private JButton bRe;
	private JButton bReser;
	
	public MainWindow() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		bar = new JToolBar();
		String[] lang = { "English", "Español", "Francais" };
        langComboBox = new JComboBox<>(lang);
        langComboBox.addActionListener(e -> changeLan());
        
		
		bBill = new JButton();
		bar.add(bBill);
		bRe = new JButton();
		bar.add(bRe);
		bReser = new JButton();
		bar.add(bReser);
		
		bar.add(langComboBox);
		
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
				Reviews re = new Reviews();	
				dispose();
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
		changeUi();
	}
	
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
	  
	    private void changeUi() {
	    	 ResourceBundle bundle = ResourceBundle.getBundle("language");
	    	 String billText = bundle.getString("bill_button");
	    	 String reText = bundle.getString("re_button");
	    	 String reserText = bundle.getString("reser_button");
	    	 bBill.setText(billText);
	    	 bRe.setText(reText);
	    	 bReser.setText(reserText);
			
		}
	
	  public static void main(String[] args) {
		  MainWindow mw = new MainWindow();	
	    }
	
}

