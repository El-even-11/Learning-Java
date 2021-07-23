package matrixCellsinDistanceOrder;

import java.util.ArrayList;
import java.util.List;

public class MatrixCellsinDistanceOrder {

	public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		
		int [][]ans=new int [R*C][2];
	
		for (int pos=0;pos<R*C;pos++) {
			ans[pos][0]=pos/C;
			ans[pos][1]=pos%C;
		}
		
		for (int lh=0;lh<R*C;lh++) {
			int min=lh;
			for (int rh=lh+1;rh<R*C;rh++) {
				int mindistance=Math.abs(ans[min][0]-r0)+Math.abs(ans[min][1]-c0);
				int distance=Math.abs(ans[rh][0]-r0)+Math.abs(ans[rh][1]-c0);
				if (distance<mindistance) {
					min=rh;
				}
			}
			int temp0=ans[lh][0];
			ans[lh][0]=ans[min][0];
			ans[min][0]=temp0;
			int temp1=ans[lh][1];
			ans[lh][1]=ans[min][1];
			ans[min][1]=temp1;
		}
		
		return ans;
    }
	
	public static int[][] allCellsDistOrderTwo(int R, int C, int r0, int c0){
		int [][]ans=new int [R*C][2];
		
		List<List<int []>> bucket =new ArrayList<List<int []>>();
		
		int maxDistance=Math.max(r0, R-1-r0)+Math.max(c0, C-1-c0);
		
		for (int i=0;i<=maxDistance;i++) {
			bucket.add(new ArrayList<>());
		}
		
		for (int i=0;i<R;i++) {
			for (int j=0;j<C;j++) {
				int dist=distance(i,j,r0,c0);
				bucket.get(dist).add(new int[] {i,j});
			}
		}
		
		int cnt=0;
		for (List<int []>i:bucket) {
			for (int []j:i) {
				ans[cnt]=j;
				cnt++;
			}
		}
		
		return ans;
	}
	
	public static int distance(int r1,int c1,int r2,int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allCellsDistOrderTwo(2, 3, 1, 2));
	}

}
