package it.unibs.ing.fp.medicalrecords;

import java.util.regex.Pattern;

import it.unibs.ing.fp.library.InputData;

/**
 * <h1> Class Utility </h1>
 * <p>
 * @author Simone Cavicchioli
 *
 */
public class Utility {
	private final static String MSG_INTRO_INSERIMENTO = "Benvenuto. Di seguito potrà inserire i dati personali per la sua cartella medica; tutti i campi sono obbligatori";
	private final static String MSG_NOME = "Inserisca il proprio nome:";
	private final static String MSG_COGNOME = "Inserisca il proprio cognome:";
	private final static String MSG_INDIRIZZO = "Inserisca il proprio indirizzo:";
	private final static String MSG_TELEFONO = "Inserisca il proprio numero di telefono";
	private final static String MSG_EMAIL = "Inserisca la propria email:";
	private final static String MSG_DATA_NASCITA = "Inserisca la propria data di nascita:";
	private final static String MSG_LUOGO_NASCITA = "Inserisca il proprio luogo di nascita:";
	private final static String MSG_GENERE =  "Inserisca il proprio genere:";
	private final static String MSG_CODICE_FISCALE = "Inserisca il proprio codice fiscale";
	private final static String MSG_GRUPPO_SANGUIGNO = "Inserisca il proprio gruppo sanguigno";
    
	private final static String MSG_ERRORE_INSERIMENTO = "Errore nell'inserimento dati. Dato non valido. Ritenti.";

	private final static String REGEX_ALFABETO = "^[a-zA-Z]+$";
	private final static String REGEX_INDIRIZZO ="^[a-zA-Z]+[\t\n\r\f][a-zA-Z]+[,][0-9]+$";//stringa spazio stringa virgola numeri
	private final static String REGEX_TELEFONO = "^[0-9]+$";
	private final static String REGEX_EMAIL = "^[a-zA-Z0-9._%-]+[@][a-zA-Z0-9.-]+[.][a-zA-Z]{2,4}$";
	private final static String REGEX_DATA_NASCITA = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)[0-9]{2}";
	
	private final static String REGEX_CODICE_FISCALE = "[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]";
	
	public static CartellaSanitaria makeMedicalRecords() {
		return new CartellaSanitaria(makePatient(), makeExamList());
	}
//////////////////////////////////////////////////////////////////	
	public static Paziente makePatient() {
		

		System.out.println(MSG_INTRO_INSERIMENTO);
		//************************************************
		String nome = InputData.readString(MSG_NOME);
		
		while (validitàNome(nome) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    nome = null;
			nome = InputData.readString(MSG_NOME);	
		};
		//**************************************************
		String cognome = InputData.readString(MSG_COGNOME);
		
		while (validitàCognome(cognome) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    cognome = null;
			cognome = InputData.readString(MSG_COGNOME);	
		};
		//**************************************************
		String indirizzo = InputData.readString(MSG_INDIRIZZO);
		
		while (validitàIndirizzo(indirizzo) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    indirizzo = null;
			indirizzo = InputData.readString(MSG_INDIRIZZO);	
		};
		//***************************************************
		String telefono = InputData.readString (MSG_TELEFONO);

		while (validitàTelefono(telefono) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    telefono = null;
			telefono = InputData.readString(MSG_TELEFONO);	
		};
		//******************************************************
		String email = InputData.readString (MSG_EMAIL);
		
		while (validitàEmail(email) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    email = null;
			email = InputData.readString(MSG_EMAIL);	
		};
		//********************************************************
		String dataNascita = InputData.readString (MSG_DATA_NASCITA);
		String luogoNascita = InputData.readString (MSG_LUOGO_NASCITA);
		String genere = InputData.readString (MSG_GENERE);
		String codiceFiscale = InputData.readString (MSG_CODICE_FISCALE);
		//codice sanitario
		
		//controllo validità dati
		String gruppoSanguigno = InputData.readString (MSG_GRUPPO_SANGUIGNO);
		
		
		//manca regex gruppo sanguigno
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return new Paziente(nome, cognome, indirizzo, telefono, email, dataNascita, luogoNascita, genere, codiceFiscale, codiceSanitario, gruppoSanguigno);
	}
	
	private static ListaEsami makeExamList() {
		
		
		
		
		
		
		
		
		return new ListaEsami();
	}
	
//////////////////////////////////////////////////////////////////////	 
    public static boolean validitàNome (String nome){
    	/*for(int i = 0; i < nome.length(); i++)
    	{
    		  char carattere = nome.charAt(i);
    		  if(carattere<65 || ((carattere>90) && (carattere<97) || carattere>122))return false;
    	
    	}
    	return true;*/
    	 if (Pattern.matches(REGEX_ALFABETO, nome))
    	    return true;
    	  else
    	    return false;
    	}
/////////////////////////////////////////////////////////////////////////	
	public static boolean validitàCognome (String cognome){
		return validitàNome(cognome);
	}
//////////////////////////////////////////////////////////////////////	
	public static boolean validitàIndirizzo (String indirizzo){
		if (Pattern.matches(REGEX_INDIRIZZO, indirizzo))
    	    return true;
    	  else
    	    return false;
	}
////////////////////////////////////////////////////////////////////////	
	public static boolean validitàTelefono (String telefono){
		if (Pattern.matches(REGEX_TELEFONO, telefono))
    	    return true;
    	  else
    	    return false;
	}
////////////////////////////////////////////////////////////////////////
	public static boolean validitàEmail (String email){
		if (Pattern.matches(REGEX_EMAIL, email))
    	    return true;
    	  else
    	    return false;
	}
////////////////////////////////////////////////////////////////////////
}
