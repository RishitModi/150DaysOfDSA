/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    private boolean sameTree(TreeNode a, TreeNode b){
        if(a==null && b == null) return true;
        if(a==null || b==null) return false;

        if(a.val!=b.val) return false;

        return sameTree(a.left , b.left) && sameTree(a.right , b.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if(root ==null) return false;
        if(sameTree(root , subroot)) return true;
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }
}
