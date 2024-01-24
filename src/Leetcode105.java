
//Leetcode 105: Construct Binary Tree from Preorder and Inorder Traversal

import java.util.HashMap;
import java.util.Map;

public class Leetcode105 {
    
    int preStart = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helperNode(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helperNode(int[] preorder,int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int elem = map.get(root.val);
        int nElem = elem - inStart;

        root.left = helperNode(preorder,inorder, preStart + 1, preStart + nElem,  inStart, elem - 1);
        root.right = helperNode(preorder,inorder, preStart + nElem + 1, preEnd,  elem + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        Leetcode105 sol = new Leetcode105();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = sol.buildTree(preorder, inorder);
        System.out.println(root.val);
    
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int x) {
        val = x; 
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}