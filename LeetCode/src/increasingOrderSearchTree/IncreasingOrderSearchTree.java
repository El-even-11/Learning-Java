package increasingOrderSearchTree;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

public class IncreasingOrderSearchTree {

    TreeNode ret=new TreeNode();
    TreeNode p=ret;

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return ret;
    }

    public void inOrder(TreeNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        p.right=new TreeNode(root.val);
        p=p.right;
        inOrder(root.right);
    }
}
