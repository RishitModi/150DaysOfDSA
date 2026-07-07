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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int a = p.val;
        int b = q.val;
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        while(root!= null){
        if(root.val > b) {
            root = root.left;
        }
        else if(root.val < a) {root = root.right;}

        else return root;
        }
        return null;
    }
}
