package it.unibs.ing.fp.medicalrecords;

import java.io.File;

import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.OutputData;

public class CartellaSanitariaMain {
	public static final int LARGHEZZA_PRIMA_COLONNA = 8;
	public static final int LARGHEZZA_ALTRE_COLONNE = 15;
	
	private static final String MSG_INTRO = "BENVENUTO NEL PROGRAMMA GESTIONE CARTELLA SANITARIA";
	private static final String MSG_OUTRO = "A PRESTO";
	
	private static final String NAME_FILE_TITLE = "cartellasanitaria.dat";
	private static final String MSG_NO_CAST = "ATTENZIONE PROBLEMI CON IL CAST";
	private static final String MSG_OK_FILE = "CARICAMENTO DA FILE EFFETTUATO";
	private static final String MSG_NO_FILE = "NON POSSO CARICARE DA FILE: ESEGUO CREAZIONE DA ZERO";
	
	private static final String MSG_SALVA = "SALVATAGGIO DATI";
	
<<<<<<< HEAD
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
	
	private final static String GENERE_ACCETTABILE_1 = "maschio";
	private final static String GENERE_ACCETTABILE_2 = "m";
	private final static String GENERE_ACCETTABILE_3 = "uomo";
	private final static String GENERE_ACCETTABILE_4 = "femmina";
	private final static String GENERE_ACCETTABILE_5 = "f";
	private final static String GENERE_ACCETTABILE_6 = "donna";
	
	private final static String SANGUE_ACCETTABILE_1 = "Apositivo";
	private final static String SANGUE_ACCETTABILE_2 = "Bpositivo";
	private final static String SANGUE_ACCETTABILE_3 = "ABpositivo";
	private final static String SANGUE_ACCETTABILE_4 = "0positivo";
	private final static String SANGUE_ACCETTABILE_5 = "Anegativo";
	private final static String SANGUE_ACCETTABILE_6 = "Bnegativo";
	private final static String SANGUE_ACCETTABILE_7 = "ABnegativo";
	private final static String SANGUE_ACCETTABILE_8 = "0negativo";
	private final static String SANGUE_ACCETTABILE_9 = "";
	private final static String SANGUE_ACCETTABILE_10 = "";
	
	
	
	
=======
	private static final String MSG_NEXT = "Cosa vuoi fare? Visualizzare scheda Paziente [P], Esame [E] o Uscire [U]";
	private static final String VALID_CHAR = "PEU";
	private static final String CHOISE_ERR = "Attenzione: inserimento errato";
	private static final String MSG_NEXT_EXAM = null;
	private static final String VALID_CHAR_EXAM = null;
>>>>>>> branch 'master' of https://github.com/YourSimo/Gruppo_AE.git
	
	public static void main(String[] args) {
		System.out.println(MSG_INTRO);
		
		File fileCartellaSanitaria = new File(NAME_FILE_TITLE);
	  
		CartellaSanitaria cartellaSanitaria = null;
	
		boolean caricamentoRiuscito = false;
	
		if(fileCartellaSanitaria.exists()) {
			try {
				cartellaSanitaria = (CartellaSanitaria)OutputData.loadSingleObject(fileCartellaSanitaria);
			} catch (ClassCastException e) {
				System.out.println(MSG_NO_CAST);
			} finally {
				if (cartellaSanitaria != null) {
					System.out.println(MSG_OK_FILE);
					caricamentoRiuscito = true;
				}
			}
		}
	
		if (!caricamentoRiuscito) {
			System.out.println(MSG_NO_FILE);
			//	cartellaSanitaria = Utility.makeMedicalRecords();
			Paziente paziente = new Paziente("Mario", "Rossi", "Via Branze 32", "1234567890", "m.rossi@mail.com", "01/01/1996", "Brescia", "M", "RSS MRA 96A01 B157F", "Codice Sanitario", "A+");
			
			ListaEsami listaEsami = new ListaEsami();
			listaEsami.addExam(new Esame("Glicemia", "Raccom.", "Brescia", "24/06/2016", "8:30"));
			
			cartellaSanitaria = new CartellaSanitaria(paziente, listaEsami);
		}
		
 		System.out.println(cartellaSanitaria.toString());
 		
		boolean finito = false;
 		do {
 			char scelta = InputData.readCharLimitedSensitive(MSG_NEXT, VALID_CHAR);
 			switch(scelta) {
 				case 'P' :
 					System.out.println(cartellaSanitaria.getPaziente().toString());
 					break;
 				case 'E' :
 					//	Secondo switch/if e else: nÂ° Esame o tipoEsame
 					break;
 				case 'U' :
 					finito = true;
 					break;
 				default :
 					System.out.println(CHOISE_ERR);
 			}
 			
 		} while(!finito);
		/*
		 * 	do {
		 * 	switch() {
		 * 		case 'U' :
		 * 		break;
		 * 		case 'E' :
		 * 	-	Utente 	[U]
		 * 	-	Esame 	[E]
		 * 		-	nÂ° Esame:
		 * 		-	tipo Esame:
		 * 	-	Chiudi	[C]
		 * 	} while();
		 */
	
		System.out.println(MSG_SALVA);
		OutputData.uploadSingleObject(fileCartellaSanitaria, cartellaSanitaria);
	
		System.out.println(MSG_OUTRO);
	}
	
<<<<<<< HEAD
	private static void printMsg(String msg) {
		System.out.println(msg);
	}

