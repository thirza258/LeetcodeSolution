import java.util.ArrayList;
import java.util.List;

public class Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        List<TreeNode> list = new ArrayList<>();
        
        list.add(root);
        while(list.size() != 0) {
            TreeNode node = list.remove(list.size() - 1);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null) {
                list.add(node.left);
            }

            if(node.right != null) {
                list.add(node.right);
            }

        }

        return root;
    }

    public static void main(String[] args) {
        Leetcode226 leetcode226 = new Leetcode226();
        TreeNode root = new TreeNode(4);   
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left  = node5;
        node2.right = node6;
        leetcode226.invertTree(root);
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