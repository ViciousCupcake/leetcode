import java.util.*;

public class prob105 {
    public static void main(String[] args) {
        System.out.println("hello world");
    }

    static public TreeNode buildTree(int[] preorder, int[] inorder) {

    }
    static public TreeNode recurBuildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend){
        TreeNode root = new TreeNode(preorder[pstart]);
        int preorderIndexOfRight = search(preorder, pstart, pend, )
        return root;
    }

    static public int search(int[] arr, int start, int end, int key) {
        for (int i = start; i < end; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }
}
