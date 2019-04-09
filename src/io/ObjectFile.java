package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Purpose of ObjectFile is to read and write to a specified file.
 * ONLY one Object can be written and read from the file.  
 * Used to simplify code.
 * @author Camposm97
 */
public class ObjectFile {
	private File file;
	
	public ObjectFile(String src) {
		this.file = new File(src);
	}
	
	public ObjectFile(File file) {
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public void writeObject(Object o) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(o);
			oos.close();
			System.out.println("Successfully wrote object to " + file);
		} catch (Exception e) {
			System.err.println("Failed to write object!");
		}
	}
	
	public Object readObject() {
		Object o = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			o = ois.readObject();
			ois.close();
			System.out.println("Successfully read object from " + file);
		} catch (Exception e) {
			System.err.println("Failed to read object!");
		}
		return o;
	}
	

//	public static void writeObject(File file, Object o) {
//		
//	}
//	
//	public static Object readObject(File file) {
//		Object o = null;
//		return o;
//	}
}
