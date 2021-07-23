package sumRoottoLeafNumbers;

import java.util.ArrayList;

import nodes.TreeNode;

public class SumRoottoLeafNumbers {

	ArrayList<String> nums=new ArrayList<>();
	
	public int sumNumbers(TreeNode root) {
		dfs(root,new StringBuilder());
		
		int sum=0;
		
		for (String s:nums) {
			sum+=Integer.parseInt(s, 10);
		}
		
		return sum;
    }
	
	public void dfs(TreeNode root,StringBuilder num) {
		if (root==null) {
			return;
		}
		
		num.append(root.val);
		
		if (root.left==null&&root.right==null) {
			nums.add(num.toString());
			return;
		}
		
		dfs(root.left,new StringBuilder(num));
		dfs(root.right,new StringBuilder(num));
	}
	
	
}
