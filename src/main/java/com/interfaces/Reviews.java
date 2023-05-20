package com.interfaces;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Reviews extends JFrame {
    

	private static final long serialVersionUID = 1L;
    private JComboBox<String> moviesComboBox;
    private JComboBox<String> langComboBox;
    private JTextArea reviewTextArea;
    private JButton back;
    public Reviews() {
        setTitle("Reviews");
        setLocation(600,250);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] movies = { "Star Wars", "The Godfather", "Goodfellas", "La La Land", "Cars" };
        String[] lang = { "English", "Español", "Francais" };
        langComboBox = new JComboBox<>(lang);
        langComboBox.addActionListener(e -> changeLan());
        moviesComboBox = new JComboBox<>(movies);
        moviesComboBox.addActionListener(e -> showReview());
        reviewTextArea = new JTextArea(10, 30);
        reviewTextArea.setLineWrap(true);
        reviewTextArea.setWrapStyleWord(true);
        reviewTextArea.setEditable(false);
        
        JPanel panelInf = new JPanel();
		panelInf.setLayout(new BorderLayout());
		getContentPane().add( panelInf, BorderLayout.SOUTH );
		back = new JButton();
		panelInf.add(back);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Select a movie:"));
        panel.add(moviesComboBox);
        panel.add(langComboBox);
        panel.add(new JScrollPane(reviewTextArea));
        add(panel);
        setVisible(true);
        
        changeUi();
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow vp = new MainWindow();
				dispose();
				
			}
		});
    }
  

    private void showReview() {

        String movie = (String) moviesComboBox.getSelectedItem();
        
        ResourceBundle bundle = ResourceBundle.getBundle("language", Locale.getDefault());
        switch (movie) {
            case "Star Wars":
                reviewTextArea.setText(bundle.getString("starwars_review"));
                break;
            case "The Godfather":
                reviewTextArea.setText(bundle.getString("godfather_review"));
                break;
            case "Goodfellas":
                reviewTextArea.setText(bundle.getString("goodfellas_review"));
                break;
            case "La La Land":
                reviewTextArea.setText(bundle.getString("lalaland_review"));
                break;
            case "Cars":
                reviewTextArea.setText(bundle.getString("cars_review"));
                break;
            default:
                reviewTextArea.setText("");
                
        }
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
        showReview();
        changeUi();
    }

    private void changeUi() {
    	 ResourceBundle bundle = ResourceBundle.getBundle("language");
    	 String backText = bundle.getString("back_button");
    	 back.setText(backText);
		
	}

	public static void main(String[] args) {
        new Reviews();
    }

}