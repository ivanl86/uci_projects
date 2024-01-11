package labs.lab1;

import java.util.ArrayList;

/**
 * This class models a simple letter.
 */
public class Letter {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String sender;
	private String recipient;
	private ArrayList<String> text;
	/**
	 * Constructs a letter with a given sender and recipient.
	 * 
	 * @param from the sender
	 * @param to   the recipient
	 */
	public Letter(String from, String to) {
		// FILL IN
		sender = from;
		recipient = to;
		text = new ArrayList<String>();
	}

	/**
	 * Adds a line to the end of the body of this letter
	 * 
	 * @param	line	line to add
	 */
	public void addLine(String line) {
		// FILL IN
		text.add(line);
	}

	/**
	 * Gets the entire text of this letter
	 * 
	 * @return	the entire text of this letter
	 */
	public String getText() {
		StringBuilder textBlock = new StringBuilder();
		textBlock.append("Dear " + recipient + ":");
		textBlock.append("\n\n");
		
		for (int i = 0; i < text.size(); ++i) {
			textBlock.append(text.get(i) + "\n");
		}

		if (text.size() > 0)
			textBlock.append("\n");
		
		textBlock.append("Sincerely,");
		textBlock.append("\n\n");
		textBlock.append(sender);
		return textBlock.toString(); // FIX ME
	}
}
