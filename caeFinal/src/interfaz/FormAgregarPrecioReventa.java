package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comportamental.Auto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormAgregarPrecioReventa extends JFrame {

	private JPanel contentPane;
	private JTextField txtMonto;


	/**
	 * Create the frame.
	 */
	public FormAgregarPrecioReventa(Auto auto) {

		setTitle("CAE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblAgregarCosto = new JLabel("Agregar $ reventa a "+auto.getNombreAuto());
		lblAgregarCosto.setBounds(12, 13, 217, 16);
		contentPane.add(lblAgregarCosto);
		
		JLabel lblAno = new JLabel("A\u00F1o:");
		lblAno.setBounds(12, 61, 89, 16);
		contentPane.add(lblAno);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(12, 90, 89, 16);
		contentPane.add(lblMonto);
		
		JComboBox<Integer> comboBoxAno = new JComboBox<Integer>();
		comboBoxAno.setBounds(142, 58, 116, 22);
		contentPane.add(comboBoxAno);
		for(int i=0;i<auto.getDuracion();i++) {
			comboBoxAno.addItem(i);
		}
		
		txtMonto = new JTextField();
		txtMonto.setBounds(142, 88, 116, 22);
		contentPane.add(txtMonto);
		txtMonto.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!esFloat(txtMonto.getText())) {
					JOptionPane.showMessageDialog(null, "El precio de reventa debe ser un numero real."
							+ "\n Consejo: Debe utilizar punto para separar la parte entera de la fraccionaria.");
				}else {
					auto.setPrecioReventa((Integer)comboBoxAno.getSelectedItem(), Float.parseFloat(txtMonto.getText()));
					MainWindow main = MainWindow.getMain();
					main.actualizarTabla();
				}
			}
		});
		btnAgregar.setBounds(161, 193, 97, 25);
		contentPane.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(12, 193, 97, 25);
		contentPane.add(btnCancelar);
		
		JLabel lblAclaracionElPrecio = new JLabel("Aclaracion: el precio de reventa es ");
		lblAclaracionElPrecio.setBounds(12, 119, 256, 16);
		contentPane.add(lblAclaracionElPrecio);
		
		JLabel lblUnicoPorLo = new JLabel("unico, por lo que el precio nuevo ");
		lblUnicoPorLo.setBounds(12, 136, 256, 16);
		contentPane.add(lblUnicoPorLo);
		
		JLabel lblSobreescribiraElAnterior = new JLabel("sobreescribira el anterior.");
		lblSobreescribiraElAnterior.setBounds(12, 153, 256, 16);
		contentPane.add(lblSobreescribiraElAnterior);
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
