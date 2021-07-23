package leetCode220weekly;

import java.util.ArrayList;

public class ReformatPhoneNumber {

	public static String reformatNumber(String number) {
		ArrayList<Character> nums = new ArrayList<>();

		for (Character c : number.toCharArray()) {
			if (c != ' ' && c != '-') {
				nums.add(c);
			}
		}

		if (nums.size() < 4) {
			StringBuilder ret = new StringBuilder();
			for (Character c : nums) {
				ret.append(c);
			}
			return ret.toString();
		}

		StringBuilder ret = new StringBuilder();

		int cnt = 0;
		while (nums.size() > cnt * 3 + 4) {
			for (int i = cnt * 3; i < cnt * 3 + 3; i++) {
				ret.append(nums.get(i));
			}
			ret.append('-');
			cnt++;
		}

		if (nums.size() - cnt * 3 == 4) {
			ret.append(nums.get(nums.size() - 4));
			ret.append(nums.get(nums.size() - 3));
			ret.append('-');
			ret.append(nums.get(nums.size() - 2));
			ret.append(nums.get(nums.size() - 1));
		} else if (nums.size() - cnt * 3 == 3) {
			ret.append(nums.get(nums.size() - 3));
			ret.append(nums.get(nums.size() - 2));
			ret.append(nums.get(nums.size() - 1));
		} else if (nums.size() - cnt * 3 == 2) {
			ret.append(nums.get(nums.size() - 2));
			ret.append(nums.get(nums.size() - 1));
		}

		return ret.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reformatNumber("123 4-5678"));
	}

}
