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
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int left, int right) {
        // Base case: if the left index exceeds the right index, the subtree is empty
        if (left > right) {
            return null;
        }

        // Find the middle element to maintain a height-balanced tree
        int mid = left + (right - left) / 2;

        // Create the root node with the middle element
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build the left and right subtrees
        root.left = constructBST(nums, left, mid - 1);
        root.right = constructBST(nums, mid + 1, right);

        return root;
    }
}
