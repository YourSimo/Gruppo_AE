package it.unibs.ing.fp.medicalrecords;

import java.io.File;

import it.unibs.ing.fp.library.Formatting;
import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.OutputData;

/**
 * <h1> Class CartellaSanitariaMain </h1>
 * <p>
 * @author Simone Cavicchioli
 *
 */
public class CartellaSanitariaMain {
	public static final int LARGHEZZA_PRIMA_COLONNA = 3;
	public static final int LARGHEZZA_ALTRE_COLONNE = 13;
	
	private static final String MSG_INTRO = "BENVENUTO NEL PROGRAMMA GESTIONE CARTELLA SANITARIA";
	private static final String MSG_OUTRO = "A PRESTO";
	
	private static final String NAME_FILE_TITLE = "cartellasanitaria.dat";
	private static final String MSG_NO_CAST = "ATTENZIONE PROBLEMI CON IL CAST";
	private static final String MSG_OK_FILE = "CARICAMENTO DA FILE EFFETTUATO";
	private static final String MSG_NO_FILE = "NON POSSO CARICARE DA FILE: ESEGUO CREAZIONE DA ZERO";
	
	private static final String MSG_SALVA = "SALVATAGGIO DATI";
	

	private static final String MSG_NEXT = "Cosa vuoi fare? Visualizzare scheda Paziente [P], scheda Esame [E], Aggiungere un esame [A] o Uscire [U] ";
	private static final String VALID_CHAR = "PEAUpeau";
	private static final String CHOISE_ERR = "ATTENZIONE INSERIMENTO ERRATO";
	private static final String MSG_NEXT_EXAM = "Inserire n° Esame oppure il Tipo di Esame: ";
	private static final String MSG_NO_EXAM = "NON ESISTE ALCUN ESAME CON QUESTO NOME O L'ESAME NON HA UN ESITO";
	private static final String MSG_HOME_SCREEN = "Per tornare alla schermata principale premere invio";
	private static final String MSG_EDIT_EXAM = "Vuoi modifare i dati di questo esame";

	private static final String [] TITOLI = {"DATA", "VALORE"};
	
	public static void main(String[] args) {
		System.out.println(MSG_INTRO);
		
		File fileCartellaSanitaria = new File(NAME_FILE_TITLE);
	  
		CartellaSanitaria myCartellaSanitaria = null;
	
		boolean caricamentoRiuscito = false;
	
		if(fileCartellaSanitaria.exists()) {
			try {
				myCartellaSanitaria = (CartellaSanitaria)OutputData.loadSingleObject(fileCartellaSanitaria);
			} catch (ClassCastException e) {
				System.out.println(MSG_NO_CAST);
			} finally {
				if (myCartellaSanitaria != null) {
					System.out.println(MSG_OK_FILE);
					caricamentoRiuscito = true;
				}
			}
		}
	
		if (!caricamentoRiuscito) {
			System.out.println(MSG_NO_FILE);
			//	cartellaSanitaria = Utility.makeMedicalRecords();
		}
			Paziente paziente = new Paziente("Mario", "Rossi", "Via Branze 32", "1234567890", "m.rossi@mail.com", "01/01/1996", "Brescia", "M", "RSS MRA 96A01 B157F", "Codice Sanitario", "A+");
			
			Esame e1 = new Esame("Radiografia", "Brescia", "21/04/2014", "17:40", "Raccom.", "Esito");
			Esame e2 = new Esame("Ecografia", "Mantova", "22/05/2015", "8:30", "Raccom.", "Esito");
			Esame e3 = new EsameMisurabile("Glicemia", "Brescia", "23/06/2016", "10:20", "Raccom.", "Esito", 70);
			Esame e4 = new EsameMisurabile("Colesterolo", "Mantova", "24/07/2016", "18:00", "Raccom.", "Esito", 40);
			Esame e5 = new EsameMisurabile("Glicemia", "Brescia", "23/06/2016", "10:20", "Raccom.", "Esito", 40);
			
			ListaEsami myListaEsami = new ListaEsami();
			myListaEsami.addExam(e1);
			myListaEsami.addExam(e2);
			myListaEsami.addExam(e3);
			myListaEsami.addExam(e4);
			myListaEsami.addExam(e5);
			myCartellaSanitaria = new CartellaSanitaria(paziente, myListaEsami);
		
		mainOptions(myCartellaSanitaria);
		
		System.out.println(MSG_SALVA);
		OutputData.uploadSingleObject(fileCartellaSanitaria, myCartellaSanitaria);
	
		System.out.println(MSG_OUTRO);
	}
	
	
	private static void mainOptions(CartellaSanitaria cs) {
		boolean finito = false;
 		do {
 			System.out.println(cs.toString());
 			char scelta = InputData.readCharLimitedSensitive(MSG_NEXT, VALID_CHAR);
 			switch(scelta) {
 				case 'P' :
 				case 'p' :
 					System.out.println(cs.getPaziente().toString());
 					homeScreen();
 					break;
 				case 'E' :
 				case 'e' :
 					examOptions(cs);
 					homeScreen();
 					break;
 				case 'A' :
 				case 'a' :
 					cs.getListaEsami().addExam(Utility.sceltaCostruttoreEsame());
 					break;
 				case 'U' :
 				case 'u' :
 					finito = true;
 					break;
 				default :
 					System.out.println(CHOISE_ERR);
 			}
 			
 		} while(!finito);
	}
	
	private static void examOptions(CartellaSanitaria cs) {
		String datoInserito = InputData.readStringNotEmpty(MSG_NEXT_EXAM);
		if(Utility.convalidaTelefono(datoInserito)) 
			System.out.println(cs.getListaEsami().getExam(Integer.parseInt(datoInserito) - 1).toString());
		
		else if(Utility.convalidaNome(datoInserito)) {
			boolean trovato = false;
			for(int i = 0; i < cs.getListaEsami().getSize(); i++)
				if(datoInserito.equalsIgnoreCase(cs.getListaEsami().getExam(i).esame) && cs.getListaEsami().getExam(i) instanceof EsameMisurabile) {
					trovato = true;
					break;
				}
			if(trovato == true) {
				System.out.print(Formatting.framing(datoInserito.toUpperCase()));
				System.out.println(heading());
				for(int i = 0; i < cs.getListaEsami().getSize(); i++)
					if(datoInserito.equalsIgnoreCase(cs.getListaEsami().getExam(i).esame) && cs.getListaEsami().getExam(i) instanceof EsameMisurabile) 
						System.out.println(((EsameMisurabile) cs.getListaEsami().getExam(i)).toResult());	
			}
			else if(trovato == false) System.out.println(MSG_NO_EXAM);
		}
		else System.out.println(CHOISE_ERR + datoInserito);	
		//	Per ogni Esame richiesta di modifica
	}
	
	private static void homeScreen() {
		String datoInserito = InputData.readString(MSG_HOME_SCREEN);
		if(!datoInserito.equals(""));
	}
	
	private static void editExam(Esame examToEdit) {
		if(InputData.yesOrNo(MSG_EDIT_EXAM)) {
			//	Luogo e orario
			
			//	Valore
		}
	}
	
	//	Data	Valore
	private static String heading() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.indentation(TITOLI[0], CartellaSanitariaMain.LARGHEZZA_PRIMA_COLONNA));
		for(int i = 1; i < TITOLI.length; i++) {
			result.append(Formatting.centered(TITOLI[i], CartellaSanitariaMain.LARGHEZZA_ALTRE_COLONNE));
		}
		return result.toString();
	}
}


