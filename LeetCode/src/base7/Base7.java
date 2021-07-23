package base7;

public class Base7 {

	public static String convertToBase7(int num) {
		
		return Integer.toString(num, 7);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToBase7(100));
	}

}
