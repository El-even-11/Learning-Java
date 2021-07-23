package uncommonWordsfromTwoSentences;

import java.util.ArrayList;
import java.util.HashMap;

public class UncommonWordsfromTwoSentences {

	public String[] uncommonFromSentences(String A, String B) {

		ArrayList<String> ret = new ArrayList<>();

		String[] wordsInA = A.split(" ");
		String[] wordsInB = B.split(" ");

		HashMap<String, Integer> wordsInA_cnt = new HashMap<>();
		HashMap<String, Integer> wordsInB_cnt = new HashMap<>();

		for (int i = 0; i < wordsInA.length; i++) {
			wordsInA_cnt.put(wordsInA[i], wordsInA_cnt.getOrDefault(wordsInA[i], 0) + 1);
		}

		for (int i = 0; i < wordsInB.length; i++) {
			wordsInB_cnt.put(wordsInB[i], wordsInB_cnt.getOrDefault(wordsInB[i], 0) + 1);
		}

		for (String s : wordsInA) {
			if (wordsInA_cnt.get(s) == 1 && !wordsInB_cnt.containsKey(s)) {
				ret.add(s);
			}
		}

		for (String s : wordsInB) {
			if (wordsInB_cnt.get(s) == 1 && !wordsInA_cnt.containsKey(s)) {
				ret.add(s);
			}
		}

		return ret.toArray(new String[ret.size()]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
