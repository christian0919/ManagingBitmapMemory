package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Button;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Label;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField NameProcessField;

	
	/**
	 * Create the frame.
	 */
	public MainView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1305, 400);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(61, 56, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Memory canvas = new Memory(120, 1938, 8, 128);
		canvas.setForeground(new Color(0, 0, 0));
		canvas.setBackground(new Color(119, 118, 123));
		canvas.setBounds(10, 23, 1280, 80);
		contentPane.add(canvas);
		
		JButton btnDeleteProcess = new JButton("Eliminar Proceso");

		
		btnDeleteProcess.setBounds(1086, 272, 134, 27);
		contentPane.add(btnDeleteProcess);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("JetBrains Mono NL Light", Font.BOLD, 12));

		comboBox.setBounds(1086, 238, 134, 26);
		contentPane.add(comboBox);


		JButton btnCreateProcess = new JButton("Crear Proceso");
		
		btnCreateProcess.setBounds(1086, 199, 134, 27);
		contentPane.add(btnCreateProcess);
		
		NameProcessField = new JTextField();
		NameProcessField.setBounds(1086, 109, 134, 21);
		contentPane.add(NameProcessField);
		NameProcessField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 1024, 1));
		spinner.setBounds(1152, 159, 68, 22);
		contentPane.add(spinner);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(119, 118, 123));
		lblNombre.setBounds(993, 111, 60, 17);
		contentPane.add(lblNombre);
		
		JLabel lblTamao = new JLabel("Tamaño");
		lblTamao.setForeground(new Color(119, 118, 123));
		lblTamao.setBounds(993, 161, 60, 17);
		contentPane.add(lblTamao);
		btnDeleteProcess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//
				String value =(String)comboBox.getSelectedItem();
				System.out.println(value);
				int[] data = new int[3];
					
					canvas.map.UndispatchProcess("Angel");
					canvas.map.size_Process = String.valueOf(data[0]);
					canvas.map.begin_Process[0] = data[1];
					canvas.map.begin_Process[1] = data[2];
					canvas.SetOption(4);	
					canvas.map.listProcess.printProcessList();
					System.out.println(data[0]);
					System.out.println(data[1]);
					System.out.println(data[2]);
					canvas.SetOption(3);	
					canvas.repaint();
					canvas.map.PrintMap();
					
				
			}
		});
		
		btnCreateProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(NameProcessField.getText().equals("") || Integer.parseInt(spinner.getValue().toString())==0) {
					System.out.println("incorrect values || blink");
				}else {
					int aux;
					canvas.SetOption(3);
					canvas.map.SetName(NameProcessField.getText());
					
					canvas.map.size_Process = spinner.getValue().toString();
					canvas.map.begin_Process = canvas.map.DispatchProcess(Integer.parseInt(spinner.getValue().toString()),canvas.map.name_Process);
					aux = 	canvas.map.begin_Process[0];
					canvas.map.begin_Process[0] = canvas.map.begin_Process[1];
					canvas.map.begin_Process[1] = aux;
					System.out.println("size: "+ canvas.map.size_Process+" index: "+ canvas.map.begin_Process[1]+" position:"+canvas.map.begin_Process[0] );
					//canvas.map.PrintMap();
					//Draw all map pendiente
					canvas.repaint();
					comboBox.addItem(NameProcessField.getText());

				}
			}
		});


	}
}
