package it.unibs.ing.fp.medicalrecords;

/**
 * <h1> Class Utility </h1>
 * <p>
 * @author Simone Cavicchioli
 *
 */
public class Utility {
	/*
	 * Paziente: Cognome Nome
	 * Esami:
	 * Data			Nome	 		Valore	
	 * ...
	 * ...
	 * ...
	 */
	public void visualizzazioneSintetica() {
		
	}
	
	/*
	 * SCHEDA PAZIENTE:
	 * Nome: ...
	 * Cognome: ...
	 * ...
	 */
	public void schedaPaziente(Paziente paziente) {
		paziente.toString();
	}
	
	/*
	 * SCHEDA ESAME:
	 * Esame: ...
	 * Raccomandazioni: ...
	 */
	public void schedaEsame(Esame esame) {
		esame.toString();
	}
}
