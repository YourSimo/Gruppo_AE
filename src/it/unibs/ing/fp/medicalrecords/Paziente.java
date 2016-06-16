package it.unibs.ing.fp.medicalrecords;

public class Paziente {
	
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
	
	
	private final static String MSG_INTRO_INSERIMENTO = "Benvenuto. Di seguito potrà inserire i dati personali per la sua cartella medica; tutti i campi sono obbligatori";
	private final static String MSG_NOME = "Inserisca il proprio nome:";
	private final static String MSG_COGNOME = "Inserisca il proprio cognome:";
	private final static String MSG_INDIRIZZO = "Inserisca il proprio indirizzo:";
	private final static String MSG_TELEFONO = "Inserisca il proprio numero di telefono";
	private final static String MSG_EMAIL = "Inserisca la propria email:";
	private final static String MSG_DATA_NASCITA = "Inserisca la propria data di nascita:";
	private final static String MSG_LUOGO_NASCITA = "Inserisca il proprio luogo di nascita:";
	private final static String MSG_GENERE =  "Inserisca il proprio genere:";
	private final static String MSG_CODICE_FISCALE = "Inserisca il proprio codice fiscale";
	private final static String MSG_GRUPPO_SANGUIGNO = "Inserisca il proprio gruppo sanguigno";
    
    //costruttore classe Paziente
    public Paziente (String nome, String cognome, String indirizzo, String telefono, String email, String dataNascita, String luogoNascita, String genere, String codiceFiscale, String codiceSanitario, String gruppoSanguigno){
		
    	this.nome=nome;
		this.cognome=cognome;
		this.indirizzo=indirizzo;
		this.telefono= telefono;
		this.email=email;
		this.dataNascita=dataNascita;
		this.luogoNascita=luogoNascita;
		this.genere=genere;
		this.codiceFiscale=codiceFiscale;
		this.codiceSanitario=codiceSanitario;
		this.gruppoSanguigno=gruppoSanguigno;
		
    }
    
    
    private static Paziente creaPaziente() throws Exception
	{
		System.out.println(MSG_INTRO_INSERIMENTO);
		String nome = InputDati.leggiStringa(MSG_NOME);
		String cognome = InputDati.leggiStringa(MSG_COGNOME);
		String indirizzo = InputDati.leggiStringa(MSG_INDIRIZZO);
		String telefono = InputDati.leggiStringa (MSG_TELEFONO);
		String email = InputDati.leggiStringa (MSG_EMAIL);
		String dataNascita = InputDati.leggiStringa (MSG_DATA_NASCITA);
		String luogoNascita = InputDati.leggiStringa (MSG_LUOGO_NASCITA);
		String genere = InputDati.leggiStringa (MSG_GENERE);
		String codiceFiscale = InputDati.leggiStringa (MSG_CODICE_FISCALE);
		//codice sanitario
		
		//controllo validità dati
		String gruppoSanguigno = InputDati.leggiStringa (MSG_GRUPPO_SANGUIGNO);
		
		
		
		
		
		
		
		
		
		return new Paziente (String nome, String cognome, String indirizzo, String telefono, String email, String dataNascita, String luogoNascita, String genere, String codiceFiscale, String codiceSanitario, String gruppoSanguigno);
	}
    
    
    //necessario importare la classe InputDati, da mettere in MyLib??? è presa 
    //da una esercitazione 
    
    

}
