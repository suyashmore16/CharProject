/**
 * 
 */

/**
 * @author 22smore
 *
 */
public class CharSort {
	public int charCount(char[] ch) {
		int charCount = ch.length;
		return charCount;
	}
	public String charArrayCreation(String str) {
		String charArray = "";
		for(int i = 0; i < str.length(); i++) {
			if (i < str.length()-1) {
				if(Character.isWhitespace(str.charAt(i)) == false) {
					charArray+=str.charAt(i);
				}
			}
			if (i == str.length()-1){
				if((Character.isDigit(str.charAt(i))) || (Character.isLetter(str.charAt(i)))) {
					charArray += str.charAt(i);
				}
			}
		}
		charArray.trim();
		return charArray;
	}
	public String[] wordArray(String sentence) {
		int[] spaceIndices = new int [sentence.length()];
		String[] wordArr = new String [sentence.length()];	
		int highestIndice = 0;
		int spaceIndex = 0;
		int wordCount = 0;
		for(int i = 0; i < sentence.length(); i++) {
			if (sentence.indexOf(" ", i) == i) {
				spaceIndices[spaceIndex] = sentence.indexOf(" ", i);
	 			spaceIndex++;
			}
		}
		for (int count = 0; count < spaceIndices.length; count++) {
			if (spaceIndices[count] == 0) {
				break;
			}
				highestIndice = count;
		}
		for(int count = 0; count < sentence.length(); count++) {

			if(count == 0) {
				wordArr[wordCount] = sentence.substring(0, spaceIndices[0]);
			} else if (spaceIndices[count-1] == spaceIndices[highestIndice]){
				wordArr[wordCount] = sentence.substring(spaceIndices[highestIndice]);
			} else {
				wordArr[wordCount] = sentence.substring(spaceIndices[count-1], spaceIndices[count]);
			}
			wordArr[wordCount] = wordArr[wordCount].trim();
			wordCount++;			
			if (spaceIndices[count] == 0) {
				break;
			}
		}
		return wordArr;
		
	}
	public int[] wordCount(String[] wordArray) {
		int[] wordCount = new int [wordArray.length];
		int highestIndice = 0;
		for (int count = 0; count < wordArray.length; count++) {
			if (wordArray[count] == null) {
				break;
			}
				highestIndice = count;
		}
		for(int count = 0; count <= highestIndice; count++) {
			wordCount[count] = 0;
			for(int i = highestIndice; i >= 0; i--) {
				if (wordArray[i].equalsIgnoreCase(wordArray[count])) {
					wordCount[count]++;
				}
			}
		}
		return wordCount;
	}
	public String[] deleteDuplicates(String[] wordArray) {
		String[] newArr = new String[wordArray.length];
		int highestIndice = 0;
		int newCount = 0;
		int[] stringIndices = new int[wordArray.length];
		for (int count = 0; count < wordArray.length; count++) {
			if (wordArray[count] == null) {
				break;
			}
				highestIndice = count;
		}
		for(int count = 0; count <= highestIndice; count++) {
			for(int i = 0; i < highestIndice; i++) {
				if(wordArray[count].equals(wordArray[i])) {
					if(stringIndices[i] == 0) {
						newArr[newCount] = wordArray[count];
					}
				} else {
					newArr[newCount] = wordArray[count];
				}
		}
			newCount++;
		}
		return newArr;
	}
}
