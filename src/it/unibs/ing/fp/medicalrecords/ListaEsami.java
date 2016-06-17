package it.unibs.ing.fp.medicalrecords;

import java.util.Vector;

public class ListaEsami {
	private Vector <Esame> listaEsami;
	
	public ListaEsami(){
		listaEsami = new Vector <Esame> ();	
	}
	
	//	metodi per aggiunta rimozione controllo
	
	public void addExam(Esame esame){
		 listaEsami.add(esame);
	}
	
	public Esame getExam(int i) {
		return listaEsami.get(i); 
	}
	
	public void removeExam(Esame esame) {
		 listaEsami.remove(esame);
	}
	
	public int getSize() {
		 return listaEsami.size();	 
	}
	
	public boolean isEmpty() {
		return listaEsami.isEmpty();
	}
}
