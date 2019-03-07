package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comportamental.Auto;
import comportamental.CAE;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class FormCAE extends JFrame {

	private JPanel contentPane;

	public FormCAE(HashMap<String,Auto> autos) {

		setTitle("Resultados de CAE.");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		JLabel lblCaeDeCada = new JLabel("CAE de cada auto:");
		lblCaeDeCada.setBounds(12, 13, 123, 16);
		contentPane.add(lblCaeDeCada);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(503, 334, 97, 25);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 86, 588, 235);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 42, 588, 38);
		contentPane.add(textPane);
		String mejorauto = CAE.mejorAuto(autos);
		textPane.setText(mejorauto);
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 30, 588, 7);
		contentPane.add(separator);
		
		for(String key : autos.keySet()){
			Auto aux = autos.get(key);
			for(int i=0;i<aux.getDuracion();i++) {
				textArea.append("El costo anual equivalente del auto "+key+" en el año "+new Integer(i)+" es de $"+CAE.CAEAuto(aux,i)+".\n");		
			}
			textArea.append("\n");
		}
	}
}
