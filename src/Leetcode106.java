import java.util.HashMap;
import java.util.Map;

public class Leetcode106 {
    private int postIndex;
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helperNode(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode helperNode(int[] inorder, int[] postorder, int instStart, int instEnd) {
        if(instStart > instEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex--]);
        int inIndex = map.get(root.val);
        root.right = helperNode(inorder, postorder, inIndex + 1, instEnd);
        root.left = helperNode(inorder, postorder, instStart, inIndex - 1);
        return root;
    }
}

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