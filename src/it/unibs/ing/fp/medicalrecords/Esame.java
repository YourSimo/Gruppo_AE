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
	private static final String DESCRIZIONE = "Esame:           %s%n"
											+ "Luogo:           %s%n"
											+ "Data:            %s%n"
											+ "Ora:             %s%n"
											+ "Raccomandazioni: %s%n"
											+ "Esito:           %s%n";	
	
	protected String esame;
	protected String luogo;
	protected String data;
	protected String ora;
	protected String raccomandazioni;
	protected String esito;	
	
	/**
	 * Costruttore.
	 * @param esame
	 * @param luogo
	 * @param data
	 * @param ora
	 * @param raccomandazioni
	 * @param esito
	 */
	public Esame(String esame, String luogo, String data, String ora, String raccomandazioni, String esito) {
		this.esame = esame;
		this.raccomandazioni = raccomandazioni;
		this.luogo = luogo;
		this.data = data;
		this.ora = ora;
		this.esito = esito;
	}

	//	data	nomeEsame
	public String toSummary() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.indentation(data, CartellaSanitariaMain.LARGHEZZA_PRIMA_COLONNA));
		result.append(Formatting.centered(esame, CartellaSanitariaMain.LARGHEZZA_ALTRE_COLONNE));
		return result.toString();
	}
	
	/* ------------
	 * SCHEDA ESAME
	 * ------------
	 * Esame:           ...
	 * Raccomandazioni: ...
	 * ...
	 * ------------
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.framing(TITOLO));
		result.append(String.format(DESCRIZIONE, esame, luogo, data, ora, raccomandazioni, esito));
		result.append(Formatting.cloneChar('-', TITOLO.length()));
		return result.toString();
	}
}
