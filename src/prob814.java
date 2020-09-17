package src;

public class prob814 {
    public static void main(String[] args) {

    }

    static public TreeNode pruneTree(TreeNode root) {
        boolean rootIsNull = helper(root);
        if(rootIsNull)
            return null;
        return root;
    }

    static public boolean helper(TreeNode root) {
        if (root == null)
            return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left)
            root.left = null;
        if (right)
            root.right = null;

        if (root.left == null && root.right == null) {
            return root.val == 0;
        }

        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
