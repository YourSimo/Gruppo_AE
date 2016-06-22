package it.unibs.ing.fp.medicalrecords;

import java.util.Random;
import java.util.regex.Pattern;

import it.unibs.ing.fp.library.InputData;

/**
 * <h1> Class Utility </h1>
 * <p>
 * @author Simone Cavicchioli
 *
 */
public class Utility {
	//messaggi per richiedere inserimento dati
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
    
	private final static String MSG_ERRORE_INSERIMENTO_ALFABETO= "Errore nell'inserimento dati. La stringa inserita deve contenere solo lettere. Ritenti.";
	private final static String MSG_ERRORE_INSERIMENTO_INDIRIZZO = "Errore nell'inserimento dati. I dati inseriti devono essere nel formato aaaaaa aaaaaa,222. Ritenti";
	private final static String MSG_ERRORE_INSERIMENTO_TELEFONO= "Errore nell'inserimento dati. La stringa inserita deve contenere solo numeri. Ritenti";
	private final static String MSG_ERRORE_INSERIMENTO_EMAIL= "Errore nell'inserimento dati. La stringa deve essere nel formato aaaaaa.aaaaaa@aaaaa.aaa. Ritenti";
	private final static String MSG_ERRORE_INSERIMENTO_DATA_NASCITA= "Errore nell'inserimento dati. La stringa inserita deve essere nel formato gg/mm/aaaa. Ritenti";
	private final static String MSG_ERRORE_INSERIMENTO_CODICE_FISCALE= "Errore nell'inserimento dati. La stringa inserita deve rispettare la composizione del codice fiscale. Ritenti";
	private final static String MSG_ERRORE_INSERIMENTO = "Errore nell'inserimento dati. Dato non valido. Ritenti.";

	/*regular expressions, permettono di creare una sringa formata da 
	 * caratteri speciali che il computer interpreta appositamente. 
	 * Sono usate per verificare se delle stringhe rispettano un determinato
	 * formato specificato appunto grazie alla stringa formata dalle regex
	 * */
	//la regex dell'alfabeto verifica che la stringa si componga solo di lettere
	private final static String REGEX_ALFABETO = "^[a-zA-Z]+$";
	//la stringa dell'indirizzo deve essere fatta da caratteri spazio caratteri virgola numeri
	private final static String REGEX_INDIRIZZO ="^[a-zA-Z]+[\t\n\r\f][a-zA-Z]+[,][0-9]+$";//stringa spazio stringa virgola numeri
	//solo numeri
	private final static String REGEX_TELEFONO = "^[0-9]+$";
	//lettere o numeri chiocciola stringa o numeri punto e da due a 4 caratteri
	private final static String REGEX_EMAIL = "^[a-zA-Z0-9._%-]+[@][a-zA-Z0-9.-]+[.][a-zA-Z]{2,4}$";
	//numeri in formato gg/mm/aaaa 
	private final static String REGEX_DATA_NASCITA = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)[0-9]{2}";
	//la regex del luogo di nascita Ë alfabeto
	//composizione del codice fiscale rispettando numeri e lettere
	private final static String REGEX_CODICE_FISCALE = "[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]";
	
	//array di stringhe con cui confrontare il genere
	private final static String GENERE_ACCETTABILE [] = {"maschio",
														 "m",
														 "uomo",
														 "femmina",
														 "f",
														 "donna"};
	//array di stringhe con cui conforntare il gruppo sanguigno
	private final static String GRUPPO_SANGUIGNO_ACCETTABILE[] = {"Apositivo",
																  "Bpositivo",
																  "ABpositivo",
																  "0positivo",
																  "Anegativo",
																  "Bnegativo",
																  "ABnegativo",
																  "0negativo",
																  "Apos",
																  "Bpos",
																  "ABpos",
																  "0pos",
																  "Aneg",
																  "Bneg",
																  "ABneg",
																  "0neg",
																  "A+",
																  "B+",
																  "AB+",
																  "0+",
																  "A-",
																  "B-",
																  "AB-",
																  "0-"};
	//arbitrria lunghezza stabilita x la stringa del codice sanitario
	private final static int LUNGHEZZA_CODICE_SANITARIO = 10;
	
	
///////////////////////////////////////////////////////////////////	
	public static CartellaSanitaria makeMedicalRecords() {
		return new CartellaSanitaria(makePatient(), makeExamList());
	}
