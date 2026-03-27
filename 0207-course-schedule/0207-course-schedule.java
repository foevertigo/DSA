class Solution {

    ArrayList<ArrayList<Integer>> adj;
    int[] vis; // 0 = unvisited, 1 = visiting, 2 = visited

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        adj = new ArrayList<>();
        for (int i = 0; i <= numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int[] p : prerequisites) {
            int u = p[1];
            int v = p[0];
            adj.get(u).add(v);
        }

        vis = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i)) return false; // cycle found
            }
        }

        return true;
    }

    boolean dfs(int node) {

        vis[node] = 1; // visiting

        for (int nei : adj.get(node)) {
            if (vis[nei]==0) {
                if (dfs(nei)) return true;
            } else if (vis[nei] == 1) {
                return true; // cycle
            }
        }

        vis[node] = 2; // done
        return false;
    }
}