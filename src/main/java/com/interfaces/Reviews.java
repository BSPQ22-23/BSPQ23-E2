package com.interfaces;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextArea reviewTextArea;

    public Reviews() {
        setTitle("Reviews");
        setLocation(600,250);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] movies = { "Star Wars", "The Godfather", "Goodfellas", "La La Land", "Cars" };
        moviesComboBox = new JComboBox<>(movies);
        moviesComboBox.addActionListener(e -> showReview());
        reviewTextArea = new JTextArea(10, 30);
        reviewTextArea.setLineWrap(true);
        reviewTextArea.setWrapStyleWord(true);
        reviewTextArea.setEditable(false);
        
        JPanel panelInf = new JPanel();
		panelInf.setLayout(new BorderLayout());
		getContentPane().add( panelInf, BorderLayout.SOUTH );
		JButton back = new JButton("Back");
		panelInf.add(back);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Select a movie:"));
        panel.add(moviesComboBox);
        panel.add(new JScrollPane(reviewTextArea));
        add(panel);
        setVisible(true);
        
        
		
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

        switch (movie) {
            case "Star Wars":
                reviewTextArea.setText("Star Wars Episode IV is an epic space opera film directed by George Lucas. Released in 1977, it follows the journey of Luke Skywalker as he joins the Rebel Alliance in their fight against the evil Galactic Empire. The film is known for its groundbreaking visual effects, iconic characters such as Darth Vader and Princess Leia, and its memorable score composed by John Williams. With a thrilling story and a sense of adventure that has captivated audiences for decades, Star Wars Episode IV is a true classic of cinema.");
                break;
            case "The Godfather":
                reviewTextArea.setText("The Godfather is a timeless classic of cinema directed by Francis Ford Coppola. Released in 1972, it tells the story of the Corleone family, a powerful Italian-American mafia family in New York City. The film is known for its brilliant performances by Marlon Brando, Al Pacino, and James Caan, as well as its iconic scenes and memorable dialogue. With themes of family, loyalty, and betrayal, The Godfather is a masterpiece of storytelling that continues to captivate audiences to this day.");
                break;
            case "Goodfellas":
                reviewTextArea.setText("Goodfellas is a gripping crime drama film directed by Martin Scorsese. Released in 1990, it tells the story of Henry Hill, a young man who rises through the ranks of the Italian-American mafia in New York City. The film is known for its raw and realistic portrayal of the mafia lifestyle, as well as its stellar cast including Robert De Niro, Joe Pesci, and Ray Liotta. With its expert direction, incredible performances, and unforgettable scenes, Goodfellas is a true masterpiece of cinema and a must-watch for fans of the genre.");
                break;
            case "La La Land":
                reviewTextArea.setText("La La Land is a modern musical film directed by Damien Chazelle. Released in 2016, it tells the story of Mia, an aspiring actress, and Sebastian, a jazz pianist, as they pursue their dreams in Los Angeles. The film is known for its vibrant and colorful cinematography, catchy songs, and incredible performances by Emma Stone and Ryan Gosling. With a nostalgic nod to classic Hollywood musicals, La La Land is a charming and uplifting film that will leave you humming its tunes long after the credits roll.");
                break;
            case "Cars":
                reviewTextArea.setText("Cars is a delightful animated movie produced by Pixar Animation Studios. Released in 2006, it tells the story of Lightning McQueen, a hotshot race car who finds himself stranded in a small town called Radiator Springs. The film is known for its stunning visuals, lovable characters, and heartwarming themes of friendship and self-discovery. With an all-star voice cast that includes Owen Wilson, Paul Newman, and Bonnie Hunt, Cars is a fun-filled adventure that will entertain audiences of all ages.");
                break;
            default:
                reviewTextArea.setText("");
                
        }
    }

    public static void main(String[] args) {
        new Reviews();
    }

}