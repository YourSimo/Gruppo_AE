package it.unibs.ing.fp.medicalrecords;

import java.io.Serializable;
import java.util.Random;
import java.util.regex.Pattern;

import it.unibs.ing.fp.library.InputData;

/**
 * <h1> Class Utility </h1>
 * <p>
 * @author Federico Avino
 * @author Matteo Bellicini
 * @author Simone Cavicchioli
 *
 */
public class Utility implements Serializable {
	//messaggi per richiedere inserimento dati
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

    
	private final static String MSG_ERRORE_INSERIMENTO_ALFABETO = "Errore nell'inserimento dati. La stringa inserita deve contenere solo lettere. Ritenti.";
	private final static String MSG_ERRORE_INSERIMENTO_INDIRIZZO = "Errore nell'inserimento dati. I dati inseriti devono essere nel formato aaaaaa aaaaaa,222. Ritenti";
	private final static String MSG_ERRORE_INSERIMENTO_TELEFONO = "Errore nell'inserimento dati. La stringa inserita deve contenere solo numeri. Ritenti";
	private final static String MSG_ERRORE_INSERIMENTO_EMAIL = "Errore nell'inserimento dati. La stringa deve essere nel formato aaaaaa.aaaaaa@aaaaa.aaa. Ritenti";
	private final static String MSG_ERRORE_INSERIMENTO_DATA_NASCITA = "Errore nell'inserimento dati. La stringa inserita deve essere nel formato gg/mm/aaaa. Ritenti";
	private final static String MSG_ERRORE_INSERIMENTO_CODICE_FISCALE = "Errore nell'inserimento dati. La stringa inserita deve rispettare la composizione del codice fiscale. Ritenti";

	
	//messaggi per esame
	
	private final static String MSG_ESAME = "Inserisca l'esame che vuole aggiungere:";		
	private final static String MSG_DATA = "Inserisca la data in cui è stato svolto (gg/mm/aaaa):";
	private final static String MSG_LUOGO = "Inserisca il luogo in cui è stato svolto:";
	private final static String MSG_ORA = "Inserisca l'orario in cui è stato svolto:";
	private final static String MSG_ESITO = "Inserisca l'esito dell'esame:";
	private final static String MSG_RACCOMANDAZIONI = "Inserisca le raccomandazioni per eseguire l'esame:";
	  
	private static final String MSG_ALTRI_ESAMI = "Inserire un altro esame in elenco?";
	
	private final static String MSG_ERRORE_INSERIMENTO = "Errore nell'inserimento dati. Dato non valido. Ritenti.";

