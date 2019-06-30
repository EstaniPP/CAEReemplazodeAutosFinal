package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comportamental.Auto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormAgregarAuto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldDuracion;
	private JTextField textFieldInversion;

	FormAgregarAuto() {

		setTitle("Nuevo");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblAgregarNuevoAuto = new JLabel("Agregar nuevo auto");
		lblAgregarNuevoAuto.setBounds(12, 13, 136, 16);
		contentPane.add(lblAgregarNuevoAuto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 31, 286, 2);
		contentPane.add(separator);
		
		JLabel lblNombreDelAuto = new JLabel("Nombre del auto:");
		lblNombreDelAuto.setBounds(12, 48, 136, 16);
		contentPane.add(lblNombreDelAuto);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(182, 45, 106, 22);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Duracion:");
		lblNewLabel.setBounds(12, 77, 113, 16);
		contentPane.add(lblNewLabel);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(182, 75, 106, 22);
		contentPane.add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblInversionInicial = new JLabel("Inversion inicial:");
		lblInversionInicial.setBounds(12, 106, 113, 16);
		contentPane.add(lblInversionInicial);
		
		textFieldInversion = new JTextField();
		textFieldInversion.setBounds(182, 104, 106, 22);
		contentPane.add(textFieldInversion);
		textFieldInversion.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(10, 158, 97, 25);
		contentPane.add(btnCancelar);
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!esInteger(textFieldDuracion.getText())) {
					JOptionPane.showMessageDialog(null, "La duracion debe ser un nuemero entero.");
				}else if(!esFloat(textFieldInversion.getText())) {
					JOptionPane.showMessageDialog(null, "La inversion debe ser un numero real."
							+ "\n Consejo: Debe utilizar punto para separar la parte entera de la fraccionaria.");
				}else {
					String nombre=textFieldNombre.getText();
					if(nombre.isEmpty()) {
						nombre="Auto sin nombre";
					}
					MainWindow main = MainWindow.getMain();
					if(main.existeAuto(nombre)) {
						JOptionPane.showMessageDialog(null, "Ya existe un auto con ese nombre.");
					}else {
						main.agregarAuto(nombre,Float.parseFloat(textFieldInversion.getText()) ,Integer.parseInt(textFieldDuracion.getText()));
						main.actualizarTabla();
						dispose();
					}
				}
			}
		});
		btnAgregar.setBounds(191, 158, 97, 25);
		contentPane.add(btnAgregar);
	}
	private static boolean esInteger(String str){
		try {
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
	}
	
	private static boolean esFloat(String str){
		try {
			Float.parseFloat(str);
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
	}
	
	
}
