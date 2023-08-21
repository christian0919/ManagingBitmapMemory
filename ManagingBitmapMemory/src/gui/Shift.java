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

public class Shift extends JFrame {
	private static final long serialVersionUID = 1L;
	public Theme theme = new Theme();
	JPanel contentPane = new JPanel();

	public Shift() {
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
		textoPane.setText("Esta operación desplaza los bits de un número a la izquierda en un número específico de posiciones. Cada desplazamiento duplica el valor. Por ejemplo, desplazar a la izquierda un bit duplica el valor.\n"
				+ "\n"
				+ "Ejemplo:\n "
				+ "                                int num = 5; // 00101\n"
				+ "                                int shift_left = num << 2; // 10100 (20)"
				);
		textoPane.setEditable(false);
		textoPane.setBounds(12, 12, 842, 142);
		contentPane.add(textoPane);
		textoPane.setBackground(theme.GetBackgroundColor());
		textoPane.setForeground(theme.GetLettersColor());
		
		JTextPane textoPane_1 = new JTextPane();
		textoPane_1.setText("Esta operación desplaza los bits de un número a la derecha en un número específico de posiciones. Cada desplazamiento reduce a la mitad el valor. Por ejemplo, desplazar a la derecha un bit divide el valor por 2.\n"
				+ "\n"
				+ "Ejemplo:\n"
				+ "                                int num2 = 20; // 10100\n"
				+ "                                int shift_right = num2 >> 2; // 00101 (5)");
		textoPane_1.setForeground(theme.GetLettersColor());
		textoPane_1.setEditable(false);
		textoPane_1.setBackground(theme.GetBackgroundColor());
		textoPane_1.setBounds(12, 162, 842, 159);
		contentPane.add(textoPane_1);

		btnNewButton.addActionListener(e ->{ 
			dispose();
		});		
	}
}
