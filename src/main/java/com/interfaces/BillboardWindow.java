package com.interfaces;

import javax.swing.*;

import com.example.pojo.Film;
import com.example.server.FilmResource;

import dao.FilmDAO;

import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class BillboardWindow extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] movieButtons;
	private List<Film> films;

    public BillboardWindow() {
        // Configurar la ventana
    	setLocation(550,150);
        // Crear los componentes
        JLabel titleLabel = new JLabel("Billboard");
        JPanel moviePanel = new JPanel(new GridLayout(0, 1));
        
        ImageIcon spid = new ImageIcon("spiderman.jpg");
        ImageIcon bat = new ImageIcon();
        ImageIcon ava = new ImageIcon();
        ImageIcon jur = new ImageIcon();
        ImageIcon son = new ImageIcon();
        
        setSize(400, 400);
    
        films = FilmDAO.getInstance().getAll();
        
     
        JPanel binf = new JPanel();
       

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(titleLabel, BorderLayout.NORTH);
        container.add(moviePanel, BorderLayout.CENTER);
        container.add(binf, BorderLayout.SOUTH);
        
        for (int i = 0; i < films.size(); i++) {
            Film film = films.get(i);
            JButton button = new JButton(film.getName()); 
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	 for (int i = 0; i < movieButtons.length; i++) {
                         if (e.getSource() == movieButtons[i]) {
                             String movieName = movieButtons[i].getText();
                             new SessionsWindow(movieName);
                             break;
                         }
                     }
                }
            });
            movieButtons[i] = button; // agrega el botón al arreglo
            add(button); // agrega el botón al panel
        }
        
       
        JButton back = new JButton("Back");  
        binf.add(back);
        	back.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				MainWindow vp = new MainWindow();
    				dispose();
    				
    			}
    		});

        // Mostrar la ventana
        setVisible(true);
    }

    
    

    public static void main(String[] args) {
        BillboardWindow bw = new BillboardWindow();
    }




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
