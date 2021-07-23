package leetCode218weekly;

public class ConcatenationofConsecutiveBinaryNumbers {

	public static int concatenatedBinary(int n) {
		StringBuilder ret=new StringBuilder();
		for (int i=1;i<=n;i++) {
			String s = Integer.toBinaryString(i);
			ret.append(s);
			
			if (ret.length()>30) {
				long temp=Long.parseLong(ret.toString(),2);
				temp=temp%(1000000007);
				ret.delete(0, ret.length());
				ret.append(Long.toBinaryString(temp));
			}
		}
		
		long ans=Integer.parseInt(ret.toString(), 2);
		
		ans=ans%(1000000007);
		return (int)ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(concatenatedBinary(12));
	}

}
