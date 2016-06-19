package it.unibs.ing.fp.medicalrecords;

/**
 * <h1> Class CartellaSanitaria </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 *
 */
public class CartellaSanitaria {
	private Paziente paziente;
	private ListaEsami listaEsami;
	
	public CartellaSanitaria(Paziente paziente, ListaEsami listaEsami) {
		this.paziente = paziente;
		this.listaEsami = listaEsami;
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
		
		return result.toString();
	}
}
