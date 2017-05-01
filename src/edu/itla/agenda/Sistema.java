package edu.itla.agenda;

import javax.swing.UIManager;

import edu.itla.agenda.iu.InterfazUsuario;

public class Sistema {
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new InterfazUsuario().setVisible(true);
	}
}
