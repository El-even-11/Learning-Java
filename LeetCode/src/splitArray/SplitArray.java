package splitArray;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SplitArray {

	public static boolean isPossible(int[] nums) {

		HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, new PriorityQueue<>());
			}
			
			if (map.containsKey(i - 1)) {
				int newLen=map.get(i-1).poll()+1;
				if (map.get(i-1).isEmpty()) {
					map.remove(i-1);
				}
				map.get(i).add(newLen);
			} else {
				map.get(i).add(1);
			}
		}
		
		for (Integer i:map.keySet()) {
			if (map.get(i).peek()<3) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []nums= {1,1,2,2,3,3,4,5};
		System.out.println(isPossible(nums));
	}

}
