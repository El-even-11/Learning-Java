package happyNumber;

import java.util.HashSet;

public class HappyNumber {

	public static boolean isHappy(int n) {
		
		HashSet<Integer> exist =new HashSet<>();
		while (n != 1) {
			
			int len=exist.size();
			exist.add(n);
			
			if (exist.size()==len) {
				return false;
			}
			
			int temp = n;
			n = 0;
			while (temp != 0) {
				n += (temp % 10) * (temp % 10);
				temp /= 10;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(2));
	}

}
