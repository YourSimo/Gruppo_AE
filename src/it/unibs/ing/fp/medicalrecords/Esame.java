package it.unibs.ing.fp.medicalrecords;

import java.io.Serializable;

import it.unibs.ing.fp.library.Formatting;

/**
 * <h1> Class Esame </h1>
 * <p>
 * @author Matteo Bellicini
 *
 */
public class Esame implements Serializable {
	private static final String TITOLO = "SCHEDA ESAME";
	private static final String DESCRIZIONE = "Esame: %s%n, Raccomandazioni: %s%n, ...";	//	Aggiornare la Stringa
	
	private String nomeEsame;
	private String raccomandazioni;
	private String luogo;
	private String data;
	private String ora;
		
	/**
	 * Costruttore.	
	 * @param nomeEsame
	 * @param raccomandazioni
	 * @param luogo
	 * @param data
	 * @param ora
	 */
	public Esame (String nomeEsame, String raccomandazioni, String luogo, String data, String ora) {
		this.nomeEsame = nomeEsame;
		this.raccomandazioni = raccomandazioni;
		this.luogo = luogo;
		this.data = data;
		this.ora = ora;
	}	
	
	//	data	nomeEsame
	public String toSummary() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.indentation(data, CartellaSanitariaMain.LARGHEZZA_PRIMA_COLONNA));
		result.append(Formatting.centered(nomeEsame, CartellaSanitariaMain.LARGHEZZA_ALTRE_COLONNE));
		return result.toString();
	}
	
	/*
	 * SCHEDA ESAME
	 * Esame: ...
	 * Raccomandazioni: ...
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(TITOLO);
		result.append(String.format(DESCRIZIONE, nomeEsame, raccomandazioni));	// 	Aggiungere gli atri parametri
		return result.toString();
	}

	
}
