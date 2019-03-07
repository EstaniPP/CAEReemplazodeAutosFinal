package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comportamental.Auto;
import comportamental.CAE;

import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private HashMap<String,Auto> autos = new HashMap<String,Auto>();
	private static MainWindow main;
	JComboBox<String> comboBox = new JComboBox<String>();
	JScrollPane panel = new JScrollPane();
	JComboBox<String> comboBox_1 = new JComboBox<String>();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private MainWindow() {
		setTitle("CAE para reemplazo de automoviles.");
		main=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		panel.setBounds(12, 155, 942, 378);
		contentPane.add(panel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 98, 942, 2);
		contentPane.add(separator);
		
		JLabel lblAutomoviles = new JLabel("Automoviles:");
		lblAutomoviles.setBounds(12, 77, 89, 16);
		contentPane.add(lblAutomoviles);
		
		JLabel lblCae = new JLabel("CAE:");
		lblCae.setBounds(12, 13, 56, 16);
		contentPane.add(lblCae);
		
		JLabel lblTasaDeInteres = new JLabel("Tasa de interes:");
		lblTasaDeInteres.setBounds(12, 48, 100, 16);
		contentPane.add(lblTasaDeInteres);
		
		textField = new JTextField();
		textField.setBounds(108, 45, 109, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		this.actualizarTabla();
		
		JButton btnCambiarTasa = new JButton("Cambiar tasa");
		btnCambiarTasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!esFloat(textField.getText())) {
					JOptionPane.showMessageDialog(null, "La tasa debe ser un numero real."
							+ "\n Consejo: Debe utilizar punto para separar la parte entera de la fraccionaria.");
				}else {
					if(comboBox_1.getSelectedIndex()==0) {
						JOptionPane.showMessageDialog(null, "Debe seleccionar un año.");
					}else {
						CAE.interesCompuesto.set(comboBox_1.getSelectedIndex()-1, Float.parseFloat(textField.getText()));
						actualizarTasas();
					}
				}
			}
		});
		btnCambiarTasa.setBounds(422, 44, 116, 25);
		contentPane.add(btnCambiarTasa);
		
		JButton btnAgregarAutomovil = new JButton("Agregar automovil");
		btnAgregarAutomovil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormAgregarAuto formAA = new FormAgregarAuto();
				formAA.setVisible(true);
			}
		});
		btnAgregarAutomovil.setBounds(12, 117, 154, 25);
		contentPane.add(btnAgregarAutomovil);
		
		JButton btnCalcularCae = new JButton("Calcular CAE");
		btnCalcularCae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean tasascorrectas = true;
				for(int i=0;i<CAE.interesCompuesto.size();i++) {
					if(CAE.interesCompuesto.get(i)<0.0f) {
						tasascorrectas = false;
					}
				}
				if(tasascorrectas == true) {
					FormCAE formCAE = new FormCAE(autos);
					formCAE.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Todos los años deben tener una tasa mayor o igual a 0.");
				}

			}
		});
		btnCalcularCae.setBounds(845, 546, 109, 25);
		contentPane.add(btnCalcularCae);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 30, 942, 2);
		contentPane.add(separator_1);
		
		JButton btnEliminarAuto = new JButton("Eliminar auto");
		btnEliminarAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedIndex()!=0) {
						int opcion = JOptionPane.showConfirmDialog(null,"Esta seguro que desea eliminar:"+ comboBox.getSelectedItem() +"?","Eliminar auto",JOptionPane.YES_NO_OPTION);
						if(opcion==JOptionPane.YES_OPTION) {
							autos.remove(comboBox.getSelectedItem());
							comboBox.remove(comboBox.getSelectedIndex());
							comboBox.setSelectedIndex(0);
					}else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar un auto.");
					}
					MainWindow.this.actualizarTabla();
				}else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un auto.");
				}
				MainWindow.this.actualizarTabla();
			}
		});
		btnEliminarAuto.setBounds(845, 117, 109, 25);
		contentPane.add(btnEliminarAuto);
		
		JButton btnAgregarCosto = new JButton("Agregar costo");
		btnAgregarCosto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Seleecione un auto")) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un auto.");
				}else {
					FormAgregarCosto formAC = new FormAgregarCosto(autos.get(comboBox.getSelectedItem()));
					formAC.setVisible(true);
				}
			}
		});
		btnAgregarCosto.setBounds(539, 117, 137, 25);
		contentPane.add(btnAgregarCosto);
		
		JButton btnAgregarReventa = new JButton("Agregar $ reventa");
		btnAgregarReventa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().equals("Seleecione un auto")) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un auto.");
				}else {
					FormAgregarPrecioReventa formAPR = new FormAgregarPrecioReventa(autos.get(comboBox.getSelectedItem()));
					formAPR.setVisible(true);
				}
			}
		});
		btnAgregarReventa.setBounds(688, 117, 145, 25);
		contentPane.add(btnAgregarReventa);

		comboBox.setBounds(335, 120, 192, 22);
		contentPane.add(comboBox);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(227, 49, 36, 14);
		contentPane.add(lblAo);
		
		comboBox_1.setBounds(258, 46, 154, 20);
		contentPane.add(comboBox_1);
		
		JCheckBox chckbxFinPeriodo = new JCheckBox("Fin del periodo");
		chckbxFinPeriodo.setBounds(838, 44, 116, 25);
		contentPane.add(chckbxFinPeriodo);
		
		JCheckBox chckbxPrincipioPeriodo = new JCheckBox("Principio del periodo");
		chckbxPrincipioPeriodo.setBounds(688, 44, 145, 25);
		
		chckbxPrincipioPeriodo.setSelected(true);
		chckbxFinPeriodo.setSelected(false);
		CAE.comienzo = true;
		
		chckbxPrincipioPeriodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					chckbxPrincipioPeriodo.setSelected(true);
					chckbxFinPeriodo.setSelected(false);
					CAE.comienzo = true;
					actualizarTasas();
			}
		});
		chckbxFinPeriodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					chckbxPrincipioPeriodo.setSelected(false);
					chckbxFinPeriodo.setSelected(true);
					CAE.comienzo = false;
					actualizarTasas();
			}
		});
		

		contentPane.add(chckbxPrincipioPeriodo);
		
		JLabel lblReemplazoAl = new JLabel("Realizar reemplazo al:");
		lblReemplazoAl.setBounds(550, 48, 145, 16);
		contentPane.add(lblReemplazoAl);
		comboBox.addItem("Seleccione un auto");
		comboBox_1.addItem("Seleccione un año");

	}
	
	public void agregarAuto(String str, Float invini, Integer duracion) {
		Auto autonuevo = new Auto(str,invini,duracion);
		autos.put(autonuevo.getNombreAuto(),autonuevo);
		comboBox.addItem(str);
	}
	
	public void actualizarTabla() {
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		for(String key : autos.keySet()) {
			Auto aux = autos.get(key);
			
			JPanel panel_2 = new JPanel();
			panel_2.setPreferredSize(new Dimension(922, aux.getDuracion()*22+56));
			panel_2.setLayout(null);
			c.gridwidth = 1;
			c.gridheight = 1;
			c.gridx = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			panel_2.setBorder(BorderFactory.createEtchedBorder());
			JLabel lblNombre = new JLabel("Auto: "+key);
			lblNombre.setBounds(12, 14, 114, 15);
			panel_2.add(lblNombre);
			
			JLabel lblInversion = new JLabel("Inversion inicial: "+aux.getInversionInicial()+".");
			lblInversion.setBounds(402, 14, 390, 15);
			panel_2.add(lblInversion);
			
			for(int i=0; i<aux.getDuracion();i++) {
				int costototal = 0;
				for(int j=0;j<aux.getCostos(i).size();j++) {
					costototal+=aux.getCostos(i).get(j);
				}
				JLabel lblMontoAnual = new JLabel("Costos totales del año "+i+": "+costototal+".");
				lblMontoAnual.setBounds(12, 56+21*i, 390, 15);
				panel_2.add(lblMontoAnual);
				
				JLabel lblPrecioReventa = new JLabel("El precio de reventa para el año "+i+" es de: "+aux.getPrecioReventa(i)+".");
				lblPrecioReventa.setBounds(402, 56+21*i, 390, 15);
				panel_2.add(lblPrecioReventa);
				
			}
			
			panel_1.add(panel_2,c);
			if(aux.getDuracion()> CAE.interesCompuesto.size()) {
				for(int i=CAE.interesCompuesto.size();i<aux.getDuracion();i++) {
					CAE.interesCompuesto.add(-1.0f);
					actualizarTasas();
				}
			}
		}
		panel.setViewportView(panel_1);
	}
	public boolean existeAuto(String str) {
		return autos.containsKey(str);
	}
	
	public static MainWindow getMain() {
		return main;
	}
	
	private static boolean esFloat(String str){
		try {
			Float.parseFloat(str);
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
	}
	
	private void actualizarTasas() {
		comboBox_1.removeAllItems();
		comboBox_1.addItem("Seleccione un año");
		for(int i=0; i<CAE.interesCompuesto.size();i++) {
			if(CAE.comienzo == true) {
				comboBox_1.addItem("Año "+i+" tasa "+CAE.interesCompuesto.get(i));
			}else {
				comboBox_1.addItem("Año "+new Integer(i+1)+" tasa "+CAE.interesCompuesto.get(i));
			}
		}
	}
}
