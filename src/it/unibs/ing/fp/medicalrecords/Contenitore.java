package it.unibs.ing.fp.medicalrecords;

import java.io.Serializable;

/**
 * <h1> Class Contenitore </h1>
 * <p>
 * @author Simone Cavicchioli
 *
 */
public class Contenitore implements Serializable {
	private Paziente paziente;
	private ListaEsami listaEsami;
		
	public Contenitore (Paziente paziente, ListaEsami listaEsami) {
		this.paziente = paziente;
		this.listaEsami = listaEsami;		
	}
		
	public Paziente getPaziente() {
		return paziente;
	}
		
	public ListaEsami getListaEsami() {
		return listaEsami;
	}

}
