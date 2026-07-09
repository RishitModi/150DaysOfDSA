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
    int idx= 0;
    
    private  TreeNode helper(int inorder[], int preorder[] ,HashMap<Integer,Integer> mp , int inStart , int inEnd){
        if(inStart > inEnd) return null;
        int rootVal = preorder[idx++];
        
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = mp.get(rootVal);
        
        root.left = helper(inorder,preorder,mp,inStart,rootIdx - 1);
        root.right = helper(inorder,preorder,mp,rootIdx+1,inEnd);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            mp.put(inorder[i] , i);
        }
        
        TreeNode root = helper(inorder,preorder,mp,0,inorder.length-1);
        return root; 
    }
}