package it.unibs.ing.fp.medicalrecords;

import java.io.File;
import java.util.regex.*;

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
		
		/*
		 * 	MENU ... Visualizzazione Dettagliata
		 * 	1) Scheda Paziente
		 * 	2) Scheda Esame
		 * 	3) Esci
		 */
	
		System.out.println(MSG_SALVA);
		contenitore = new Contenitore(listaEsami, cartellaSanitaria);
		OutputData.uploadSingleObject(fileCartellaSanitaria, contenitore);
	
		System.out.println(MSG_OUTRO);
	}
	

	
	
	
}

