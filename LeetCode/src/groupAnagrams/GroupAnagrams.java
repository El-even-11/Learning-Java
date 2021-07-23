package groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {

		HashMap<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			char[] now = strs[i].toCharArray();
			Arrays.sort(now);
			StringBuilder s = new StringBuilder();
			for (char k : now) {
				s.append(k);
			}
			map.put(s.toString(), map.getOrDefault(s.toString(), new ArrayList<>()));
			map.get(s.toString()).add(strs[i]);
		}

		List<List<String>> ret = new ArrayList<>();

		for (String s : map.keySet()) {
			ret.add(map.get(s));
		}

		return ret;
	}

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		groupAnagrams(strs);
	}

}
