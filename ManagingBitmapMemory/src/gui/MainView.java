package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bitmapmemorymanagement.BitMap;
import bitmapmemorymanagement.Theme;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Label;
import javax.swing.ImageIcon;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NameProcessField;
	private BitMap map = new BitMap();
	public Theme theme = new Theme();

	/**
	 * Create the frame.
	 */
	public MainView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1325, 455);

		contentPane = new JPanel();
		contentPane.setBackground(theme.GetBackgroundColor());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Memory canvas = new Memory(120, 1938, 8, 128);
		canvas.setForeground(new Color(0, 0, 0));
		canvas.setBackground(new Color(119, 118, 123));
		canvas.setBounds(10, 23, 1280, 80);
		contentPane.add(canvas);

		JButton btnDeleteProcess = new JButton("Eliminar Proceso");
		btnDeleteProcess.setFont(new Font("Dialog", Font.PLAIN, 16));

		btnDeleteProcess.setBounds(1118, 386, 172, 27);
		contentPane.add(btnDeleteProcess);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 16));

		comboBox.setBounds(1118, 352, 172, 26);
		contentPane.add(comboBox);

		JButton btnCreateProcess = new JButton("Crear Proceso");
		btnCreateProcess.setFont(new Font("Dialog", Font.PLAIN, 16));

		btnCreateProcess.setBounds(1118, 313, 172, 27);
		contentPane.add(btnCreateProcess);

		NameProcessField = new JTextField();
		NameProcessField.setFont(new Font("Dialog", Font.PLAIN, 14));
		NameProcessField.setBounds(1156, 223, 134, 21);
		contentPane.add(NameProcessField);
		NameProcessField.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 2000, 1));
		spinner.setBounds(1222, 273, 68, 22);
		contentPane.add(spinner);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNombre.setForeground(theme.GetLettersColor());
		lblNombre.setBounds(1063, 225, 60, 17);
		contentPane.add(lblNombre);

		JLabel lblTamao = new JLabel("Tamaño");
		lblTamao.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTamao.setForeground(theme.GetLettersColor());
		lblTamao.setBounds(1063, 275, 60, 17);
		contentPane.add(lblTamao);
		
		JLabel lblHundreds = new JLabel("");
		lblHundreds.setVerticalAlignment(SwingConstants.TOP);
		lblHundreds.setHorizontalAlignment(SwingConstants.LEFT);
		lblHundreds.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblHundreds.setForeground(new Color(255, 255, 255));
		lblHundreds.setBounds(10, 109, 1330, 21);
		contentPane.add(lblHundreds);
		lblHundreds.setText(map.stringDecimalNumbers(0));
		
		JLabel lblTens = new JLabel("");
				lblTens.setVerticalAlignment(SwingConstants.TOP);
		lblTens.setHorizontalAlignment(SwingConstants.LEFT);
		lblTens.setForeground(Color.WHITE);
		lblTens.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTens.setBounds(10, 125, 1330, 21);
		contentPane.add(lblTens);
		lblTens.setText(map.stringDecimalNumbers(1));
		
		JLabel lblUnits = new JLabel("");
				lblUnits.setVerticalAlignment(SwingConstants.TOP);
		lblUnits.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnits.setForeground(Color.WHITE);
		lblUnits.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUnits.setBounds(10, 142, 1330, 21);
		contentPane.add(lblUnits);
		lblUnits.setText(map.stringDecimalNumbers(2));
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setIcon(new ImageIcon(MainView.class.getResource("/img/info.png")));
		lblInfo.setBounds(10, 386, 35, 38);
		contentPane.add(lblInfo);
		
		JLabel lblSettings = new JLabel("");
		lblSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Settings settingsView = new Settings();
				settingsView.setVisible(true);
			}
		});
		lblSettings.setIcon(new ImageIcon(MainView.class.getResource("/img/settings.png")));
		lblSettings.setBounds(45, 386, 46, 38);
		contentPane.add(lblSettings);
		btnCreateProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (NameProcessField.getText().equals("") || Integer.parseInt(spinner.getValue().toString()) == 0) {
					System.out.println("incorrect values || blink");
					canvas.SetOption(1);
				} else {
					int aux;
					canvas.SetOption(3);
					canvas.size_Process = spinner.getValue().toString();
					int[] checkHole = map.LookForHole(Integer.parseInt(canvas.size_Process));
					if (checkHole[0] == -1) {
						canvas.SetOption(2);
					} else {
						canvas.begin_Process = map.DispatchProcess(Integer.parseInt(spinner.getValue().toString()),
								NameProcessField.getText());
						aux = canvas.begin_Process[0];
						canvas.begin_Process[0] = canvas.begin_Process[1];
						canvas.begin_Process[1] = aux;
						System.out.println("size: " + canvas.size_Process + " index: " + canvas.begin_Process[1]
								+ " position:" + canvas.begin_Process[0]);
						canvas.SetList(map.listProcess.processList);
						canvas.repaint();
						comboBox.addItem(NameProcessField.getText());
					}
				}
				canvas.repaint();
				lblHundreds.setText(map.stringDecimalNumbers(0));
				lblTens.setText(map.stringDecimalNumbers(1));
				lblUnits.setText(map.stringDecimalNumbers(2));

				
			}
		});

		btnDeleteProcess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String value = (String) comboBox.getSelectedItem();
				if (value == null || value.isEmpty()) {
					System.out.println("Error");
				} else {
					canvas.SetOption(4);
					int indexList;
					int aux;

					indexList = map.listProcess.ValidateProcessExist(value);
					canvas.size_Process = String.valueOf(map.listProcess.getProcessSize(indexList));
					canvas.begin_Process = map.listProcess.getProcessIndex(indexList);
					aux = canvas.begin_Process[0];
					canvas.begin_Process[0] = canvas.begin_Process[1];
					canvas.begin_Process[1] = aux;

					map.UndispatchProcess(value);
					comboBox.removeItemAt(comboBox.getSelectedIndex());
					canvas.SetList(map.listProcess.processList);
					canvas.repaint();
				}
				lblHundreds.setText(map.stringDecimalNumbers(0));
				lblTens.setText(map.stringDecimalNumbers(1));
				lblUnits.setText(map.stringDecimalNumbers(2));
			}
		});

	}
}
