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
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if(start > end) {
            result.add(null);
            return result;
        }

        for(int i=start; i<=end;i++) {
            List<TreeNode> lefttrees = build(start, i-1);
            List<TreeNode> righttrees = build(i+1, end);


            for(TreeNode left:lefttrees) {
                for(TreeNode right:righttrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }

        }
        return result;
    }
}