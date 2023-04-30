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

class SessionsWindow extends JFrame {
	
	
    public SessionsWindow(String movieName, Film film) {
        // Configurar la ventana
        setTitle(movieName);
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        List<JLabel> filmLabels = new ArrayList<JLabel>();
        

        // Crear los componentes
        JLabel titleLabel = new JLabel(movieName);
        JPanel sesionesPanel = new JPanel(new GridLayout(0, 1));
        for(int i=0; i<film.getSessions().size(); i++) {
        	JLabel sessionLabel =  new JLabel(film.getSessions().get(i).toString());
        	filmLabels.add(sessionLabel);
        }
        //JLabel sesion1Label = new JLabel("Sesión 1: 12:00");
        //JLabel sesion2Label = new JLabel("Sesión 2: 15:00");
        //JLabel sesion3Label = new JLabel("Sesión 3: 18:00");

        // Agregar los componentes a la ventana
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(titleLabel, BorderLayout.NORTH);
        container.add(sesionesPanel, BorderLayout.CENTER);
        
        for(int i=0; i<filmLabels.size(); i++) {
        	sesionesPanel.add(filmLabels.get(i));
        }

        // Mostrar la ventana
        setVisible(true);
    }
    
    
}