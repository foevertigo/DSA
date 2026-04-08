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
    List<Integer> inorder = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);
        return buildBST(0, inorder.size() - 1);
    }
        private void inorderTraversal(TreeNode root) {
            if(root == null) return;
            inorderTraversal(root.left);
            inorder.add(root.val);
            inorderTraversal(root.right);
        }

        private TreeNode buildBST(int left, int right) {
            if(left > right) return null;

            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(inorder.get(mid));

            root.left = buildBST(left, mid-1);
            root.right = buildBST(mid + 1, right);
            return root;
        }
       
    
}