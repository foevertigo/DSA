class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        

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
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<numCourses;i++) {
            if(dfs(i,adj,visited,result)) {
                return new int[0]; //cycle = empty
            }
        }

        //reverse result
        Collections.reverse(result);

        //convert list to array
        int[] ans = new int[result.size()];
        for(int i=0; i<result.size();i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, List<Integer> result) {
        if(visited[node]==1) return true; //cycle
        if(visited[node]==2) return false;

        visited[node] = 1;
        for(int neigh : adj.get(node)) {
            if(dfs(neigh, adj, visited, result)) return true;
        }

        visited[node] = 2;
        result.add(node);
        return false;

    }


}