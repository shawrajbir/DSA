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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // If left subtree is null, recurse on right subtree
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        
        // If right subtree is null, recurse on left subtree
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        
        // If both children exist, take the minimum of both depths
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}