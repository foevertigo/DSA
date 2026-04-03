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
    public int amountOfTime(TreeNode root, int start) {
        // Build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, null, graph);

        // BFS
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        int minutes = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int node = q.poll();

                for (int nei : graph.get(node)) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        q.offer(nei);
                    }
                }
            }
        }

        return minutes;
    }

    private void buildGraph(TreeNode node, TreeNode parent,Map<Integer, List<Integer>> graph) {
        if (node == null) return;

        graph.putIfAbsent(node.val, new ArrayList<>());

        if (parent != null) {
            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}