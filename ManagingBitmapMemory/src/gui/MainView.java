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
		btnDeleteProcess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Esta madre se va a encagar de Eliminar el proceso
				
				/*
				 * EliminarProceso(String Name, int begin, int end)
				 */
				
				
			}
		});
		btnDeleteProcess.setBounds(1086, 272, 134, 27);
		contentPane.add(btnDeleteProcess);
		
		
		JSlider sliderSpeed = new JSlider();
		sliderSpeed.setBackground(new Color(61, 56, 70));
		sliderSpeed.setForeground(new Color(61, 56, 70));
		sliderSpeed.setValue(1);
		sliderSpeed.setMaximum(10);
		sliderSpeed.setMinimum(1);
		sliderSpeed.setBounds(1086, 353, 134, 16);
		contentPane.add(sliderSpeed);
		
		JComboBox comboBox = new JComboBox();

		comboBox.setBounds(1086, 238, 134, 26);
		contentPane.add(comboBox);
		
		JButton btnCreateProcess = new JButton("Crear Proceso");
		btnCreateProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Aqui se hace la prueba de dibujo temporalmente
				 * */

				canvas.SetOption(2);

				canvas.repaint();

				
			}
		});
		btnCreateProcess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//Esta madre se va a encargar de despachar memoria
				/*
				 *  DespacharProceso( Name, size){

				 * 
				 * */
			}
		});
		btnCreateProcess.setBounds(1086, 199, 134, 27);
		contentPane.add(btnCreateProcess);
		
		NameProcessField = new JTextField();
		NameProcessField.setBounds(1086, 109, 134, 21);
		contentPane.add(NameProcessField);
		NameProcessField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Short.valueOf((short) 0), Short.valueOf((short) 0), Short.valueOf((short) 10), Short.valueOf((short) 1)));
		spinner.setBounds(1181, 159, 39, 22);
		contentPane.add(spinner);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(119, 118, 123));
		lblNombre.setBounds(993, 111, 60, 17);
		contentPane.add(lblNombre);
		
		JLabel lblTamao = new JLabel("Tamaño");
		lblTamao.setForeground(new Color(119, 118, 123));
		lblTamao.setBounds(993, 161, 60, 17);
		contentPane.add(lblTamao);
		
		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setForeground(new Color(119, 118, 123));
		lblVelocidad.setBounds(993, 353, 60, 17);
		contentPane.add(lblVelocidad);
		

	}
}
