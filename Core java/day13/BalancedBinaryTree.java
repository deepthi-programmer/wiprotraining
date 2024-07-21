package day13;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BalancedBinaryTree {
	 static class TreeInfo {
	        int height;
	        boolean isBalanced;

	        TreeInfo(int height, boolean isBalanced) {
	            this.height = height;
	            this.isBalanced = isBalanced;
	        }
	    }
	 public boolean isBalanced(TreeNode root) {
	        return checkBalance(root).isBalanced;
	    }

	    private TreeInfo checkBalance(TreeNode node) {
	        // Base case: an empty tree is balanced with a height of -1
	        if (node == null) {
	            return new TreeInfo(-1, true);
	        }

	        // Check balance of left subtree
	        TreeInfo left = checkBalance(node.left);
	        if (!left.isBalanced) {
	            return new TreeInfo(-1, false); // Left subtree is not balanced
	        }
	        TreeInfo right = checkBalance(node.right);
	        if (!right.isBalanced) {
	            return new TreeInfo(-1, false); // Right subtree is not balanced
	        }

	        // Current node is balanced if both subtrees are balanced and the height difference is not more than 1
	        boolean isBalanced = Math.abs(left.height - right.height) <= 1;
	        int height = Math.max(left.height, right.height) + 1;

	        return new TreeInfo(height, isBalanced);
	    }
	    public static void main(String[] args) {
	        // Example usage:
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	        root.left.left.left = new TreeNode(8);

	        BalancedBinaryTree treeChecker = new BalancedBinaryTree();
	        System.out.println(treeChecker.isBalanced(root)); // Output: false
	    }
	}