//////////////////////////////////////////////////////////////////	
	/*classe che provvede alla creazione di un oggetto Paziente, 
	 * chiede all'utente l'inserimento dati
	 */
	public static Paziente makePatient() {
		

		System.out.println(MSG_INTRO_INSERIMENTO);
		//************************************************
		String nome = InputData.readString(MSG_NOME);
		//si continua a richiedere l'inserimento fino a quando i dati non sono corretti
		while (validit‡Nome(nome) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO_ALFABETO);
		    nome = null;
			nome = InputData.readString(MSG_NOME);	
		};
		//**************************************************
		String cognome = InputData.readString(MSG_COGNOME);
		
		while (validit‡Cognome(cognome) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO_ALFABETO);
		    cognome = null;
			cognome = InputData.readString(MSG_COGNOME);	
		};
		//**************************************************
		String indirizzo = InputData.readString(MSG_INDIRIZZO);
		
		while (validit‡Indirizzo(indirizzo) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO_INDIRIZZO);
		    indirizzo = null;
			indirizzo = InputData.readString(MSG_INDIRIZZO);	
		};
		//***************************************************
		String telefono = InputData.readString (MSG_TELEFONO);

		while (validit‡Telefono(telefono) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO_TELEFONO);
		    telefono = null;
			telefono = InputData.readString(MSG_TELEFONO);	
		};
		//******************************************************
		String email = InputData.readString (MSG_EMAIL);
		
		while (validit‡Email(email) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO_EMAIL);
		    email = null;
			email = InputData.readString(MSG_EMAIL);	
		};
		//********************************************************
		String dataNascita = InputData.readString (MSG_DATA_NASCITA);
		

		while (validit‡DataNascita(dataNascita) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO_DATA_NASCITA);
		    dataNascita = null;
			dataNascita = InputData.readString(MSG_DATA_NASCITA);	
		};
		//**********************************************************
		String luogoNascita = InputData.readString (MSG_LUOGO_NASCITA);
		

		while (validit‡LuogoNascita(luogoNascita) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO_ALFABETO);
		    luogoNascita = null;
			luogoNascita = InputData.readString(MSG_LUOGO_NASCITA);	
		};
		//**********************************************************
		String genere = InputData.readString (MSG_GENERE);
		

		while (validit‡Genere(genere) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    genere = null;
			genere = InputData.readString(MSG_GENERE);	
		};
		//**********************************************************
		String codiceFiscale = InputData.readString (MSG_CODICE_FISCALE);
		

		while (validit‡CodiceFiscale(codiceFiscale) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO_CODICE_FISCALE);
		    codiceFiscale = null;
			codiceFiscale = InputData.readString(MSG_CODICE_FISCALE	);	
		};
		//**********************************************************
		String gruppoSanguigno = InputData.readString (MSG_GRUPPO_SANGUIGNO);
		

		while (validit‡CodiceFiscale(codiceFiscale) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    codiceFiscale = null;
			codiceFiscale = InputData.readString(MSG_GRUPPO_SANGUIGNO);	
		};
		
		String codiceSanitario = generaCodiceSanitario();
	    //con i dati inseriti si crea un oggetto Paziente
		return new Paziente(nome, cognome, indirizzo, telefono, email, dataNascita, luogoNascita, genere, codiceFiscale, codiceSanitario, gruppoSanguigno);
	}
	
	
////////////////////////////////////////////////////////////////////////
	private static ListaEsami makeExamList() {
		
		
		
		
		
		
		
		
		return new ListaEsami();
	}
	
//////////////////////////////////////////////////////////////////////	 
    public static boolean validit‡Nome (String nome){
    	 if (Pattern.matches(REGEX_ALFABETO, nome))
    	    return true;
    	  else
    	    return false;
    	}
/////////////////////////////////////////////////////////////////////////	
	public static boolean validit‡Cognome (String cognome){
		return validit‡Nome(cognome);
	}
//////////////////////////////////////////////////////////////////////	
	public static boolean validit‡Indirizzo (String indirizzo){
		if (Pattern.matches(REGEX_INDIRIZZO, indirizzo))
    	    return true;
    	  else
    	    return false;
	}
////////////////////////////////////////////////////////////////////////	
	public static boolean validit‡Telefono (String telefono){
		if (Pattern.matches(REGEX_TELEFONO, telefono))
    	    return true;
    	  else
    	    return false;
	}
////////////////////////////////////////////////////////////////////////
	public static boolean validit‡Email (String email){
		if (Pattern.matches(REGEX_EMAIL, email))
    	    return true;
    	  else
    	    return false;
	}
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
	public static boolean validit‡DataNascita (String dataNascita){
		if (Pattern.matches(REGEX_DATA_NASCITA, dataNascita))
			return true;
		else
			return false;
	}
/////////////////////////////////////////////////////////////////////////////	
	public static boolean validit‡LuogoNascita (String luogoNascita){
		if (Pattern.matches(REGEX_ALFABETO, luogoNascita))
			return true;
		else
			return false;
	}
/////////////////////////////////////////////////////////////////////////////
	public static boolean validit‡Genere (String genere){
		for ( int i = 0; i <GENERE_ACCETTABILE.length; i++)
			if (genere.equalsIgnoreCase(GENERE_ACCETTABILE[i])) return true;	
		
		return false;
	}
/////////////////////////////////////////////////////////////////////////////
	public static boolean validit‡CodiceFiscale (String codiceFiscale){
		if (Pattern.matches(REGEX_CODICE_FISCALE, codiceFiscale))
			return true;
		else
			return false;
	}
/////////////////////////////////////////////////////////////////////////////
	public static boolean validit‡GruppoSanguigno (String gruppoSanguigno){
		//si crea una nuova stringa senza gli spazi
		String strOut = gruppoSanguigno.replaceAll ("\\s+$", "");
		for ( int i = 0; i <GRUPPO_SANGUIGNO_ACCETTABILE.length; i++)
			if (strOut.equalsIgnoreCase(GRUPPO_SANGUIGNO_ACCETTABILE[i])) return true;
			
		return false;
	}
	
	public static String generaCodiceSanitario (){
		return randomString(LUNGHEZZA_CODICE_SANITARIO);
		
	}
	
	//genera stringa random formata da lettere e numeri e lunga 10 caratteri
	public static String randomString (int length) {
		//creazione oggetto classe random
		Random rnd = new Random ();
		//array di caratteri di lunghezza length
		char[] arr = new char[length];
        //si scorre l'array
		for (int i=0; i<length; i++) {
		//si assegna ad n un numero casuale generato tra 0 e 36
			int n = rnd.nextInt (36);
		    //all'isesimo elemento dell'array si mette un numero se n Ë minore di dieci, o una lettera se n Ë maggiore
			arr[i] = (char) (n < 10 ? '0'+n : 'a'+n-10);
		}
        //l'array Ë trasformato in stringa e viene restituita
		return new String (arr);
		}
}
