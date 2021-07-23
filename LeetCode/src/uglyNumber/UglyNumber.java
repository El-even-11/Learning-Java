package uglyNumber;

public class UglyNumber {

	//内存占用太多
	public static boolean isUgly(int num) {
		if (num < 1) {
			return false;
		}

		boolean[] isNotPrime = new boolean[num + 1];

		for (int i = 2; i <= num; i++) {
			if (!isNotPrime[i]) {
				for (int j = 2; i * j <= num; j++) {
					isNotPrime[i * j] = true;
				}
			}
		}
		
//		if (num>5&&!isNotPrime[num]) {
//			return false;
//		}

		for (int i = 7; i < isNotPrime.length; i++) {
			if (!isNotPrime[i] && num % i == 0) {
				return false;
			}
		}

		return true;
	}
	
	public static boolean isUglyTwo(int num) {
		
		if (num<1) {
			return false;
		}
		
		while (num%5==0) {
			num/=5;
		}
		while (num%3==0) {
			num/=3;
		}
		while (num%2==0) {
			num/=2;
		}
		
		return num==1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(7));
	}

}
