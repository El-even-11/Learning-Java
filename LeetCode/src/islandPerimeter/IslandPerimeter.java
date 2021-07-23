package islandPerimeter;

public class IslandPerimeter {

	public static int islandPerimeter(int[][] grid) {

		int[][] grid_new = new int[grid.length + 2][grid.length + 2];

		for (int i = 1; i < grid.length + 1; i++) {
			for (int j = 1; j < grid.length + 1; j++) {
				grid_new[i][j]=grid[i-1][j-1];
			}
		}
	
		int sum=0;
		
		for (int i = 1; i < grid.length + 1; i++) {
			for (int j = 1; j < grid.length + 1; j++) {
				if (grid_new[i][j]==1) {
					int Perimeter_now=0;
					if (grid_new[i-1][j]==0) {
						Perimeter_now++;
					}
					if (grid_new[i+1][j]==0) {
						Perimeter_now++;
					}
					if (grid_new[i][j+1]==0) {
						Perimeter_now++;
					}
					if (grid_new[i][j-1]==0) {
						Perimeter_now++;
					}
					sum+=Perimeter_now;
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.print(islandPerimeter(grid));
	}

}
