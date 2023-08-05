

public class Leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if(p == null && q == null) {
        //     return true;
        // }
        // else if(p == null || q == null) {
        //     return false;
        // }
        // else if(p.left == null && q.left != null) {
        //     return false;
        // }
        // else if(p.left != null && q.left == null) {
        //     return false;
        // }
        // else if(p.right == null && q.right != null) {
        //     return false;
        // }
        // else if(p.right != null && q.right == null) {
        //     return false;
        // }
        // else if(p.val != q.val) {
        //     return false;
        // }
        // else {
        //     if(p.left != null && q.left != null) {
        //         return isSameTree(p.left, q.left);
        //     }
        //     if(p.right != null && q.right != null) {
        //         return isSameTree(p.right, q.right);
        //     }
        //     if(p.left == null && q.left == null && p.right == null && q.right == null) {
        //         return true;
        //     } else {
        //         return false;
        //     }
        // }

        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Leetcode100 lc = new Leetcode100();
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        boolean result = lc.isSameTree(p, q);
        System.out.println(result);
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