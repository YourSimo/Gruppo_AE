package it.unibs.ing.fp.medicalrecords;

import java.io.File;

import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.OutputData;

public class CartellaSanitariaMain {
	public static final int LARGHEZZA_PRIMA_COLONNA = 8;
	public static final int LARGHEZZA_ALTRE_COLONNE = 0;
	
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
			cartellaSanitaria = Utility.makeMedicalRecords();
		}
		
 		System.out.println(cartellaSanitaria.toString());
 		
		boolean finito = false;
 		do {
 			char scelta = InputData.readCharLimitedSensitive(MSG_NEXT, VALID_CHAR);
 			switch(scelta) {
 				case 'P' :
 					cartellaSanitaria.getPaziente().toString();
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
		contenitore = new Contenitore(listaEsami, cartellaSanitaria);
		OutputData.uploadSingleObject(fileCartellaSanitaria, contenitore);
	
		System.out.println(MSG_OUTRO);
	}
	
}

