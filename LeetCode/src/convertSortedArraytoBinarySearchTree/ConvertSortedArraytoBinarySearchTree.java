package convertSortedArraytoBinarySearchTree;

import nodes.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length==0) {
			return null;
		}

		return dfs(nums,0,nums.length-1);
    }
	
	public static TreeNode dfs(int []nums,int left,int right) {
		if (left>right) {
			return null;
		}
		
		int mid=left+(right-left)/2;
		
		TreeNode node=new TreeNode();
		node.val=nums[mid];
		node.left=dfs(nums,left,mid-1);
		node.right=dfs(nums,mid+1,right);
		
		return node;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
