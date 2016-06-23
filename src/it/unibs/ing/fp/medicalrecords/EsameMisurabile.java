package it.unibs.ing.fp.medicalrecords;

import java.io.Serializable;
import it.unibs.ing.fp.library.Formatting;

/**
 * <h1> Class EsameMisurabile </h1>
 * 
 * @author Matteo Bellicini
 *
 */
public class EsameMisurabile extends Esame implements Serializable {
	private static final String TITOLO = "SCHEDA ESAME MISURABILE";
	private static final String DESCRIZIONE = "Esame: %s%n"
											+ "Raccomandazioni: %s%n"
											+ "Luogo: %s%n"
											+ "Data: %s%n"
											+ "Ora: %s%n"
											+ "Esito: %s%n"
											+ "Valore: %s%n";	
	
	public final static int MIN_GLICEMIA = 60;
	public final static int MAX_GLICEMIA = 99;
	public final static int MIN_GLUCOSIO = 60;
	public final static int MAX_GLUCOSIO = 109;
	public final static int MIN_COLESTEROLO = 0;
	public final static int MAX_COLESTEROLO = 200;
	
	private int valore;
	
	public EsameMisurabile(String esame, String luogo, String data, String ora, String raccomandazioni, String esito, int valore) {
		super(esame, luogo, data, ora, raccomandazioni, esito);
		this.valore = valore;
	}
	
	public EsameMisurabile(Esame esame, int valore) {
		super(esame.esame, esame.luogo, esame.data, esame.ora, esame.raccomandazioni, esame.esito);
		this.valore = valore;
	
	}
	
	//verifica inserimento valore valido
	public boolean valoreValido (int min, int max){
		if (valore < min && valore > max) 
			return false;
		return true;
	}
	
	//	data	nomeEsame	valore
	public String toSummary() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.indentation(data, CartellaSanitariaMain.LARGHEZZA_PRIMA_COLONNA));
		result.append(Formatting.centered(esame, CartellaSanitariaMain.LARGHEZZA_ALTRE_COLONNE));
		result.append(Formatting.centered(String.valueOf(valore), CartellaSanitariaMain.LARGHEZZA_ALTRE_COLONNE));
		return result.toString();
	}
	
	/*
	 * SCHEDA ESAME MISURABILE
	 * Esame: ...
	 * Raccomandazioni: ...
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(TITOLO);
		result.append(String.format(DESCRIZIONE, esame, raccomandazioni, luogo, data, ora, esito, valore));
		return result.toString();
	}
}