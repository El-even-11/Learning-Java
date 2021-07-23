package mergeSortedArray;

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int put = nums1.length - 1;
		int a = m-1;
		int b = n-1;
		while (put > 0) {
			if (nums1[a] > nums2[b]) {
				nums1[put] = nums1[a];
				a--;
			} else {
				nums1[put] = nums2[b];
				b--;
			}
			put--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
