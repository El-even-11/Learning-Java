package dota2Senate;

public class Dota2Senate {

	public static String predictPartyVictory(String senate) {

		int len = senate.length();
		boolean[] power = new boolean[len];

		for (int i = 0; i < len; i++) {
			power[i] = true;
		}

		for (int i = 0; i <= len; i++) {
			if (i == len) {
				i = 0;
			}
			if (senate.charAt(i) == 'R' && power[i]) {
				int j = i + 1;
				if (j == len) {
					j = 0;
				}
				boolean second = false;
				for (; j <= len; j++) {
					if (j == len) {
						j = 0;
					}
					if (j == (((i + 1) == len) ? 0 : (i + 1)) && second) {
						return "Radiant";
					}
					second = true;
					
					if (senate.charAt(j) == 'D' && power[j]) {
						power[j] = false;
						break;
					}
				}
			} else if (senate.charAt(i) == 'D' && power[i]) {
				int j = i + 1;
				if (j == len) {
					j = 0;
				}
				boolean second = false;
				for (; j <= len; j++) {
					if (j == len) {
						j = 0;
					}
					if (j == (((i + 1) == len) ? 0 : (i + 1)) && second) {
						return "Dire";
					}
					second = true;
					
					if (senate.charAt(j) == 'R' && power[j]) {
						power[j] = false;
						break;
					}
				}
			}
		}

		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(predictPartyVictory("RDD"));
	}

}
