package roman_to_integer;

import java.util.HashMap;
import java.util.Scanner;

public class RomantoInteger {
	private HashMap<Character, Integer> romannums = new HashMap<Character, Integer>();

	public RomantoInteger() {
		romannums.put('I', 1);
		romannums.put('V', 5);
		romannums.put('X', 10);
		romannums.put('L', 50);
		romannums.put('C', 100);
		romannums.put('D', 500);
		romannums.put('M', 1000);
	}

	public int romanToInt(String s) {
		char[] roman = s.toCharArray();
		int[] nums = new int[roman.length];
		int sum = 0;
		for (int i = 0; i < roman.length; i++) {
			nums[i] = romannums.get(roman[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
				sum -= nums[i];
			} else
				sum += nums[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		RomantoInteger test = new RomantoInteger();
		String s = in.nextLine();
		int num = test.romanToInt(s);
		System.out.println(num);

	}

}
