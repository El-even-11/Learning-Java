package moveZeroes;

public class MoveZeroes {

	public static void moveZeroes(int[] nums) {

		//too slow
		
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] == 0) {
//				for (int j = i + 1; j < nums.length; j++) {
//					if (nums[j] != 0) {
//						nums[i] = nums[j];
//						nums[j] = 0;
//						break;
//					}
//				}
//			}
//		}
		
		
		//¿ìÂýÖ¸Õë

		int i=0;
		for (int j=0;j<nums.length;j++) {
			if (nums[j]!=0) {
				nums[i]=nums[j];
				i++;
			}
		}
		for (int j=i;j<nums.length;j++) {
			nums[j]=0;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
	}

}
