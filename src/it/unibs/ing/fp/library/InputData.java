package it.unibs.ing.fp.library;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <h1> Class InputData </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v6.0
 * @since 2016-03-15
 */

public class InputData {
	private static Scanner reader = makeScanner();
	
	private final static String ERROR_MIN = "Attenzione: è richiesto un valore maggiore o uguale a ";
	private final static String ERROR_MAX = "Attenzione: è richiesto un valore minore o uguale a ";
	private static final String ERROR_POSITIVE = "Attenzione: è richiesto un valore maggiore di 0";
	private final static String ERROR_LIMIT = "Attenzione i valori ammessi sono nell'intervallo: ";
	private final static String ERROR_CHAR_ALLOWED = "Attenzione sono consentiti solo i caratteri ";
	private final static String ERROR_FORMAT = "Attenzione: il dato inserito non è nel formato corretto";
	private final static String ERROR_EMPTY_STRING = "Attenzione: non hai inserito alcun carattere";

	private static final char YES_ANSWER = 'S';
	private static final char NO_ANSWER = 'N';

	
	
	
	private static Scanner makeScanner() {
		Scanner reader = new Scanner(System.in);
		reader.useDelimiter(System.getProperty("line.separator"));
		return reader;
	}
	
	/**
	 * Return the int read from Console.
	 * @param message - The information on the int to be read
	 * @return the int read
	 */
	public static int readInt(String message) {
		boolean finish = false;
		int readValue = 0;
		do {
			System.out.print(message);
			try {
				readValue = reader.nextInt();
				finish = true;
		    }
		    catch (InputMismatchException e) {
		       System.out.println(ERROR_FORMAT);
		       String trashing = reader.next();
		    }
			/*
			if (reader.hasNextInt()) {
				readValue = reader.nextInt();
				finish = true;
			} else {
				System.out.println(ERROR_FORMAT);
				String trashing = reader.next();
			}
			*/
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadIntWithMin
	public static int readIntWithMin(String message, int min) {
	   boolean finish = false;
	   int readValue = 0;
	   do {
		   readValue = readInt(message);
		   if (readValue >= min) finish = true;
		   else System.out.println(ERROR_MIN + min);
	   } while (!finish);  
	   	return readValue;
	}
	
	public static int readIntPositive(String message) {
		return readIntWithMin(message, 1);
	}
	
	public static int readIntNotNegative(String message) {
		return readIntWithMin(message, 0);
	}
	
	// Metodo ReadIntWithLimit
	public static int readIntWithLimit(String message, int min, int max) {
		boolean finish = false;
		int readValue = 0;
		do {
			readValue = readInt(message);
		    if (readValue >= min && readValue<= max) finish = true;
		    else if (readValue < min) System.out.println(ERROR_MIN + min);
		    else System.out.println(ERROR_MAX + max); 
			/*
			System.out.print(message);
			if (reader.hasNextInt()) {
				readValue = reader.nextInt();
				if (readValue >= min && readValue <= max) finish = true;
			} else {
				System.out.println(ERROR_LIMIT + min + "-" + max);
				String trashing = reader.next();
			}
			*/
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadDouble
	public static double readDouble(String message) {
		boolean finish = false;
		double readValue = 0;
		do {
			System.out.println(message);
			try {
				readValue = reader.nextDouble();
				finish = true;
		    }
		    catch (InputMismatchException e) {
		    	System.out.println(ERROR_FORMAT);
		    	String trashing = reader.next();
		    }
			/*
			if (reader.hasNextDouble()){
				readValue = reader.nextDouble();
				finish = true;
			} else {
				System.out.println(ERROR_FORMAT);
				reader.next();
			}
			*/
		} while(!finish);
		return readValue;	
	}
	
	// Metodo ReadDoubleWithMin
	public static double readDoubleWithMin(String message, double min) {
		boolean finish = false;
		double readValue = 0;
		do {
			readValue = readDouble(message);
			if (readValue >= min)
				finish = true;
			else System.out.println(ERROR_MIN + min);
		} while (!finish);
		return readValue;
	}
	
	public static double readDoublePositive(String message) {
		boolean finish = false;
		double readValue = 0;
		do {
			readValue = readDouble(message);
			if (readValue > 0)
				finish = true;
			else System.out.println(ERROR_POSITIVE);
		} while (!finish);
		return readValue;
	}
	
	public static double readDoubleNotNegative(String message) {
		return readDoubleWithMin(message, 0);
	}
	
	// Metodo ReadDoubleWithLimit
	public static double readDoubleWithLimit(String message, double min, double max) {
		boolean finish = false;
		double readValue = 0;
		do {
			System.out.print(message);
			if (reader.hasNextDouble()) {
				readValue = reader.nextDouble();
				if (readValue >= min && readValue <= max) finish = true;
			} else {
				System.out.println(ERROR_LIMIT + min + "-" + max);
				String trashing = reader.next();
			}
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadChar
	public static char readChar(String message) {
		boolean finish = false;
		char readValue = '\0';
		do {
			System.out.print(message);
			String reading = reader.next();
			if (reading.length() > 0) {
				readValue = reading.charAt(0);
				finish = true;
			}
			else System.out.println(ERROR_EMPTY_STRING);
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadCharLimitedNotSensitive
	public static char readCharLimitedNotSensitive(String message, String validChar) {
		boolean finish = false;
		char readValue = '\0';
		do {
			
			readValue = readChar(message);
			readValue = Character.toUpperCase(readValue);
		    if (validChar.indexOf(readValue) != -1) finish = true;
			/*
			System.out.print(message);
			String reading = reader.next();
			if (reading.length() == 1 && validChar.indexOf(reading.toUpperCase().charAt(0)) != -1) {
				readValue = reading.charAt(0);
				finish = true;
			}
			*/
			else System.out.println(ERROR_CHAR_ALLOWED + validChar);
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadCharLimitedSensitive
	public static char readCharLimitedSensitive(String message, String validChar) {
		boolean finish = false;
		char readValue = '\0';
		do {
			System.out.print(message);
			String reading = reader.next();
			if (reading.length() == 1 && validChar.indexOf(reading.charAt(0)) != -1) {
				readValue = reading.charAt(0);
				finish = true;
			}
			else System.out.println(ERROR_CHAR_ALLOWED + validChar);
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadString
	public static String readString(String message) {
		System.out.print(message);
		return reader.next();
	}
	
	// Metodo readStringNotEmpty
	public static String readStringNotEmpty(String message) {
		boolean finish = false;
		String reading = null;
		do {
			reading = readString(message);
			reading = reading.trim(); // Rimuove i caratteri di spaziatura
			if (reading.length() > 0) finish = true;
			else System.out.println(ERROR_EMPTY_STRING);
		} while (!finish);
		return reading;
	}

	// Metodo yesOrNo
	public static boolean yesOrNo(String message) {
		String completeMessage = message + " [" + YES_ANSWER + "] [" + NO_ANSWER + "] ";
		char readValue = readCharLimitedSensitive(completeMessage, String.valueOf(YES_ANSWER) + String.valueOf(NO_ANSWER));
		if (readValue == YES_ANSWER) return true;
		else return false;
	}
}