	/*regular expressions, permettono di creare una sringa formata da 
	 * caratteri speciali che il computer interpreta appositamente. 
	 * Sono usate per verificare se delle stringhe rispettano un determinato
	 * formato specificato appunto grazie alla stringa formata dalle regex
	 * */
	//la regex dell'alfabeto verifica che la stringa si componga solo di lettere
	private final static String REGEX_ALFABETO = "^[a-zA-Z]+$";
	//la stringa dell'indirizzo deve essere fatta da caratteri spazio caratteri virgola numeri
	private final static String REGEX_INDIRIZZO = "^[a-zA-Z]+[\t\n\r\f][a-zA-Z]+[,][0-9]+$";//stringa spazio stringa virgola numeri
	//solo numeri
	private final static String REGEX_TELEFONO = "^[0-9]+$";
	//lettere o numeri chiocciola stringa o numeri punto e da due a 4 caratteri
	private final static String REGEX_EMAIL = "^[a-zA-Z0-9._%-]+[@][a-zA-Z0-9.-]+[.][a-zA-Z]{2,4}$";
	//numeri in formato gg/mm/aaaa 
	private final static String REGEX_DATA_NASCITA = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)[0-9]{2}";
	//la regex del luogo di nascita � alfabeto
	//composizione del codice fiscale rispettando numeri e lettere
	private final static String REGEX_CODICE_FISCALE = "[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]";

	private final static String REGEX_DATA = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)[0-9]{2}";
	private final static String REGEX_ORA = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01]){2}";
	
	//array di stringhe con cui confrontare il genere
	private final static String GENERE_ACCETTABILE [] = {"maschio", "m", "uomo",
														 "femmina", "f", "donna"};
	//array di stringhe con cui conforntare il gruppo sanguigno
	private final static String GRUPPO_SANGUIGNO_ACCETTABILE [] = {"Apositivo", "Bpositivo", "ABpositivo", "0positivo", "Anegativo", "Bnegativo", "ABnegativo", "0negativo",
																  	"Apos", "Bpos", "ABpos", "0pos", "Aneg", "Bneg", "ABneg", "0neg",
																  	"A+", "B+", "AB+", "0+", "A-", "B-", "AB-", "0-"};
	
	//arbitrria lunghezza stabilita x la stringa del codice sanitario
	private final static int LUNGHEZZA_CODICE_SANITARIO = 10;
	
	private final static String ESAME_MISURABILE[] = {"GLUCOSIO","GLICEMIA","COLESTEROLO"};
	
	
	
	public static CartellaSanitaria makeMedicalRecords() {
		return new CartellaSanitaria(makePatient(), makeExamList());
	}
	
	
	public static void addExam() {
		// TODO Auto-generated method stub
		
	}
	
	
	private static Paziente makePatient() {
		System.out.println(MSG_INTRO_INSERIMENTO);
		//************************************************
		String nome = InputData.readString(MSG_NOME);
		//si continua a richiedere l'inserimento fino a quando i dati non sono corretti
		while (convalidaNome(nome) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO_ALFABETO);
		    nome = null;
			nome = InputData.readString(MSG_NOME);	
		};
		//**************************************************
		String cognome = InputData.readString(MSG_COGNOME);
		
		while (convalidaCognome(cognome) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO_ALFABETO);
		    cognome = null;
			cognome = InputData.readString(MSG_COGNOME);	
		};
		//**************************************************
		String indirizzo = InputData.readString(MSG_INDIRIZZO);
		
		while (convalidaIndirizzo(indirizzo) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO_INDIRIZZO);
		    indirizzo = null;
			indirizzo = InputData.readString(MSG_INDIRIZZO);	
		};
		//***************************************************
		String telefono = InputData.readString(MSG_TELEFONO);

		while (convalidaTelefono(telefono) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO_TELEFONO);
		    telefono = null;
			telefono = InputData.readString(MSG_TELEFONO);	
		};
		//******************************************************
		String email = InputData.readString(MSG_EMAIL);
		
		while (convalidaEmail(email) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO_EMAIL);
		    email = null;
			email = InputData.readString(MSG_EMAIL);	
		};
		//********************************************************
		String dataNascita = InputData.readString(MSG_DATA_NASCITA);
		
		while (convalidaDataNascita(dataNascita) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO_DATA_NASCITA);
		    dataNascita = null;
			dataNascita = InputData.readString(MSG_DATA_NASCITA);	
		};
		//**********************************************************
		String luogoNascita = InputData.readString(MSG_LUOGO_NASCITA);
		
		while (convalidaLuogoNascita(luogoNascita) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO_ALFABETO);
		    luogoNascita = null;
			luogoNascita = InputData.readString(MSG_LUOGO_NASCITA);	
		};
		//**********************************************************
		String genere = InputData.readString(MSG_GENERE);
		
		while (convalidaGenere(genere) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    genere = null;
			genere = InputData.readString(MSG_GENERE);	
		};
		//**********************************************************
		String codiceFiscale = InputData.readString(MSG_CODICE_FISCALE);
		
		while (convalidaCodiceFiscale(codiceFiscale) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO_CODICE_FISCALE);
		    codiceFiscale = null;
			codiceFiscale = InputData.readString(MSG_CODICE_FISCALE);	
		};
		//**********************************************************
		String gruppoSanguigno = InputData.readString(MSG_GRUPPO_SANGUIGNO);

		while (convalidaGruppoSanguigno(gruppoSanguigno) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO);
			gruppoSanguigno = null;
			gruppoSanguigno = InputData.readString(MSG_GRUPPO_SANGUIGNO);	
		};
		//**********************************************************
		String codiceSanitario = generaCodiceSanitario();
		
	    //con i dati inseriti si crea un oggetto Paziente
		return new Paziente(nome, cognome, indirizzo, telefono, email, dataNascita, luogoNascita, genere, codiceFiscale, codiceSanitario, gruppoSanguigno);
	}
	
	
	private static ListaEsami makeExamList() {
		ListaEsami listaEsami = new ListaEsami();
		do {
			Esame nuovoEsame = makeExam(esame);
			listaEsami.addExam(nuovoEsame);
		} while (InputData.yesOrNo(MSG_ALTRI_ESAMI));
		
		return listaEsami;
	}

	
	private static Esame makeExam(String esame) {
		//verifica esame
		
		
		//verifica data
		
		String data = InputData.readString(MSG_DATA);
		
		while (convalidaData(data) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    data = null;
			data = InputData.readString(MSG_DATA);	
		};
		//verifica luogo
		
		String luogo = InputData.readString(MSG_LUOGO);
		
		while (convalidaLuogo(luogo) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    luogo = null;
			luogo = InputData.readString(MSG_LUOGO);	
		};
		//verifica ora
		
		String ora = InputData.readString (MSG_ORA);

		while (convalidaOra(ora) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    ora = null;
			ora = InputData.readString(MSG_ORA);	
		};
		//verifica esito
		
		String esito = InputData.readString (MSG_ESITO);
		
		while (convalidaEsito(esito) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    esito = null;
			esito = InputData.readString(MSG_ESITO);	
		};
		String raccomandazioni = InputData.readString (MSG_RACCOMANDAZIONI);
		
		while (convalidaRaccomandazioni(raccomandazioni) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    raccomandazioni = null;
			raccomandazioni = InputData.readString(MSG_RACCOMANDAZIONI);	
		};
		return new Esame (esame, luogo, data, ora, esito, raccomandazioni); 
	}
	
	private EsameMisurabile makeMeasurableExam (String esame){
		String valore = InputData.readString(MSG_TELEFONO);

		while (convalidaTelefono(valore) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO_TELEFONO);
		    valore = null;
			valore = InputData.readString(MSG_TELEFONO);
			
			return (makeExam(esame), valore);
		};
		
		
		
	}
	
	//	Metodi Validità
	
	private static boolean convalidaRaccomandazioni(String raccomandazioni) {
		if (Pattern.matches(REGEX_ALFABETO, raccomandazioni)) return true;
		else return false;
	}
	
	private static boolean convalidaEsito(String esito) {
		if (Pattern.matches(REGEX_ALFABETO, esito)) return true;
		else return false;
	}
	
	private static boolean convalidaOra(String ora) {
		if (Pattern.matches(REGEX_ORA, ora)) return true;
		else return false;
	}
	
	private static boolean convalidaLuogo(String luogo) {
		if (Pattern.matches(REGEX_ALFABETO, luogo)) return true;
		else return false;
	}
	
	private static boolean convalidaData(String data) {
		if (Pattern.matches(REGEX_DATA, data)) return true;
		else return false;
	}
	
	private static boolean convalidaEsame(String esame) {
		if (Pattern.matches(REGEX_ALFABETO, esame)) return true;
		else return false;	
	}
	
	public static boolean convalidaNome(String nome) {
    	if (Pattern.matches(REGEX_ALFABETO, nome)) return true;
    	else return false;
    }
    
	private static boolean convalidaCognome(String cognome) {
		return convalidaNome(cognome);
	}
	
	private static boolean convalidaIndirizzo(String indirizzo) {
		if (Pattern.matches(REGEX_INDIRIZZO, indirizzo)) return true;
    	else return false;
	}
	
	public static boolean convalidaTelefono(String telefono) {
		if (Pattern.matches(REGEX_TELEFONO, telefono)) return true;
    	else return false;
	}
	
	private static boolean convalidaEmail(String email) { 
		if (Pattern.matches(REGEX_EMAIL, email)) return true;
    	else return false;
	}
	
	private static boolean convalidaDataNascita(String dataNascita) {
		if (Pattern.matches(REGEX_DATA_NASCITA, dataNascita)) return true;
		else return false;

	}
	
	private static boolean convalidaLuogoNascita(String luogoNascita) {
		if (Pattern.matches(REGEX_ALFABETO, luogoNascita)) return true;
		else return false;
	}

	private static boolean convalidaGenere(String genere) {
		for ( int i = 0; i <GENERE_ACCETTABILE.length; i++)
			if (genere.equalsIgnoreCase(GENERE_ACCETTABILE[i])) return true;	
		return false;
	}

	private static boolean convalidaCodiceFiscale(String codiceFiscale) {
		if (Pattern.matches(REGEX_CODICE_FISCALE, codiceFiscale)) return true;
		else return false;
	}

	private static boolean convalidaGruppoSanguigno(String gruppoSanguigno) {
		//si crea una nuova stringa senza gli spazi
		String strOut = gruppoSanguigno.replaceAll ("\\s+$", "");
		for ( int i = 0; i <GRUPPO_SANGUIGNO_ACCETTABILE.length; i++)
			if (strOut.equalsIgnoreCase(GRUPPO_SANGUIGNO_ACCETTABILE[i])) return true;	
		return false;
	}
	
	private static String generaCodiceSanitario() {
		return randomString(LUNGHEZZA_CODICE_SANITARIO);	
	}
	
	//	genera stringa random formata da lettere e numeri e lunga 10 caratteri
	private static String randomString(int length) {
		Random rnd = new Random ();	//	creazione oggetto classe random
		
		char[] arr = new char[length];	//	array di caratteri di lunghezza length
		//si scorre l'array
		for (int i=0; i<length; i++) {
			int n = rnd.nextInt (36);	//	si assegna ad n un numero casuale generato tra 0 e 36
			arr[i] = (char) (n < 10 ? '0'+n : 'a'+n-10);	//	all'isesimo elemento dell'array si mette un numero se n è minore di dieci, o una lettera se n è maggiore
		}
		return new String(arr);	//	l'array è trasformato in stringa e viene restituita
	}
	
	public static void sceltaCostruttoreEsame(){
		String esame = InputData.readString(MSG_ESAME);
		while (convalidaEsame(esame) == false) {
			System.out.println(MSG_ERRORE_INSERIMENTO);
		    esame = null;
			esame = InputData.readString(MSG_ESAME);	
		};
		for ( int i = 0; i <ESAME_MISURABILE.length; i++)
			if (esame.equalsIgnoreCase(ESAME_MISURABILE[i])) makeMeasurableExam(esame);
			else makeExam(esame);
		
	}
	
}
