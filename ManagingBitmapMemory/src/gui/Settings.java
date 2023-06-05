package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bitmapmemorymanagement.Theme;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Settings extends JFrame {
	private JPanel contentPane;
	public Theme theme = new Theme();

	public Settings() {
		setResizable(false);
		setBounds(100, 100, 320, 242);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(theme.GetBackgroundColor());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		
		
		btnGuardar.setBounds(109, 121, 105, 27);
		contentPane.add(btnGuardar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox.setBounds(109, 59, 105, 26);
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Escoga el numero de tema que desea\n");
		lblNewLabel.setForeground(theme.GetLettersColor());
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 0, 265, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\nNota: despues de guardar cierre y abra la aplicación");
		lblNewLabel_1.setForeground(theme.GetLettersColor());
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 164, 298, 17);
		contentPane.add(lblNewLabel_1);
		btnGuardar.addActionListener(e ->{ 
			theme.SetConfig(Integer.parseInt(comboBox.getSelectedItem().toString()));
			dispose();});
	}
}
