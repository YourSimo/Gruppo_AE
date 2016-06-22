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
	private final static String MSG_INTRO_INSERIMENTO = "Benvenuto. Di seguito potr√† inserire i dati personali per la sua cartella medica; tutti i campi sono obbligatori";
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
	
	//messaggi per esame
	
	private final static String MSG_ESAME = "Inserisca l'esame che vuole aggiungere:";		
	private final static String MSG_DATA = "Inserisca la data in cui Ë stato svolto:";
	private final static String MSG_LUOGO = "Inserisca il luogo in cui Ë stato svolto:";
	private final static String MSG_ORA = "Inserisca l'orario in cui Ë stato svolto:";
	private final static String MSG_ESITO = "Inserisca l'esito dell'esame:";
	 
	private final static String MSG_ERRORE_INSERIMENTO = "Errore nell'inserimento dati. Dato non valido. Ritenti.";

	private final static String REGEX_ALFABETO = "^[a-zA-Z]+$";
	private final static String REGEX_INDIRIZZO ="^[a-zA-Z]+[\t\n\r\f][a-zA-Z]+[,][0-9]+$";//stringa spazio stringa virgola numeri
	private final static String REGEX_TELEFONO = "^[0-9]+$";
	private final static String REGEX_EMAIL = "^[a-zA-Z0-9._%-]+[@][a-zA-Z0-9.-]+[.][a-zA-Z]{2,4}$";
	private final static String REGEX_DATA_NASCITA = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)[0-9]{2}";
	
	private final static String REGEX_CODICE_FISCALE = "[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]";
	private final static String REGEX_DATA = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)[0-9]{2}";
	private final static String REGEX_ORA = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01]){2}";
	
	public static CartellaSanitaria makeMedicalRecords() {
		return new CartellaSanitaria(makePatient(), makeExamList());
	}
//////////////////////////////////////////////////////////////////	
	public static Paziente makePatient() {
		

		System.out.println(MSG_INTRO_INSERIMENTO);
		//************************************************
		String nome = InputData.readString(MSG_NOME);
		
		while (validit√†Nome(nome) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    nome = null;
			nome = InputData.readString(MSG_NOME);	
		};
		//**************************************************
		String cognome = InputData.readString(MSG_COGNOME);
		
		while (validit√†Cognome(cognome) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    cognome = null;
			cognome = InputData.readString(MSG_COGNOME);	
		};
		//**************************************************
		String indirizzo = InputData.readString(MSG_INDIRIZZO);
		
		while (validit√†Indirizzo(indirizzo) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    indirizzo = null;
			indirizzo = InputData.readString(MSG_INDIRIZZO);	
		};
		//***************************************************
		String telefono = InputData.readString (MSG_TELEFONO);

		while (validit√†Telefono(telefono) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    telefono = null;
			telefono = InputData.readString(MSG_TELEFONO);	
		};
		//******************************************************
		String email = InputData.readString (MSG_EMAIL);
		
		while (validit√†Email(email) == false){
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
		
		//controllo validit√† dati
		String gruppoSanguigno = InputData.readString (MSG_GRUPPO_SANGUIGNO);
		
		
		//manca regex gruppo sanguigno
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return new Paziente(nome, cognome, indirizzo, telefono, email, dataNascita, luogoNascita, genere, codiceFiscale, codiceSanitario, gruppoSanguigno);
	}
	
	private static ListaEsami makeExamList() {
		
		//verifica esame
		String esame = InputData.readString(MSG_ESAME);
		
		while (validit‡†Esame(esame) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    esame = null;
			esame = InputData.readString(MSG_ESAME);	
		};
		//verifica data
		
		String data = InputData.readString(MSG_DATA);
		
		while (validit‡†Data(data) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    data = null;
			data = InputData.readString(MSG_DATA);	
		};
		//verifica luogo
		
		String luogo = InputData.readString(MSG_LUOGO);
		
		while (validit‡†Luogo(luogo) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    luogo = null;
			luogo = InputData.readString(MSG_LUOGO);	
		};
		//verifica ora
		
		String ora = InputData.readString (MSG_ORA);

		while (validit‡†Ora(ora) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    ora = null;
			ora = InputData.readString(MSG_ORA);	
		};
		//verifica esito
		
		String esito = InputData.readString (MSG_ESITO);
		
		while (validit‡†Esito(esito) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    esito = null;
			esito = InputData.readString(MSG_ESITO);	
		};
		
		
		
		
		
		return new ListaEsami(esame, luogo,data, ora,esito); 
	}
	
//////////////////////////////////////////////////////////////////////	 
    public static boolean validit√†Nome (String nome){
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
	public static boolean validit√†Cognome (String cognome){
		return validit√†Nome(cognome);
	}
//////////////////////////////////////////////////////////////////////	
	public static boolean validit√†Indirizzo (String indirizzo){
		if (Pattern.matches(REGEX_INDIRIZZO, indirizzo))
    	    return true;
    	  else
    	    return false;
	}
////////////////////////////////////////////////////////////////////////	
	public static boolean validit√†Telefono (String telefono){
		if (Pattern.matches(REGEX_TELEFONO, telefono))
    	    return true;
    	  else
    	    return false;
	}
////////////////////////////////////////////////////////////////////////
	public static boolean validit√†Email (String email){
		if (Pattern.matches(REGEX_EMAIL, email))
    	    return true;
    	  else
    	    return false;
	}
////////////////////////////////////////////////////////////////////////
}
