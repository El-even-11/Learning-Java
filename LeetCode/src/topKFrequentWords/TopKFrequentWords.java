package topKFrequentWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentWords {

	static class Word implements Comparable<Word> {

		String s;
		int cnt;

		public Word(String s, int cnt) {
			this.s = s;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Word x) {

			if (this.cnt < x.cnt) {
				return 1;
			} else if (this.cnt > x.cnt) {
				return -1;
			}

			return this.s.compareTo(x.s);
		}

	}

	public static List<String> topKFrequent(String[] words, int k) {

		List<String> ret = new ArrayList<>();
		HashMap<String, Integer> cnt = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			cnt.put(words[i], cnt.getOrDefault(words[i], 0)+1);
		}

		Word[] values = new Word[cnt.keySet().size()];

		int i = 0;
		for (String s : cnt.keySet()) {
			values[i++] = new Word(s, cnt.get(s));
		}

		Arrays.sort(values);

		for (int j = 0; j < k; j++) {
			ret.add(values[j].s);
		}

		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		topKFrequent(words, 2);
	}

}
