class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         
        // build graph
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
         

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

       //fill graph
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        //distance array

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); //fill with inf
        

        //not using priority queue to respect k
        Queue<int[]> q = new LinkedList<>();
         
         //src distance is 0
        dist[src] = 0;
        q.offer(new int[]{src, 0, 0});  //node, cost, stops

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if(stops>k) continue;   //if stops are bigger than k, leave it

            for (int[] nei : adj.get(node)) {   //explore neighbours
   
                int v = nei[0];
                int w = nei[1];

                if (cost + w < dist[v] && stops<=k) {   
                    dist[v] = cost + w;
                    q.offer(new int[]{v, dist[v], stops+1});  //add to stops 
                }
            }
        }

    
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}