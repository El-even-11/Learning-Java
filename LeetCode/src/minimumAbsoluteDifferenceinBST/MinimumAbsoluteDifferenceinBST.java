package minimumAbsoluteDifferenceinBST;

import java.util.ArrayList;
import java.util.Stack;

import nodes.TreeNode;

public class MinimumAbsoluteDifferenceinBST {

	
	public int getMinimumDifference(TreeNode root) {
		
		Stack<TreeNode> nodes=new Stack<>();
		ArrayList<Integer> vals=new ArrayList<>();
		
		while (!nodes.isEmpty()||root!=null) {
			while (root!=null) {
				nodes.push(root);
				root=root.left;
			}
			
			root=nodes.pop();
			
			vals.add(root.val);
			
			root=root.right;
		}
		
		int min=Integer.MAX_VALUE;
		
		for (int i=0;i<vals.size()-1;i++) {
			min=Math.min(min, vals.get(i+1)-vals.get(i));
		}
		
		return min;
	}
	
	

}
