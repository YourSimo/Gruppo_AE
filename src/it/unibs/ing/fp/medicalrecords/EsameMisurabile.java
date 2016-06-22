package it.unibs.ing.fp.medicalrecords;

import java.io.Serializable;

public class EsameMisurabile extends Esame implements Serializable {
	
	public final static int MIN_GLICEMIA = 60;
	public final static int MAX_GLICEMIA = 99;
	private final static int MIN_GLUCOSIO = 60;
	private final static int MAX_GLUCOSIO = 109;
	private final static int MIN_COLESTEROLO = 0;
	private final static int MAX_COLESTEROLO=  200;
	
	//	MANCO IL COSTRUTTORE
	
	//verifica inserimento valore valido
	public static boolean valoreValido (int valore, int min, int max){
		if (valore < min && valore > max) return false;
		return true;	
	}
}
