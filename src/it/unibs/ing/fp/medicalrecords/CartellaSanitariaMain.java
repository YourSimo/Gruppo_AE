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
	

	private static final String MSG_NEXT = "Cosa vuoi fare? Visualizzare scheda Paziente [P], Esame [E] o Uscire [U]";
	private static final String VALID_CHAR = "PEU";
	private static final String CHOISE_ERR = "Attenzione: inserimento errato";
	private static final String MSG_NEXT_EXAM = null;
	private static final String VALID_CHAR_EXAM = null;

	
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
 					//	Secondo switch/if e else: n° Esame o tipoEsame
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
		 * 		-	n° Esame:
		 * 		-	tipo Esame:
		 * 	-	Chiudi	[C]
		 * 	} while();
		 */
	
		System.out.println(MSG_SALVA);
		OutputData.uploadSingleObject(fileCartellaSanitaria, cartellaSanitaria);
	
		System.out.println(MSG_OUTRO);
	}
	

	private static void printMsg(String msg) {
		System.out.println(msg);
	}

	private static CartellaSanitaria makeMedicalRecords() {
		return new CartellaSanitaria(makePatient(), makeExamList());
	}
//////////////////////////////////////////////////////////////////	
		
	private static ListaEsami makeExamList() {
		return new ListaEsami();
	}

}


