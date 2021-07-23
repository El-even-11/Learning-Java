package bestTimetoBuyandSellStock;

public class BestTimetoBuyandSellStock {

	public static int maxProfit(int[] prices) {

		int pre=0;
		int minBuy=0;
		for (int i=1;i<prices.length;i++) {
			
			if (pre<Math.max(pre, prices[i]-prices[minBuy])) {
				pre=Math.max(pre, prices[i]-prices[minBuy]);
			}
			
			if (prices[i]<prices[minBuy]) {
				minBuy=i;
			}
		}
		
		return pre;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []prices= {7,6,4,3,1};
		System.out.println(maxProfit(prices));
	}

}
