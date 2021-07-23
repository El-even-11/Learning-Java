package arrangeCoins;

public class ArrangeCoins {

	public static int arrangeCoins(int n) {

		int i=1;
		while (n>0) {
			n-=i;
			i++;
		}
		return i-2;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(arrangeCoins(8));
	}

}
