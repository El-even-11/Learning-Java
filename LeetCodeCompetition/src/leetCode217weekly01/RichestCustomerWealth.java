package leetCode217weekly01;

public class RichestCustomerWealth {

	public int maximumWealth(int[][] accounts) {

		int max=0;
		
		for (int i=0;i<accounts.length;i++) {
			int sum=0;
			for (int j=0;j<accounts[i].length;j++) {
				sum+=accounts[i][j];
			}
			
			if (sum>max) {
				max=sum;
			}
		}
		
		return max;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
