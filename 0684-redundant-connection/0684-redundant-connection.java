class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int[] vis = new int[n+1];
            if(dfs(u,v,adj,vis)) return edge;
            adj.get(u).add(v);
        adj.get(v).add(u);
        }

        return new int[0]; 
    }

    boolean dfs(int src, int target, ArrayList<ArrayList<Integer>> adj, int[] vis) {
    if(src == target) return true;
    vis[src] = 1;
    for(int nei:adj.get(src)) {
        if(vis[nei]==0) {
            if(dfs(nei,target,adj,vis)) return true;
        }
    }
    return false;
}
   
}

