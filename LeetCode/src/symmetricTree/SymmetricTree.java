package symmetricTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {

	Stack<Integer> ans = new Stack<>();
	Queue<TreeNode> queue = new LinkedList<>();

	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}

		queue.offer(root);

		while (!queue.isEmpty()) {
			removeNext();
		}

		return ans.size() == 1;
	}

	public void removeNext() {
		TreeNode temp = queue.poll();

		if (ans.isEmpty()) {
			ans.push(temp.val);
		}else {
			if (ans.lastElement() == temp.val) {
				ans.pop();
			} else {
				ans.push(temp.val);
			}
		}

		if (temp.val!=-12345) {
			if (temp.left != null) {
				queue.offer(temp.left);
			} else {
				TreeNode NULL = new TreeNode();
				NULL.val = -12345;
				queue.offer(NULL);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			} else {
				TreeNode NULL = new TreeNode();
				NULL.val = -12345;
				queue.offer(NULL);
			}
		}

	}
	
	
	//上面不行，要每行判断回文
	
	public boolean isSymmetricTwo(TreeNode root) {
        if (root==null){
            return true;
        }
        
		return isSymmetricSame(root.left, root.right);
	}

	public boolean isSymmetricSame(TreeNode Left, TreeNode Right) {

		if (Left==null&&Right==null) {
			return true;
		}
		
		if (Left==null||Right==null) {
			return false;
		}
		
		if (Left.val!=Right.val) {
			return false;
		}
		
		if (!isSymmetricSame(Left.left, Right.right)) {
			return false;
		}
		
		if (!isSymmetricSame(Left.right, Right.left)) {
			return false;
		}
		
		return true;
	}
	
	

}
