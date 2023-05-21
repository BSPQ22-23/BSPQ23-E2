package com.interfaces;

import javax.swing.*;

import com.example.pojo.Film;
import com.example.server.FilmResource;

import dao.FilmDAO;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.*;
import java.awt.event.*;

public class BillboardWindow extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] movieButtons;
	private List<Film> films;
	private JLabel titleLabel;
	private JButton buscar;
	private JButton back;
	private JComboBox<String> langComboBox;

    /**The Window builder.
     * 
     */
    public BillboardWindow() {
        films = FilmDAO.getInstance().getAll();
        
    	setLocation(550,150);
    	
    	String[] lang = { "English", "Español", "Francais" };
        langComboBox = new JComboBox<>(lang);
        langComboBox.addActionListener(e -> changeLan());
        titleLabel = new JLabel();
        JTextField searchField = new JTextField();
        JPanel moviePanel = new JPanel(new GridLayout(films.size(), 1));
        buscar = new JButton();
        back = new JButton();
        
        
        
        ImageIcon spid = new ImageIcon("spiderman.jpg");
        ImageIcon bat = new ImageIcon("batman.jpg");
        ImageIcon ava = new ImageIcon("avatar.jpg");
        ImageIcon jur = new ImageIcon("dinosaurios.jpg");
        ImageIcon son = new ImageIcon("sonic.jpg");
        
        setSize(500, 500);
    
        movieButtons = new JButton[films.size()]; 
        
     
        JPanel binf = new JPanel();
       
        Container topContainer = new Container();
        topContainer.setLayout(new BorderLayout());
        topContainer.add(searchField, BorderLayout.NORTH);
        topContainer.add(titleLabel, BorderLayout.CENTER);
        topContainer.add(buscar, BorderLayout.EAST);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(topContainer, BorderLayout.NORTH);

        container.add(moviePanel, BorderLayout.CENTER);
        container.add(binf, BorderLayout.SOUTH);
        
        changeUi();
        
        for (int i = 0; i < films.size(); i++) {
            Film film = films.get(i);
            JButton button = new JButton(film.getName()); 
            button.addActionListener(new ActionListener() {
                /**When the window is builded, a button is created for every film in the database, to access their sessions.
                 *
                 */
                public void actionPerformed(ActionEvent e) {              	
                	 for (int i = 0; i < movieButtons.length; i++) {
                         if (e.getSource() == movieButtons[i]) {
                             String movieName = movieButtons[i].getText();
                             new SessionsWindow(movieName, film);
                             break;
                         }
                     }
                }
            });
            movieButtons[i] = button; 
            moviePanel.add(button); 
        }
        
        buscar.addActionListener(new ActionListener() {
			
			/**The button used to search films, which creates a SessionWindow for the searched film(s).
			 *
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String wantedFilm = searchField.getText();
				for(int i = 0; i < films.size(); i++) {
					if(films.get(i).getName().contains(wantedFilm)) {
						new SessionsWindow(films.get(i).getName(), films.get(i));
					}
				}
				
			}
		});
        
       
          
        binf.add(back);
        binf.add(langComboBox);
        	back.addActionListener(new ActionListener() {

    			/**It is used to go back to the MainWindow.
    			 *
    			 */
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				MainWindow vp = new MainWindow();
    				dispose();
    				
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
   	 String backText = bundle.getString("back_button");
   	 String busText = bundle.getString("search_button");
   	 buscar.setText(busText);
   	 back.setText(backText);
		
	}

    
    

    public static void main(String[] args) {
        BillboardWindow bw = new BillboardWindow();
    }




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


