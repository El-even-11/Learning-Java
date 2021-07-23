package detectCapital;

public class DetectCapital {

	public boolean detectCapitalUse(String word) {
        if (word.charAt(0)>='A'&&word.charAt(0)<='Z') {
        	StringBuilder newWord=new StringBuilder(word);
        	newWord.delete(0, 1);
        	return newWord.toString().equals(newWord.toString().toLowerCase())||newWord.toString().equals(newWord.toString().toUpperCase());
        }else {
        	return word.equals(word.toLowerCase());
        }
        
       
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
