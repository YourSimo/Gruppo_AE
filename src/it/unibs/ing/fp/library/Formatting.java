package it.unibs.ing.fp.library;

/**
 * <h1> Class Formatting </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v2.0
 * @since 2016-05-10
 */

public class Formatting {
	private static final String ERR_NEGATIVE_VALUE = "Attenzione il valore inserito è negativo o uguale a 0!\n";
	
	private static final String SPACE = " ";
	private static final String FRAME = "-";
	private static final String HEAD = "\n";
	

	/**
	 * Returns a String isolated. <p>
	 * Example:
	 * <blockquote><pre>
	 * (space)
	 * String
	 * (space)
	 * </pre></blockquote>
	 * 
	 * @param s - The String to isolate
	 * @return a String isolated 
	 */
	public static String rowIsolated(String s) {
		StringBuffer result = new StringBuffer();
		 result.append(HEAD);
		 result.append(s);
		 result.append(HEAD);
		 return result.toString();
	}
	
	/**
	 * Returns a String framed. <p>
	 * Example:
	 * <blockquote><pre>
	 * ------
	 * String
	 * ------
	 * </pre></blockquote>
	 * 
	 * @param s - The String to frame
	 * @return a String framed
	 */
	public static String framing(String s) {
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < s.length(); i++) result.append(FRAME);
		result.append(HEAD + s + HEAD);
		for(int i = 0; i < s.length(); i++) result.append(FRAME);
		result.append(HEAD);
		return result.toString();
	}

	/**
	 * Returns a String in column. <p>
     * Examples:
     * <blockquote><pre>
     * inColumn("test", 2) returns "test"
     * inColumn("value", 7) returns "value  "
     * inColumn("", 5) return ""
     * </pre></blockquote>
     * 
	 * @param s - The String to be placed in column
	 * @param width - The width of column
	 * @return a String in column
	 * @exception  IllegalArgumentException  if {@code width} is negative or equals 0.
	 */
	public static String inColumn(String s, int width) {
		if(width <= 0) throw new IllegalArgumentException(ERR_NEGATIVE_VALUE);
		else {
			StringBuffer result = new StringBuffer(width);
			int numCharToPrint = Math.min(s.length(), width);
			result.append(s.substring(0, numCharToPrint));
			for (int i = s.length() + 1; i <= width; i++) result.append(SPACE);
			return result.toString();
		}
	}
	
	/**
	 * Returns a String indentation.
	 * @param s - The String indentation
	 * @param width - The width of indentation
	 * @return a String indentation
	 */
	public static String indentation(String s, int width) {
		if(width <= 0) throw new IllegalArgumentException(ERR_NEGATIVE_VALUE);
		else {
			StringBuffer result = new StringBuffer(s.length() + width);
			for (int i = 0; i < width; i++) result.append(SPACE);
			result.append(s);
			return result.toString();
		}
	}
	
	/**
	 * Returns a String centered.
	 * Examples:
     * <blockquote><pre>
     * centered("test", 2) returns "te"
     * centered("qtà" 4) returns "qtà "
     * centered("math", 6) returns " math "
     * centered("value", 7) returns " value "
     * centered("", 5) return ""
     * </pre></blockquote>
     * 
	 * @param s - The String to be placed in center
	 * @param width - The width of column
	 * @return a String centered
	 */
	public static String centered(String s, int width) {
		if(width <= 0) throw new IllegalArgumentException(ERR_NEGATIVE_VALUE);
		else {
			StringBuffer result = new StringBuffer(width);
			if(width <= s.length()) result.append(s.substring(width));
			else {
				int spaceAfter = (width - s.length())/2;
				int spaceBefore = width - spaceAfter - s.length();
				for (int i = 1; i <= spaceBefore; i++) result.append(SPACE);
				result.append(s);	
				for (int i = 1; i <= spaceAfter; i++) result.append(SPACE);
			}
			return result.toString();
		}
	}
	
	/**
	 * Returns a String of cloned characters.
	 * @param c - The Char to clone
	 * @param width - The number of characters to clone
	 * @return a String of cloned characters
	 */
	public static String cloneChar(char c, int width) {
		if(width <= 0) throw new IllegalArgumentException(ERR_NEGATIVE_VALUE);
		else {
			StringBuffer result = new StringBuffer(width);
			for (int i = 0; i < width; i++) result.append(c);
			return result.toString();
		}
	}
}
