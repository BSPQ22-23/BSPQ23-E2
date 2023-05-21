package com.interfaces;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.pojo.Film;
import com.example.pojo.Session;

import dao.SessionDAO;

class SessionsWindow extends JFrame {
	List<Session> allSessions;
	List<Session> sessions;
	
	
    /**The window builder. This window shows all the sessions assigned to a film.
     * @param movieName A string containing the exact Name field of a film.
     * @param film The film object to retrieve its data to show it on the window.
     */
    public SessionsWindow(String movieName, Film film) {
    	allSessions = SessionDAO.getInstance().getAll();
    	sessions = new ArrayList<Session>();
    	for(int i=0; i<allSessions.size(); i++) {
        	if (allSessions.get(i).getFilm() == film.getCode()) {
        		sessions.add(allSessions.get(i));
        	}
        }
      
        setTitle(movieName);
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        List<JLabel> filmLabels = new ArrayList<JLabel>();
        

       
        JLabel titleLabel = new JLabel(movieName);
        JPanel sesionesPanel = new JPanel(new GridLayout(sessions.size(), 1));
        for(int i=0; i<sessions.size(); i++) {
        	JLabel sessionLabel =  new JLabel(sessions.get(i).toString());
        	filmLabels.add(sessionLabel);
        }
        //JLabel sesion1Label = new JLabel("Sesión 1: 12:00");
        //JLabel sesion2Label = new JLabel("Sesión 2: 15:00");
        //JLabel sesion3Label = new JLabel("Sesión 3: 18:00");

 
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(titleLabel, BorderLayout.NORTH);
        container.add(sesionesPanel, BorderLayout.CENTER);
        
        for(int i=0; i<filmLabels.size(); i++) {
        	sesionesPanel.add(filmLabels.get(i));
        }

    
        setVisible(true);
    }
    
    
}