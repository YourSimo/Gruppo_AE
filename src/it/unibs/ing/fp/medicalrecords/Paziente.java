package it.unibs.ing.fp.medicalrecords;

/**
 * <h1> Class Paziente </h1>
 * <p>
 * @author Federico Avino
 *
 */
public class Paziente {
	private static final String TITOLO = "SCHEDA PAZIENTE";
	private static final String DESCRIZIONE = "Nome: %s%n, Cognome: %s%n, ...";		//	Aggiornare la Stringa
	
	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;
	private String email;
	private String dataNascita;
	private String luogoNascita;
	private String genere;
	private String codiceFiscale;
	private String codiceSanitario;
	private String gruppoSanguigno;
	
    /**
     * Construttore.
     * @param nome
     * @param cognome
     * @param indirizzo
     * @param telefono
     * @param email
     * @param dataNascita
     * @param luogoNascita
     * @param genere
     * @param codiceFiscale
     * @param codiceSanitario
     * @param gruppoSanguigno
     */
    public Paziente (String nome, String cognome, String indirizzo, String telefono, String email, String dataNascita, String luogoNascita, String genere, String codiceFiscale, String codiceSanitario, String gruppoSanguigno) {
    	this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.email = email;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.genere = genere;
		this.codiceFiscale = codiceFiscale;
		this.codiceSanitario = codiceSanitario;
		this.gruppoSanguigno = gruppoSanguigno;
    }
    
    /*
	 * SCHEDA PAZIENTE
	 * Nome: ...
	 * Cognome: ...
	 * ...
	 */
    public String toString() {
    	StringBuffer result = new StringBuffer();
    	result.append(TITOLO);
    	result.append(String.format(DESCRIZIONE, nome, cognome));	//	Aggiungere gli atri parametri
    	return result.toString();
    }
}
