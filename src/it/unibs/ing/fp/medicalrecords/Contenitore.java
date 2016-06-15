package it.unibs.ing.fp.medicalrecords;

import java.io.Serializable;

/**
 * <h1> Class Contenitore </h1>
 * <p>
 * @author Simone Cavicchioli
 *
 */
public class Contenitore implements Serializable {
	private ListaEsami listaEsami;
	private CartellaSanitaria cartellaSanitaria;
		
	public Contenitore (ListaEsami listaEsami, CartellaSanitaria cartellaSanitaria) {
		this.listaEsami = listaEsami;
		this.cartellaSanitaria = cartellaSanitaria;
	}
		
	public ListaEsami getListaEsami() {
		return listaEsami;
	}
	
	public CartellaSanitaria getCartellaSanitaria() {
		return cartellaSanitaria;
	}
}
