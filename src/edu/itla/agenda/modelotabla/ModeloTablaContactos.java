package edu.itla.agenda.modelotabla;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import edu.itla.agenda.serializar.Serializadora;

public class ModeloTablaContactos extends AbstractTableModel {
	
	public static final long serialVersionUID = 1L;
	private ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	private String[] columnasTabla = {"Nombre", "Apellido", "Teléfono"};
	private static ModeloTablaContactos instancia;
	Serializadora serializar = new Serializadora();
	
	public static ModeloTablaContactos getInstancia() {
		
		if (instancia == null) {
			instancia = new ModeloTablaContactos();
		}
		return instancia;
	}
	
	public void eliminar(int fila) {
		contactos.remove(fila);
		try {
			serializar.serializar(ModeloTablaContactos.getInstancia().contactos);
			fireTableDataChanged();
			JOptionPane.showMessageDialog(null, "¡Contacto Eliminado!", 
					"Información", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Guardar los archivos en el disco duro", 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int verificar(int fila) {
		return contactos.get(fila).getIdContacto();
	}
	
	public void modificar(int fila) {
		contactos.get(fila).
	}
	
	public void agregar(Contacto contacto) {
		contactos.add(contacto);
		try {
			serializar.serializar(contactos);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Guardar los archivos en el disco duro", "Error", JOptionPane.ERROR_MESSAGE);
		}
		fireTableDataChanged();
	}
	
	private ModeloTablaContactos() {
		
		try {
			contactos = serializar.contactos();
		} catch (Exception e) {
			contactos = new ArrayList<Contacto>();
		}
		fireTableDataChanged();
	}
	
	public int getColumnCount() {
		return columnasTabla.length;
	}
	
	public int getRowCount() {
		return contactos.size();
	}
	
	public Object getValueAt(int fila, int columna) {
		
		String valorCelda = "";
		Contacto contacto = contactos.get(fila);
		
		switch (columna) {
			case (0):
				valorCelda = contacto.getNombre();
			break;
			case (1):
				valorCelda = contacto.getApellido();
			break;
			case (2):
				valorCelda = contacto.getTelefono();
			break;
		}
		return valorCelda;
	}
	
	public String getColumnName(int columna) {
		return columnasTabla[columna];
	}
}
