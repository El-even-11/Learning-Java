package binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import nodes.TreeNode;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		if (root==null) {
			return new ArrayList<Integer>();
		}
		
		List<Integer> ret=new ArrayList<>();
		Queue<TreeNode> nodes=new LinkedList<>();
		
		nodes.offer(root);
		
		while (!nodes.isEmpty()) {
			int n=nodes.size();
			for (int i=0;i<n;i++) {
				TreeNode temp=nodes.poll();
				if (i==n-1) {
					ret.add(temp.val);
				}
				if (temp.left!=null) {
					nodes.offer(temp.left);
				}
				if (temp.right==null) {
					nodes.offer(temp.right);
				}
			}
		}
		
		return ret;
	}

}
