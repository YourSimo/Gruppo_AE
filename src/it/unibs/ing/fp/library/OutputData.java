package it.unibs.ing.fp.library;

import java.io.*;

public class OutputData {
	private final static String MSG_NO_FILE = "ATTENZIONE: NON TROVO IL FILE ";
	private final static String MSG_NO_READING = "ATTENZIONE: PROBLEMI CON LA LETTURA DEL FILE ";
	private final static String MSG_NO_WRITING = "ATTENZIONE: PROBLEMI CON LA SCRITTURA DEL FILE ";
	private final static String MSG_NO_CLOSING ="ATTENZIONE: PROBLEMI CON LA CHIUSURA DEL FILE ";
	  	
	public static Object loadSingleObject(File file) {
		Object read = null;
		ObjectInputStream input = null;
				
		try	{
			input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
					
			read = input.readObject();
					
		} 
		catch (FileNotFoundException excNotFound) {
			System.out.println(MSG_NO_FILE + file.getName());
		}
		catch (IOException excLettura) {
			System.out.println(MSG_NO_READING + file.getName());
		}
		catch (ClassNotFoundException excLettura) {
			System.out.println(MSG_NO_READING + file.getName());
		}
	  	finally {
	  		if (input != null) {
	  			try {
	  				input.close();
				}
	  			catch (IOException excChiusura) {
				 	System.out.println(MSG_NO_CLOSING + file.getName());
				}
			}
		}
		return read;
			  
	}	
		
	public static void uploadSingleObject (File file, Object toUpload) {
		ObjectOutputStream output = null;
				
		try	{
			output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			output.writeObject(toUpload);
		}
		catch (IOException excScrittura) {
			System.out.println(MSG_NO_WRITING + file.getName());
		}
		finally	{
			if (output != null)	{
				try {
					output.close();
				}
				catch (IOException excChiusura) {
					System.out.println(MSG_NO_CLOSING + file.getName());
				}
			}
		}
	}	
}
