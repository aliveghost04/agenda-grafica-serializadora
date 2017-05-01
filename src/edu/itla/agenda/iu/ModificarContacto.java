package edu.itla.agenda.iu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ModificarContacto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private static ModificarContacto instancia;
	
	public static ModificarContacto getInstancia() {
		
		if (instancia == null) {
			instancia = new ModificarContacto();
		}
		return instancia;
	}
	
	private ModificarContacto() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 270, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 37, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 75, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 115, 52, 14);
		contentPane.add(lblTelfono);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 34, 118, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(66, 72, 118, 20);
		contentPane.add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(66, 112, 118, 20);
		contentPane.add(txtTelefono);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(95, 155, 89, 23);
		contentPane.add(btnGuardar);
	}
}
