package lowestCommonAncestor;

import nodes.TreeNode;

public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return null;
		}

		if (root.val <= Math.max(p.val, q.val) && root.val >= Math.min(p.val, q.val)) {
			return root;
		}

		if (root.val > Math.max(p.val, q.val)) {
			return lowestCommonAncestor(root.left, p, q);
		} 
		
		if (root.val < Math.min(p.val, q.val)) {
			return lowestCommonAncestor(root.left, p, q);
		}
		
		return null;
	}

}
