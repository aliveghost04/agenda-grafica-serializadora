package edu.itla.agenda.iu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.itla.agenda.modelotabla.Contacto;
import edu.itla.agenda.modelotabla.ModeloTablaContactos;
import edu.itla.agenda.serializar.Serializadora;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTable tblListarContacto;
	private String nombre;
	private String apellido;
	private String telefono;
	private long revisarTelefono;
	Serializadora serializar = new Serializadora();

	public InterfazUsuario() {
		
		setTitle("Agenda Electrónica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(425, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(InterfazUsuario.this, "Agenda Electrónica \nHecha por Erick Jiménez \nCopyright© 2013", 
						"Acerca de", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertarContactos = new JLabel("Insertar Contactos");
		lblInsertarContactos.setForeground(Color.BLUE);
		lblInsertarContactos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInsertarContactos.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarContactos.setBounds(109, 11, 181, 23);
		contentPane.add(lblInsertarContactos);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(84, 49, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(84, 89, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono: ");
		lblTelefono.setBounds(84, 129, 60, 14);
		contentPane.add(lblTelefono);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(140, 85, 150, 23);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(140, 45, 150, 23);
		contentPane.add(txtNombre);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(140, 125, 150, 23);
		contentPane.add(txtTelefono);
		
		JButton btnAgregarContacto = new JButton("Agregar Contacto");
		btnAgregarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				nombre = txtNombre.getText();
				apellido = txtApellido.getText();
				telefono = txtTelefono.getText();
				try {
					revisarTelefono = Long.parseLong(telefono);
				} catch (Exception e) {
					revisarTelefono = 0;
				}
				
				if (nombre.equals("") || apellido.equals("") || telefono.equals("")) {
					JOptionPane.showMessageDialog(InterfazUsuario.this, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if (revisarTelefono == 0) {
						JOptionPane.showMessageDialog(InterfazUsuario.this, "Debe Introducir un teléfono válido", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						int x = (ModeloTablaContactos.getInstancia().verificar(tblListarContacto.getSelectedRow()) + 1);
						Contacto contacto = new Contacto(x, nombre, apellido, telefono);
						ModeloTablaContactos.getInstancia().agregar(contacto);
						
						txtNombre.setText("");
						txtApellido.setText("");
						txtTelefono.setText("");
						
						JOptionPane.showMessageDialog(InterfazUsuario.this, "¡Contacto Agregado!", 
								"Información", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		});
		btnAgregarContacto.setBounds(163, 159, 127, 23);
		contentPane.add(btnAgregarContacto);
		
		JLabel lblListadoDeContactos = new JLabel("Listado de Contactos");
		lblListadoDeContactos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeContactos.setForeground(Color.BLUE);
		lblListadoDeContactos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListadoDeContactos.setBounds(84, 210, 215, 23);
		contentPane.add(lblListadoDeContactos);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 7, 399, 190);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tblListarContacto = new JTable(ModeloTablaContactos.getInstancia());
		
		JScrollPane jspContenedorTabla = new JScrollPane(tblListarContacto);
		jspContenedorTabla.setBounds(10, 246, 399, 244);
		contentPane.add(jspContenedorTabla);
		
		JButton btnEliminarContacto = new JButton("Eliminar Contacto");
		btnEliminarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int filaEliminar = tblListarContacto.getSelectedRow();
				if (filaEliminar != -1) {
					ModeloTablaContactos.getInstancia().eliminar(filaEliminar);
				} else {
					JOptionPane.showMessageDialog(InterfazUsuario.this, "Debe seleccionar un contacto", 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminarContacto.setBounds(289, 501, 120, 23);
		contentPane.add(btnEliminarContacto);
		
	}
}
