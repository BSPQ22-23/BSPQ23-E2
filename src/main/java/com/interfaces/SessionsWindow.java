package com.interfaces;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class SessionsWindow extends JFrame {
	
    public SessionsWindow(String movieName) {
        // Configurar la ventana
        setTitle(movieName);
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Crear los componentes
        JLabel titleLabel = new JLabel(movieName);
        JPanel sesionesPanel = new JPanel(new GridLayout(0, 1));
        JLabel sesion1Label = new JLabel("Sesión 1: 12:00");
        JLabel sesion2Label = new JLabel("Sesión 2: 15:00");
        JLabel sesion3Label = new JLabel("Sesión 3: 18:00");

        // Agregar los componentes a la ventana
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(titleLabel, BorderLayout.NORTH);
        container.add(sesionesPanel, BorderLayout.CENTER);
        sesionesPanel.add(sesion1Label);
        sesionesPanel.add(sesion2Label);
        sesionesPanel.add(sesion3Label);

        // Mostrar la ventana
        setVisible(true);
    }
}