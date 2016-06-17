package it.unibs.ing.fp.medicalrecords;

import java.util.Vector;

public class ListaEsami {

	private Vector <String> listaEsami;
	
	public ListaEsami(){
		listaEsami=new Vector <String> ();
		
	}
	//metodi per aggiunta rimozione controllo
	public void addString(String nomeEsame){
		 listaEsami.add(nomeEsame);
	
	 }
	
	 public String getString(int i){
		 return listaEsami.get(i);
	 
	 }
	
	 public void removeString(int i){
		 listaEsami.remove(i);
	
	 }
	
	 public int getSize(){
		 return listaEsami.size();
		 
	 }
	
	
}