	private static CartellaSanitaria makeMedicalRecords() {
		return new CartellaSanitaria(makePatient(), makeExamList());
	}
//////////////////////////////////////////////////////////////////	
	private static Paziente makePatient() {
		

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
		
		while (validitàDataNascita(dataNascita) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    dataNascita = null;
			dataNascita = InputData.readString(MSG_DATA_NASCITA);	
		};
		//**********************************************************
		String luogoNascita = InputData.readString (MSG_LUOGO_NASCITA);

		while (validitàLuogoNascita(luogoNascita) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    luogoNascita = null;
			luogoNascita = InputData.readString(MSG_LUOGO_NASCITA);	
		};
		//**********************************************************
		String genere = InputData.readString (MSG_GENERE);

		while (validitàGenere(genere) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    genere = null;
			genere = InputData.readString(MSG_LUOGO_NASCITA);	
		};
		//**********************************************************
		String codiceFiscale = InputData.readString (MSG_CODICE_FISCALE);

		while (validitàCodiceFiscale(codiceFiscale) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    codiceFiscale = null;
			codiceFiscale = InputData.readString(MSG_CODICE_FISCALE	);	
		};
		//**********************************************************
		
		
		
		
		//controllo validità dati
		String gruppoSanguigno = InputData.readString (MSG_GRUPPO_SANGUIGNO);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return new Paziente();
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
	public static boolean validitàDataNascita (String dataNascita){
		if (Pattern.matches(REGEX_DATA_NASCITA, dataNascita))
    	    return true;
    	  else
    	    return false;
	}
/////////////////////////////////////////////////////////////////////////////	
	public static boolean validitàLuogoNascita (String luogoNascita){
		if (Pattern.matches(REGEX_ALFABETO, luogoNascita))
    	    return true;
    	  else
    	    return false;
	}
/////////////////////////////////////////////////////////////////////////////
	public static boolean validitàGenere (String genere){
		if (Pattern.matches(REGEX_ALFABETO, genere)){
			if(genere.equalsIgnoreCase(GENERE_ACCETTABILE_1)||genere.equalsIgnoreCase(GENERE_ACCETTABILE_2)||genere.equalsIgnoreCase(GENERE_ACCETTABILE_3)||genere.equalsIgnoreCase(GENERE_ACCETTABILE_4)||genere.equalsIgnoreCase(GENERE_ACCETTABILE_5)||genere.equalsIgnoreCase(GENERE_ACCETTABILE_6))
				return true;
		}
    	  else
    	    return false;
	}
/////////////////////////////////////////////////////////////////////////////
	public static boolean validitàCodiceFiscale (String codiceFiscale){
		if (Pattern.matches(REGEX_CODICE_FISCALE, codiceFiscale))
    	    return true;
    	  else
    	    return false;
	}
/////////////////////////////////////////////////////////////////////////////
    public static boolean validitàGruppoSanguigno (String gruppoSanguigno){
    	String strOut = gruppoSanguigno.replaceAll ("\\s+$", "");
    	
    	
    }

=======
>>>>>>> branch 'master' of https://github.com/YourSimo/Gruppo_AE.git
}


