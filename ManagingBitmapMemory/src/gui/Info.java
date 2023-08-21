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

public class Info extends JFrame {
	private static final long serialVersionUID = 1L;
	public Theme theme = new Theme();
	JPanel contentPane = new JPanel();

	public Info() {
		setResizable(false);
		setBounds(100, 100, 623, 379);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBackground(theme.GetBackgroundColor());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Memory canvas = new Memory(120, 1938, 8, 1);
		canvas.setForeground(new Color(0, 0, 0));
		canvas.setBackground(new Color(119, 118, 123));
		canvas.setBounds(235, 183, 10, 80);
		contentPane.add(canvas);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Dialog", Font.PLAIN, 10));
		textPane.setText("1\n1\n0\n0\n1\n0\n0\n1");
		textPane.setEditable(false);
		textPane.setBounds(318, 166, 16, 113);
		textPane.setBackground(theme.GetBackgroundColor());
		textPane.setForeground(theme.GetLettersColor());

		contentPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel.setBounds(272, 215, 16, 17);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(theme.GetLettersColor());
		JLabel lblNewLabel_1 = new JLabel("=");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(352, 215, 16, 17);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(theme.GetLettersColor());
		
		JLabel lblNewLabel_1_1 = new JLabel("201");
		lblNewLabel_1_1.setForeground((Color) null);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(398, 218, 33, 17);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(theme.GetLettersColor());
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.setBounds(272, 310, 105, 27);
		contentPane.add(btnNewButton);
		
		JTextPane textoPane = new JTextPane();
		textoPane.setText("Cada columna del mapa de bits representa un caracter del arreglo que utilizamos para representar el mapa de bits. Al tener 8 bits cada caracter, cada columna del mapa tendra 8 cuadritos.\n\nA continuacion podemos observar un ejemplo donde la siguiente columna tendra 4 cuadritos apagados y su representacion binaria leyendo de arriba hacia abajo, al estar trabajando con caracteres tenemos que utilizar su forma binaria, y finalmente podemos apreciar su forma decimal asociada a la forma binaria");
		textoPane.setEditable(false);
		textoPane.setBounds(12, 12, 589, 142);
		contentPane.add(textoPane);
		textoPane.setBackground(theme.GetBackgroundColor());
		textoPane.setForeground(theme.GetLettersColor());
		canvas.SetOption(5);
		canvas.repaint();

		btnNewButton.addActionListener(e ->{ 
			Bitwise bitwise = new Bitwise();
			bitwise.setVisible(true);
			dispose();
		});		
	}
}
