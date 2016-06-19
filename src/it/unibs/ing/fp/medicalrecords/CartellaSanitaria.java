package it.unibs.ing.fp.medicalrecords;

import it.unibs.ing.fp.library.Formatting;

/**
 * <h1> Class CartellaSanitaria </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 *
 */
public class CartellaSanitaria {
	private static final String TITOLO = "CARTELLA SANITARIA";
	private static final String DESCRIZIONE = "Paziente: %s%n, Esami: %n";
	private static final String[] TITOLI = {"Data", "Nome", "Valore"};
	
	
	private Paziente paziente;
	private ListaEsami listaEsami;
	
	public CartellaSanitaria(Paziente paziente, ListaEsami listaEsami) {
		this.paziente = paziente;
		this.listaEsami = listaEsami;
	}
	
	//	TO_STRING
	
	private static String heading() {
		StringBuffer result = new StringBuffer();
		result.append("\n"+ Formatting.inColumn(TITOLI[0], CartellaSanitariaMain.LARGHEZZA_PRIMA_COLONNA));
		for(int i = 1; i < TITOLI.length; i++) {
			result.append(Formatting.centered(TITOLI[i], CartellaSanitariaMain.LARGHEZZA_ALTRE_COLONNE));
		}
		return result.toString();
	}
	
	/*
	 * Paziente: Cognome Nome
	 * Esami:
	 * Data			Nome	 		Valore	
	 * ...
	 * ...
	 * ...
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(TITOLO);
		result.append(String.format(DESCRIZIONE, paziente.nomeCognome()));
		result.append(heading());
		for(int i = 0; i < listaEsami.getSize(); i++) 
			result.append("\n" + listaEsami.getExam(i).toSummary());
		return result.toString();
	}
}
