/**
 * 
 */
package Revision;
/**
 * @author Dara Mac Coille
 * @version 30/10/2023
 *
 */
public class MarsAttacks {

	/**
	 * @param args for main method
	 */
	public static void main(String[] args) {
		// The message

		String[] message = { "FBI Report on UFOs", "We believe UFOs do visit our planet.",

				"Many cows have been abducted in Roswell New Mexico USA", "Several reports of Aliens have been made",

				"We think they come from Mars", "The FBI are concerned about public panic", "Strictly confidential",

				"For your eyes only Mr President", "God help us all and God bless America", "End of message..." };

		// the words that will be redacted
		String[] wordsToRedact = { "FBI", "UFO", "UFOs", "Roswell", "Cow", "Cows", "Abducted", "Mars", "Alien",
				"Aliens", "President", "America" };

		// parse the sentence into words
		for (int line = 0; line < message.length; line++) {

			String[] words = new String[message.length];
			words = message[line].split(" ");
			for (int i = 0; i < words.length; i++) {
				for (String redactWord : wordsToRedact) {
					if (redactWord.equalsIgnoreCase(words[i])) {
						words[i] = redactWords(words[i]);
					}
				}
				System.out.print(words[i] + " ");
			}
			System.out.println();
		}
	}
/**
 * redactWords takes a String and returns blank placeholders
 * instead of the word's characters. Might need to change
 * "Window Preferences General Workspace Text File Encoding to UTF8"
 * @param word is a String from the message that might get redacted
 * @return the stringbuilder representation of the placeholder characters
 */
	public static String redactWords(String word) {
		String[] letters = new String[word.length()];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = "\u2588";
		}
		StringBuilder s = new StringBuilder();
		for (String string : letters) {
			s.append(string);
		}
		return s.toString();
	}
}
