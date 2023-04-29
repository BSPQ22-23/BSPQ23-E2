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
	private static BillboardWindow bw = new BillboardWindow();

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
        
        
        movieButtons = new JButton[5];
        movieButtons[0] = new JButton("Spider-Man: No Way Home");
        movieButtons[0].setIcon(spid);
        movieButtons[1] = new JButton("The Batman");
        movieButtons[1].setIcon(bat);
        movieButtons[2] = new JButton("Avatar 2");
        movieButtons[2].setIcon(ava);
        movieButtons[3] = new JButton("Jurassic World: Dominion");
        movieButtons[3].setIcon(jur);
        movieButtons[4] = new JButton("Sonic the Hedgehog 2");
        movieButtons[4].setIcon(son);

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
       	bw.setTitle("Billboard");
    	bw.setVisible(true);
    	bw.setLocation(550, 150);
		bw.setSize(400, 400);
		bw.setResizable(false);
		bw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
