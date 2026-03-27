class Solution {
    public int minCostConnectPoints(int[][] points) {
         int n = points.length;

        boolean[] visited = new boolean[n];
        int edgesUsed = 0;
        int res = 0;

        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0}); // start from node 0

        while (edgesUsed < n) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int u = cur[1];

            if (visited[u]) continue;

            visited[u] = true;
            res += cost;
            edgesUsed++;

           
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) +
                               Math.abs(points[u][1] - points[v][1]);
                    pq.offer(new int[]{dist, v});
                }
            }
        }

        return res;
    }
}