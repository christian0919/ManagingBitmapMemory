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

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField NameProcessField;

	
	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 714);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(61, 56, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnDeleteProcess.setBounds(431, 266, 134, 27);
		contentPane.add(btnDeleteProcess);
		
		JSlider sliderSpeed = new JSlider();
		sliderSpeed.setBackground(new Color(61, 56, 70));
		sliderSpeed.setForeground(new Color(61, 56, 70));
		sliderSpeed.setValue(1);
		sliderSpeed.setMaximum(10);
		sliderSpeed.setMinimum(1);
		sliderSpeed.setBounds(431, 348, 134, 16);
		contentPane.add(sliderSpeed);
		
		JComboBox comboBox = new JComboBox();

		comboBox.setBounds(431, 232, 134, 26);
		contentPane.add(comboBox);
		
		Canvas canvas = new Canvas();
		canvas.setForeground(new Color(94, 92, 100));
		canvas.setBackground(new Color(119, 118, 123));
		canvas.setBounds(30, 26, 287, 501);
		contentPane.add(canvas);
		
		JButton btnCreateProcess = new JButton("Crear Proceso");
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
		btnCreateProcess.setBounds(431, 193, 134, 27);
		contentPane.add(btnCreateProcess);
		
		NameProcessField = new JTextField();
		NameProcessField.setBounds(431, 103, 134, 21);
		contentPane.add(NameProcessField);
		NameProcessField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(526, 153, 39, 22);
		contentPane.add(spinner);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(119, 118, 123));
		lblNombre.setBounds(338, 105, 60, 17);
		contentPane.add(lblNombre);
		
		JLabel lblTamao = new JLabel("Tamaño");
		lblTamao.setForeground(new Color(119, 118, 123));
		lblTamao.setBounds(338, 155, 60, 17);
		contentPane.add(lblTamao);
		
		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setForeground(new Color(119, 118, 123));
		lblVelocidad.setBounds(338, 347, 60, 17);
		contentPane.add(lblVelocidad);
	}
}
