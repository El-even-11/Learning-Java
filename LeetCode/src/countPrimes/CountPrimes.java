package countPrimes;

import java.util.ArrayList;
import java.util.HashMap;

public class CountPrimes {

	public static int countPrimes(int n) {

		// too slow

//		ArrayList<Integer> primes = new ArrayList<>();
//		primes.add(2);
//		for (int i = 3; i < n; i += 2) {
//			boolean isPrime = true;
//			for (int j = 0; j < primes.size(); j++) {
//				if (i % primes.get(j) == 0) {
//					isPrime = false;
//				}
//			}
//			if (isPrime) {
//				primes.add(i);
//			}
//		}
//
//		return primes.size();

		boolean [] isNotPrime = new boolean [n];

		int cnt = 0;
		for (int i = 2; i < n; i++) {
			if (!isNotPrime[i]) {
				for (int j = 2; i * j < n ; j++) {
					isNotPrime[i*j]=true;
				}
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(100));
	}

}
