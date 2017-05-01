package edu.itla.agenda.serializar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.itla.agenda.modelotabla.Contacto;

public class Serializadora {
	
	public void serializar(ArrayList<Contacto> contactos) throws Exception{
		
		FileOutputStream fos = new FileOutputStream("datos.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(contactos);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Contacto> contactos() throws Exception{
		
		ArrayList<Contacto> contactos;
		FileInputStream fis = new FileInputStream("datos.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		contactos = (ArrayList<Contacto>) ois.readObject();
		ois.close();
		return contactos;
	}
}
