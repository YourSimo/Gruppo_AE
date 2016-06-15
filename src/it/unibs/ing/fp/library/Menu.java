package it.unibs.ing.fp.library;

/**
 * <h1> Class Menu </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v2.0
 * @since 2016-04-26
 */

public class Menu {
	final private static String FRAME = "--------------------------------";
	final private static String OUTRO = "0\tEsci";
	final private static String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata > ";

	private String title;
	private String [] options;

	/**
	 * Constructor.
	 * @param title - The description of the menu
	 * @param options - The list of options
	 */	
	public Menu(String title, String [] options) {
		this.title = title;
		this.options = options;
	}

	/**
	 * Prints the Menu with title and list of options.
	 */
	public void printMenu() {
		System.out.println(FRAME);
		System.out.println(title);
		System.out.println(FRAME);
	    for (int i = 0; i < options.length; i++) {
	    	System.out.println((i + 1) + "\t" + options[i]);
		}
	    System.out.println();
		System.out.println(OUTRO);
	    System.out.println();
  	}
	
	/**
	 * Returns the user's choice from the list of options.
	 * @return a int number between 0 and the number of options
	 */
	public int choice() {
		printMenu();
		return InputData.readIntWithLimit(RICHIESTA_INSERIMENTO, 0, options.length);	 
  	}
}
