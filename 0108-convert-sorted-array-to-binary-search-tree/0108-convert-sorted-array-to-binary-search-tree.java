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
         return Tree(nums, 0, nums.length - 1);
    }

    private TreeNode Tree(int[] nums, int left, int right) {
        // Base case
        if (left > right) return null;

        // Always choose the middle element as root
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build left and right subtrees
        root.left = Tree(nums, left, mid - 1);
        root.right = Tree(nums, mid + 1, right);

        return root;
    }
}