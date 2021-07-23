package binaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import nodes.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans =new ArrayList<>();
		
		if (root==null) {
			return ans;
		}
		
		Stack<List<Integer>> top_to_foot = new Stack<>();
		Queue<TreeNode> nodes=new LinkedList<>();
		
		nodes.offer(root);
		
		while (!nodes.isEmpty()) {
			int cnt=nodes.size();
			List<Integer> now=new ArrayList<>();
			
			while(cnt>0) {
				TreeNode temp=nodes.poll();
				now.add(temp.val);
				
				if (temp.left!=null) {
					nodes.offer(temp.left);
				}
				if (temp.right!=null) {
					nodes.offer(temp.right);
				}
				cnt--;
			}
			top_to_foot.push(now);
		}
		
		while (!top_to_foot.isEmpty()) {
			ans.add(top_to_foot.pop());
		}
		return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
