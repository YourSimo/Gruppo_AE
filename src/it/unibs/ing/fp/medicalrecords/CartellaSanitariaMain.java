package it.unibs.ing.fp.medicalrecords;


import java.io.File;

import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.OutputData;

public class CartellaSanitariaMain {
	private static final String MSG_INTRO = "BENVENUTO NEL PROGRAMMA GESTIONE CARTELLA SANITARIA";
	private static final String MSG_OUTRO = "A PRESTO";
	
	private static final String NAME_FILE_TITLE = "cartellasanitaria.dat";
	private static final String MSG_NO_CAST = "ATTENZIONE PROBLEMI CON IL CAST";
	private static final String MSG_OK_FILE = "CARICAMENTO DA FILE EFFETTUATO";
	private static final String MSG_NO_FILE = "NON POSSO CARICARE DA FILE: ESEGUO CREAZIONE DA ZERO";
	
	private static final String MSG_SALVA = "SALVATAGGIO DATI";
	
	private final static String MSG_INTRO_INSERIMENTO = "Benvenuto. Di seguito potr‡ inserire i dati personali per la sua cartella medica; tutti i campi sono obbligatori";
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
    
	private final static String MSG_ERRORE_INSERIMENTO = "Errore nell'inerimento dati. Dato non valido. Ritenti."

	public static void main(String[] args) {
		printMsg(MSG_INTRO);
		
		File fileCartellaSanitaria = new File(NAME_FILE_TITLE);
	  
		ListaEsami listaEsami = null;
		CartellaSanitaria cartellaSanitaria = null;
		Contenitore contenitore = null;
	
		boolean caricamentoRiuscito = false;
	
		if(fileCartellaSanitaria.exists()) {
			try {
				contenitore = (Contenitore)OutputData.loadSingleObject(fileCartellaSanitaria);
				listaEsami = contenitore.getListaEsami();
				cartellaSanitaria = contenitore.getCartellaSanitaria();
			} catch (ClassCastException e) {
				System.out.println(MSG_NO_CAST);
			} finally {
				if ((listaEsami != null) && (cartellaSanitaria != null)) {
					System.out.println(MSG_OK_FILE);
					caricamentoRiuscito = true;
				}
			}
		}
	
		if (!caricamentoRiuscito) {
			System.out.println(MSG_NO_FILE);
			cartellaSanitaria = makeMedicalRecords();
		}
		/*
		System.out.println("\n" + MSG_INTRO_PORTFOLIO);
 		System.out.println(portafoglio.toString());
		
		int giorni = 0;
		while (InputData.yesOrNo(MSG_PROCEDI)) {
		 	giorni++;
		 	elencoTitoli.setRandomValues();
		 	System.out.println(String.format(MSG_INTRO_GIORNO, giorni));
	 	 	System.out.println(portafoglio);
		 
		}
		*/
		System.out.println(MSG_SALVA);
		contenitore = new Contenitore(listaEsami, cartellaSanitaria);
		OutputData.uploadSingleObject(fileCartellaSanitaria, contenitore);
	
		printMsg(MSG_OUTRO);
	}
	
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
		
		while (validit‡Nome(nome) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    nome = null;
			nome = InputData.readString(MSG_NOME);	
		};
		//**************************************************
		String cognome = InputData.readString(MSG_COGNOME);
		
		while (validit‡Cognome(cognome) == false){
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    cognome = null;
			cognome = InputData.readString(MSG_COGNOME);	
		};
		//**************************************************
		String indirizzo = InputData.readString(MSG_INDIRIZZO);
		
		
		
		
		
		
		
		
		String telefono = InputData.readString (MSG_TELEFONO);
		String email = InputData.readString (MSG_EMAIL);
		String dataNascita = InputData.readString (MSG_DATA_NASCITA);
		String luogoNascita = InputData.readString (MSG_LUOGO_NASCITA);
		String genere = InputData.readString (MSG_GENERE);
		String codiceFiscale = InputData.readString (MSG_CODICE_FISCALE);
		//codice sanitario
		
		//controllo validit‡ dati
		String gruppoSanguigno = InputDati.leggiStringa (MSG_GRUPPO_SANGUIGNO);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return new Paziente();
	}
	
	private static ListaEsami makeExamList() {
		return new ListaEsami();
	}
	
//////////////////////////////////////////////////////////////////////	 
    public static boolean validit‡Nome (String nome){
    	for(int i = 0; i < nome.length(); i++)
    	{
    		  char carattere = nome.charAt(i);
    		  if(carattere<65 || ((carattere>90) && (carattere<97) || carattere>122))return false;
    	
    	}
    	return true;
    	}
/////////////////////////////////////////////////////////////////////////	
	public static boolean validit‡Cognome (String cognome){
		return validit‡Nome(cognome);
	}
//////////////////////////////////////////////////////////////////////	
	
	
	
	
	
	
}

