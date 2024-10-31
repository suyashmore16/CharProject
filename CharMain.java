import javax.swing.*;
import BreezySwing.*;
/**
 * 
 */

/**
 * @author 22smore
 *
 */
public class CharMain extends GBFrame{

	/**
	 * @param args
	 */
	JLabel inputSentence = addLabel("Input Sentence:" , 1, 1, 1, 1);
	JButton inputButton = addButton ("Input", 3, 1, 1, 1);
	JTextArea inputField  = addTextArea ("", 2,1,1,1);
	public void buttonClicked(JButton buttonObj) {
		if(buttonObj == inputButton) {
			CharMain MainObj = new CharMain();
			CharSort sortObj = new CharSort();
			String sentence = inputField.getText();
			String charArr = sortObj.charArrayCreation(sentence);
			int charCount = charArr.length();
			String[] wordArr = sortObj.wordArray(sentence);
			int wordCount = 0;
			for(int i = 0; i < wordArr.length; i++) {
				if(wordArr[i] != null) {
					wordCount = i;
				}
			}
			wordCount = wordCount + 1;
			String outputString = "";
			sentence.trim();
			if ((Character.isWhitespace(sentence.charAt(sentence.length()-1))== false) && (Character.isLetter(sentence.charAt(sentence.length()-1)) == false && Character.isDigit((sentence.charAt(sentence.length()-1)))== false)) {
				sentence = sentence.substring(0, sentence.length()-1);
			}
			String[] newwordArr = sortObj.deleteDuplicates(wordArr);
			int[] wordFinder = sortObj.wordCount(wordArr);
			for(int i = 0; i < wordArr.length; i++) {
	            if(wordArr[i] != null) {
	                wordArr[i] = wordArr[i].substring(0,1).toUpperCase() + wordArr[i].substring(1).toLowerCase();                
	                }
	        }
			for(int i = 0; i < wordArr.length; i++) {
	            if(wordArr[i] != null) {
	                outputString += wordArr[i] + ": " + sortObj.wordCount(wordArr)[i] + '\n' + " ";
	            }
	        }
			messageBox(" " + sentence + '\n' + " Character count: " + charCount + '\n' + " Word count: " + wordCount + '\n' + " " + outputString ,300,300);
			for(int i = 1; i < newwordArr.length; i++) {
				if (newwordArr[i] != null) {
						System.out.print(newwordArr[i] + " ");
						System.out.print(wordFinder[i]);
						System.out.println();
				}

			}
		}
	}
	public static void main(String[] args) {

	     JFrame frm = new CharMain();
	      frm.setSize (300, 300);
	      frm.setTitle ("Char Program");
	      frm.setVisible (true);   
	      
	}
}

