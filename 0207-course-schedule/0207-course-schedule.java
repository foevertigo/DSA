class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        

        //build adj

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] p: prerequisites) {
            int u = p[0];
            int v = p[1];
            adj.get(v).add(u);
        }


        //dfs call
        int[] visited = new int[numCourses];
        for(int i=0; i<numCourses;i++) {
            if(dfs(i,adj,visited)) {
                return false; //cycle = empty
            }
        }
        return true;

    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        if(visited[node]==1) return true; //cycle
        if(visited[node]==2) return false;

        visited[node] = 1;
        for(int neigh : adj.get(node)) {
            if(dfs(neigh, adj, visited)) return true;
        }

        visited[node] = 2;
        return false;

    }


}