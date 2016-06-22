package it.unibs.ing.fp.medicalrecords;

import java.io.Serializable;

public class EsameMisurabile extends Esame implements Serializable {
	
	
	private static final String TITOLO = "SCHEDA ESAME MISURABILE";
	private static final String DESCRIZIONE = "Esame: %s%n, "
											+ "Raccomandazioni: %s%n,"
											+ "Luogo: %s%n,"
											+ "Data: %s%n,"
											+ "Ora: %s%n,"
											+ "Esito: %s%n,"
											+ "Valore:%s%n,";	
	
	
	
	public final static int MIN_GLICEMIA = 60;
	public final static int MAX_GLICEMIA = 99;
	private final static int MIN_GLUCOSIO = 60;
	private final static int MAX_GLUCOSIO = 109;
	private final static int MIN_COLESTEROLO = 0;
	private final static int MAX_COLESTEROLO=  200;
	
	private int valore;
	
	public EsameMisurabile(String esame, String luogo, String data, String ora, String raccomandazioni, String esito, int valore) {
		super(esame, luogo, data, ora, raccomandazioni, esito);
		this.valore = valore;
	}
	
	//verifica inserimento valore valido

	public static boolean valoreValido (int valore, int min,int max  ){
		if (valore<min && valore>max) 
			return false;
		 
		
		return true;

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(TITOLO);
		result.append(String.format(DESCRIZIONE, esame, raccomandazioni, luogo, data, ora, esito, valore));
		return result.toString();

}
}