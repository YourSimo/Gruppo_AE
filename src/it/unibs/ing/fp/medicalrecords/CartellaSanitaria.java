package it.unibs.ing.fp.medicalrecords;

import java.io.Serializable;

import it.unibs.ing.fp.library.Formatting;

/**
 * <h1> Class CartellaSanitaria </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 *
 */
public class CartellaSanitaria implements Serializable {
	private static final String TITOLO = "CARTELLA SANITARIA";
	private static final String DESCRIZIONE = "PAZIENTE: %s%nESAMI:";
	private static final String[] TITOLI = {"N°", "DATA", "NOME", "VALORE"};
	
	
	private Paziente paziente;
	private ListaEsami listaEsami;
	
	public CartellaSanitaria(Paziente paziente, ListaEsami listaEsami) {
		this.paziente = paziente;
		this.listaEsami = listaEsami;
	}
	
	public Paziente getPaziente() {
		return paziente;
	}
	
	public ListaEsami getListaEsami() {
		return listaEsami;
	}
	
	//	TO_STRING
	
	//	Data	Nome	Valore
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
	 * N°	Data			Nome	 		Valore	
	 * ...
	 * ...
	 * ...
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.framing(TITOLO));
		result.append(String.format(DESCRIZIONE, paziente.nomeCognome()));
		result.append(heading());
		for(int i = 0; i < listaEsami.getSize(); i++) 
			result.append("\n" + String.valueOf(i + 1) + ") " + listaEsami.getExam(i).toSummary());
		result.append("\n" + Formatting.cloneChar('-', TITOLO.length()));
		return result.toString();
	}
}
