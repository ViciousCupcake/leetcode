
/**
 * prob222
 */

public class prob222 {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }

    static public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

