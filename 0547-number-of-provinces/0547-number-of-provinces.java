class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int count = 0;

        for(int i=0; i<n;i++) {
            if(visited[i]==0) {
                dfs(i,isConnected,visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, int[][] adj, int[] visited) {
        visited[node] = 1;
        for(int i=0;i<adj.length;i++) {
            if(adj[node][i]==1 && visited[i]==0) {
                dfs(i,adj,visited);
            }
        }
    }
}