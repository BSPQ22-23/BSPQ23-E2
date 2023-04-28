package com.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BillboardWindow extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] movieButtons;

    public BillboardWindow() {
        // Configurar la ventana
        setTitle("Cartelera");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear los componentes
        JLabel titleLabel = new JLabel("Cartelera");
        JPanel moviePanel = new JPanel(new GridLayout(0, 1));
        movieButtons = new JButton[5];
        movieButtons[0] = new JButton("Spider-Man: No Way Home");
        movieButtons[1] = new JButton("The Batman");
        movieButtons[2] = new JButton("Avatar 2");
        movieButtons[3] = new JButton("Jurassic World: Dominion");
        movieButtons[4] = new JButton("Sonic the Hedgehog 2");

        // Agregar los componentes a la ventana
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(titleLabel, BorderLayout.NORTH);
        container.add(moviePanel, BorderLayout.CENTER);
        for (int i = 0; i < movieButtons.length; i++) {
            moviePanel.add(movieButtons[i]);
            movieButtons[i].addActionListener(this);
        }

        // Mostrar la ventana
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < movieButtons.length; i++) {
            if (e.getSource() == movieButtons[i]) {
                String movieName = movieButtons[i].getText();
                new SesionesWindow(movieName);
                break;
            }
        }
    }

    public static void main(String[] args) {
        BillboardWindow window = new BillboardWindow();
    }
}
