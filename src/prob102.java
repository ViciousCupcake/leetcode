import java.util.*;

public class prob102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder((root)));

    }

    static public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<List<TreeNode>> nodes = new ArrayList<List<TreeNode>>();
        if (root == null) {
            return output;
        }
        nodes.add(new ArrayList<TreeNode>(Arrays.asList(root)));
        output.add(new ArrayList<Integer>(Arrays.asList(root.val)));

        int currentLevel = 0;
        while (currentLevel < nodes.size()) {
            currentLevel++;

            for (TreeNode currNode : nodes.get(currentLevel - 1)) {

                if (currNode.left != null) {
                    if (nodes.size() - 1 != currentLevel) {
                        nodes.add(new ArrayList<TreeNode>());
                        output.add(new ArrayList<Integer>());
                    }
                    nodes.get(currentLevel).add(currNode.left);
                    output.get(currentLevel).add(currNode.left.val);
                }
                if (currNode.right != null) {
                    if (nodes.size() - 1 != currentLevel) {
                        nodes.add(new ArrayList<TreeNode>());
                        output.add(new ArrayList<Integer>());
                    }
                    nodes.get(currentLevel).add(currNode.right);
                    output.get(currentLevel).add(currNode.right.val);
                }

            }
        }

        return output;
    }

}
