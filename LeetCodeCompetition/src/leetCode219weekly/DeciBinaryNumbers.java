package leetCode219weekly;

public class DeciBinaryNumbers {

	public int minPartitions(String n) {
		int max = 0;

		for (Character i : n.toCharArray()) {
			max = max > (i - '0') ? max : (i - '0');
		}
		
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
