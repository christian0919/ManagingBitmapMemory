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

public class Bitwise extends JFrame {
	private static final long serialVersionUID = 1L;
	public Theme theme = new Theme();
	JPanel contentPane = new JPanel();

	public Bitwise() {
		setResizable(false);
		setBounds(100, 100, 874, 613);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBackground(theme.GetBackgroundColor());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.setBounds(369, 534, 105, 27);
		contentPane.add(btnNewButton);
		
		JTextPane textoPane = new JTextPane();
		textoPane.setText("La operación AND bitwise toma dos números y compara cada bit en la misma posición. Si ambos bits son 1, el resultado será 1; de lo contrario, será 0.\n"
				+ "\n"
				+ "Ejemplo:\n"
				+ "                                                    25 (11001)\n"
				+ "                                                          & \n"
				+ "                                                    18 (10010)\n"
				+ "                                                          = \n"
				+ "                                                    16 (10000)\n");
		textoPane.setEditable(false);
		textoPane.setBounds(12, 12, 842, 142);
		contentPane.add(textoPane);
		textoPane.setBackground(theme.GetBackgroundColor());
		textoPane.setForeground(theme.GetLettersColor());
		
		JTextPane textoPane_1 = new JTextPane();
		textoPane_1.setText("La operación OR bitwise compara cada bit en la misma posición. Si al menos uno de los bits es 1, el resultado será 1; si ambos bits son 0, el resultado será 0.\n"
				+ "\n"
				+ "Ejemplo:25\n "
				+ "                                                    (11001)\n"
				+ "                                                          | \n"
				+ "                                                    18 (10010)\n"
				+ "                                                          = \n"
				+ "                                                    27 (11011)");
		textoPane_1.setForeground(Color.BLACK);
		textoPane_1.setEditable(false);
		textoPane_1.setBackground(Color.WHITE);
		textoPane_1.setBounds(12, 162, 842, 159);
		contentPane.add(textoPane_1);
		
		JTextPane textoPane_1_1 = new JTextPane();
		textoPane_1_1.setText("La operación XOR bitwise compara cada bit en la misma posición. Si los bits son diferentes (uno es 0 y el otro es 1), el resultado será 1; si son iguales, el resultado será 0.\n"
				+ "\n"
				+ "Ejemplo:\n"
				+ "                                                    25 (11001)\n"
				+ "                                                          ^ \n"
				+ "                                                    18 (10010)\n"
				+ "                                                          = \n"
				+ "                                                    11 (01011)");
		textoPane_1_1.setForeground(Color.BLACK);
		textoPane_1_1.setEditable(false);
		textoPane_1_1.setBackground(Color.WHITE);
		textoPane_1_1.setBounds(12, 333, 842, 159);
		contentPane.add(textoPane_1_1);

		btnNewButton.addActionListener(e ->{ 
			dispose();
		});		
	}
}
