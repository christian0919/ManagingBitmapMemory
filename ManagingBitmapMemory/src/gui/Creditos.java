package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bitmapmemorymanagement.Theme;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Creditos extends JFrame {
	private static final long serialVersionUID = 1L;
	public Theme theme = new Theme();
	JPanel contentPane = new JPanel();

	public Creditos() {
		setResizable(false);
		setBounds(100, 100, 623, 379);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBackground(theme.GetBackgroundColor());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.setBounds(272, 310, 105, 27);
		contentPane.add(btnNewButton);
		
		JTextPane textoPane = new JTextPane();
		textoPane.setFont(new Font("Dialog", Font.PLAIN, 16));
		textoPane.setText("Programa [Simulador de despacho de memoria con mapa de bits]\n"
				+ "\n"
				+ "Desarrollado por: [Christian del Angel Lopez Cuellar]\n"
				+ "Versión: [1.1]\n"
				+ "Fecha de Creación: [julio 2023]\n"
				+ "Plataforma: [Java 11 en adelante]\n"
				+ "\n"
				+ "Descripción: [Este programa fue diseñado inicialmente para el programa \n"
				+ "                  haciendo ciencia en la Benemerita universidad Autonoa de Puebla]");
		textoPane.setEditable(false);
		textoPane.setBounds(12, 12, 591, 286);
		contentPane.add(textoPane);
		textoPane.setBackground(theme.GetBackgroundColor());
		textoPane.setForeground(theme.GetLettersColor());

		btnNewButton.addActionListener(e ->{ 
			dispose();
		});		
	}
}
