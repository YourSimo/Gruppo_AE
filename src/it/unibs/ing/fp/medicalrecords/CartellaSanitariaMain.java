package it.unibs.ing.fp.medicalrecords;

import java.io.File;
import it.unibs.ing.fp.library.OutputData;

public class CartellaSanitariaMain {
	private static final String MSG_INTRO = "BENVENUTO NEL PROGRAMMA GESTIONE CARTELLA SANITARIA";
	private static final String MSG_OUTRO = "A PRESTO";
	
	private static final String NAME_FILE_TITLE = "cartellasanitaria.dat";
	private static final String MSG_NO_CAST = "ATTENZIONE PROBLEMI CON IL CAST";
	private static final String MSG_OK_FILE = "CARICAMENTO DA FILE EFFETTUATO";
	private static final String MSG_NO_FILE = "NON POSSO CARICARE DA FILE: ESEGUO CREAZIONE DA ZERO";
	
	private static final String MSG_SALVA = "SALVATAGGIO DATI";
	
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
	
	private static Paziente makePatient() {
		return new Paziente();
	}
	
	private static ListaEsami makeExamList() {
		return new ListaEsami();
	}
}
