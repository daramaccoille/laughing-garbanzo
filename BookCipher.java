/**
 * 
 */
package Revision;

/**
 * @author Dara Mac Coille
 * @version 30/12/2023
 */
public class BookCipher {

	/**
	 * @param args for main method
	 */
	public static void main(String[] args) {
		// 2D array of strings with hidden message
		String message[][] = { { "Buzz", "LightYear", "was" }, { "once", "apon", "a" }, { "time", "probably", "the " },
				{ "coolest", "character", "in", "Toy", "Story 2" }, { "but ", "Woody " },
				{ "was ", "always ", "Andy's ", "wow" }, { "toy.", "i" }, { "was", "never", "keen" },
				{ "because ", "I ", "don't " }, { "rate", "Tom", "Hanks.", "Woody ", "is", "quite", "dour" },
				{ "but", " Lightyear,", "could fly, sort of...", "Anyhow" }, { "the", "movies", "are", "classic" } };
		char[] endChars = new char[message.length];
		for (int row = 0; row < message.length; row++) {
			// unreadable mess below lol
			String word = message[row][message[row].length-1];
			
			endChars[row]=word.charAt(word.length()-1);
			
		}System.out.println(new String(endChars).toUpperCase());
	}

}
