package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bitmapmemorymanagement.BitMap;
import bitmapmemorymanagement.Description;
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
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Canvas;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NameProcessField;
	private BitMap map = new BitMap();
	public Theme theme = new Theme();
	public Description indexNumbers = new Description("", "", "");

	/**
	 * Create the frame.
	 */
	public MainView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1370, 628);

		contentPane = new JPanel();
		contentPane.setBackground(theme.GetBackgroundColor());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Memory canvas = new Memory(120, 1938, 8, 128);
		canvas.setForeground(new Color(0, 0, 0));
		canvas.setBackground(new Color(119, 118, 123));
		canvas.setBounds(10, 99, 1280, 80);
		contentPane.add(canvas);

		JButton btnDeleteProcess = new JButton("Eliminar Proceso");
		btnDeleteProcess.setFont(new Font("Dialog", Font.PLAIN, 16));

		btnDeleteProcess.setBounds(1136, 532, 172, 27);
		contentPane.add(btnDeleteProcess);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 16));

		comboBox.setBounds(1136, 498, 172, 26);
		contentPane.add(comboBox);

		JButton btnCreateProcess = new JButton("Crear Proceso");
		btnCreateProcess.setFont(new Font("Dialog", Font.PLAIN, 16));

		btnCreateProcess.setBounds(1136, 459, 172, 27);
		contentPane.add(btnCreateProcess);

		NameProcessField = new JTextField();
		NameProcessField.setFont(new Font("Dialog", Font.PLAIN, 14));
		NameProcessField.setBounds(1174, 369, 134, 21);
		contentPane.add(NameProcessField);
		NameProcessField.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 2000, 1));
		spinner.setBounds(1240, 419, 68, 22);
		contentPane.add(spinner);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNombre.setForeground(theme.GetLettersColor());
		lblNombre.setBounds(1081, 371, 60, 17);
		contentPane.add(lblNombre);

		JLabel lblTamao = new JLabel("Tamaño");
		lblTamao.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTamao.setForeground(theme.GetLettersColor());
		lblTamao.setBounds(1081, 421, 60, 17);
		contentPane.add(lblTamao);
		
		JLabel lblHundreds = new JLabel("");
		lblHundreds.setVerticalAlignment(SwingConstants.TOP);
		lblHundreds.setHorizontalAlignment(SwingConstants.LEFT);
		lblHundreds.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblHundreds.setForeground(theme.GetLettersColor());
		lblHundreds.setBounds(10, 191, 1330, 21);
		contentPane.add(lblHundreds);
		lblHundreds.setText(map.stringDecimalNumbers(0));
		
		JLabel lblTens = new JLabel("");
				lblTens.setVerticalAlignment(SwingConstants.TOP);
		lblTens.setHorizontalAlignment(SwingConstants.LEFT);
		lblTens.setForeground(theme.GetLettersColor());
		lblTens.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTens.setBounds(10, 207, 1330, 21);
		contentPane.add(lblTens);
		lblTens.setText(map.stringDecimalNumbers(1));
		
		JLabel lblUnits = new JLabel("");
				lblUnits.setVerticalAlignment(SwingConstants.TOP);
		lblUnits.setHorizontalAlignment(SwingConstants.LEFT);
		lblUnits.setForeground(theme.GetLettersColor());
		lblUnits.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUnits.setBounds(10, 224, 1330, 21);
		contentPane.add(lblUnits);
		lblUnits.setText(map.stringDecimalNumbers(2));
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setIcon(new ImageIcon(MainView.class.getResource("/img/info.png")));
		lblInfo.setBounds(14, 534, 35, 38);
		contentPane.add(lblInfo);
		
		JLabel lblSettings = new JLabel("");
		lblSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Settings settingsView = new Settings();
				settingsView.setVisible(true);
			}
		});
		lblInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Info info = new Info();
				info.setVisible(true);
			}
		});
		lblSettings.setIcon(new ImageIcon(MainView.class.getResource("/img/settings.png")));
		lblSettings.setBounds(49, 534, 46, 38);
		contentPane.add(lblSettings);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainView.class.getResource("/img/blinkRed.gif")));
		lblNewLabel.setBounds(12, 369, 23, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainView.class.getResource("/img/blinkYellow.gif")));
		lblNewLabel_1.setBounds(12, 395, 23, 17);
		contentPane.add(lblNewLabel_1);
		
		Canvas canvasGren = new Canvas();
		canvasGren.setBackground(Color.GREEN);
		canvasGren.setBounds(12, 442, 23, 21);
		contentPane.add(canvasGren);
		
		Canvas canvasOrange = new Canvas();
		canvasOrange.setBackground(Color.ORANGE);
		canvasOrange.setBounds(12, 469, 23, 21);
		contentPane.add(canvasOrange);
		
		Canvas canvasBakMap = new Canvas();
		canvasBakMap.setBackground(theme.GetBackgroundMap());
		canvasBakMap.setBounds(13, 499, 21, 19);
		contentPane.add(canvasBakMap);
		
		Canvas canvasFondo = new Canvas();
		canvasFondo.setBackground(Color.BLACK);
		canvasFondo.setBounds(12, 498, 23, 21);
		contentPane.add(canvasFondo);
		
		JLabel lblNewLabel_2 = new JLabel("Datos de entrada invalidos, el nombre no puede estar vacio");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(47, 369, 450, 17);
		lblNewLabel_2.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("No hay sufuciente espacio para ingresar ese proceso");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(47, 397, 464, 17);
		lblNewLabel_3.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Espacio ocupado");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(47, 446, 281, 17);
		lblNewLabel_4.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Buscando espacio libre");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(47, 469, 180, 17);
		lblNewLabel_5.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Espacio libre");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(47, 505, 231, 17);
		lblNewLabel_6.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_6);
		
		Canvas canvasRed = new Canvas();
		canvasRed.setBackground(Color.RED);
		canvasRed.setBounds(12, 418, 23, 21);
		contentPane.add(canvasRed);
		
		JLabel lblNewLabel_7 = new JLabel("Eliminando espacio");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(47, 422, 219, 17);
		lblNewLabel_7.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_7);
		
		JTextArea txtVerbose = new JTextArea();
		txtVerbose.setBackground(theme.GetBackgroundMap());
		txtVerbose.setForeground(theme.GetLettersColor());
        txtVerbose.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(txtVerbose);
		scrollPane.setBounds(488, 369, 538, 191);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblIndexNumbars = new JLabel(indexNumbers.GetTeens());
		lblIndexNumbars.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblIndexNumbars.setBounds(110, 63, 1198, 17);
		lblIndexNumbars.setForeground(theme.GetLettersColor());

		contentPane.add(lblIndexNumbars);
		
		JLabel lblIndexHundreds = new JLabel(indexNumbers.GetHundreds());
		lblIndexHundreds.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblIndexHundreds.setBounds(1009, 51, 287, 17);
		lblIndexHundreds.setForeground(theme.GetLettersColor());

		contentPane.add(lblIndexHundreds);
		
		JLabel lblIndexUnits = new JLabel(indexNumbers.GetUnits());
		lblIndexUnits.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblIndexUnits.setBounds(10, 76, 1280, 17);
		lblIndexUnits.setForeground(theme.GetLettersColor());
		
				contentPane.add(lblIndexUnits);
		
		JLabel Indice = new JLabel("Indice");
		Indice.setBounds(14, 47, 60, 17);
		Indice.setForeground(theme.GetLettersColor());

		contentPane.add(Indice);
		
		JLabel lbValorDecimal = new JLabel("Valor Decimal");
		lbValorDecimal.setBounds(10, 240, 102, 17);
		lbValorDecimal.setForeground(theme.GetLettersColor());
		contentPane.add(lbValorDecimal);
		
		JLabel lblNewLabel_8 = new JLabel("0");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNewLabel_8.setBounds(1296, 97, 11, 13);
		lblNewLabel_8.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("1");
		lblNewLabel_8_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNewLabel_8_1.setBounds(1296, 108, 11, 13);
		lblNewLabel_8_1.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("3");
		lblNewLabel_8_1_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNewLabel_8_1_1.setBounds(1296, 128, 11, 13);
		lblNewLabel_8_1_1.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_8_1_1);
		
		JLabel lblNewLabel_8_1_2 = new JLabel("7");
		lblNewLabel_8_1_2.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNewLabel_8_1_2.setBounds(1296, 167, 11, 13);
		lblNewLabel_8_1_2.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_8_1_2);
		
		JLabel lblNewLabel_8_1_3 = new JLabel("6");
		lblNewLabel_8_1_3.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNewLabel_8_1_3.setBounds(1296, 157, 11, 13);
		lblNewLabel_8_1_3.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_8_1_3);
		
		JLabel lblNewLabel_8_1_4 = new JLabel("5");
		lblNewLabel_8_1_4.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNewLabel_8_1_4.setBounds(1296, 147, 11, 13);
		lblNewLabel_8_1_4.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_8_1_4);
		
		JLabel lblNewLabel_8_1_5 = new JLabel("4");
		lblNewLabel_8_1_5.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNewLabel_8_1_5.setBounds(1296, 136, 11, 13);
		lblNewLabel_8_1_5.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_8_1_5);
		
		JLabel lblNewLabel_8_1_6 = new JLabel("2");
		lblNewLabel_8_1_6.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNewLabel_8_1_6.setBounds(1296, 118, 11, 13);
		lblNewLabel_8_1_6.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_8_1_6);
		
		JLabel lblNewLabel_9 = new JLabel("Posicion");
		lblNewLabel_9.setBounds(1306, 125, 60, 17);
		lblNewLabel_9.setForeground(theme.GetLettersColor());
		contentPane.add(lblNewLabel_9);
		
		btnCreateProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (NameProcessField.getText().equals("") || Integer.parseInt(spinner.getValue().toString()) == 0) {
					System.out.println("incorrect values || blink");
					canvas.SetOption(1);
				} else {
					/*Message*/
					map.verbose.ClearVerbose();
					txtVerbose.selectAll();
					txtVerbose.replaceSelection("");
					int aux;
					canvas.SetOption(3);
					canvas.size_Process = spinner.getValue().toString();
					int[] checkHole = map.LookForHole(Integer.parseInt(canvas.size_Process),0);
					if (checkHole[0] == -1) {
						canvas.SetOption(2);
					} else {
						canvas.SetAuxList(map.listProcess.processList);
						canvas.begin_Process = map.DispatchProcess(Integer.parseInt(spinner.getValue().toString()),
								NameProcessField.getText());
						aux = canvas.begin_Process[0];
						canvas.begin_Process[0] = canvas.begin_Process[1];
						canvas.begin_Process[1] = aux;
						canvas.SetList(map.listProcess.processList);
						canvas.repaint();
						comboBox.addItem(NameProcessField.getText());
					}
				}
				canvas.repaint();
				lblHundreds.setText(map.stringDecimalNumbers(0));
				lblTens.setText(map.stringDecimalNumbers(1));
				lblUnits.setText(map.stringDecimalNumbers(2));
				txtVerbose.setText(map.verbose.GetVerbose());
			}
		});

		btnDeleteProcess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Message*/
				map.verbose.ClearVerbose();
				txtVerbose.selectAll();
				txtVerbose.replaceSelection("");
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
				
				txtVerbose.setText(map.verbose.GetVerbose());

			}
		});

	}
}
