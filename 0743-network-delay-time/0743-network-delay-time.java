class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        

        //making a graph structure
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0; i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        

        //filling the graph
        for(int[] t:times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];

            adj.get(u).add(new int[]{v,w});
        }


        //distance array with INF
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        

        //to store {node, distance} will give min distance always
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        

        //starting point distance is 0
        dist[k] =0;
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();  //smalles distance node
            int node = curr[0];
            int d = curr[1];

            for(int[] nei:adj.get(node)) {  //explore neighbours
                int v = nei[0];
                int w = nei[1];

                if(d+w < dist[v]) {   //relaxation
                    dist[v] = d+w;     //also add to dist array
                    pq.offer(new int[]{v,dist[v]});  //update pq to process
                }
            }
        }

        int max=0;
        for(int i=1;i<=n;i++) {
            if(dist[i]==Integer.MAX_VALUE) return -1;  //if distance is inf
            max = Math.max(max,dist[i]);
        }
        return max;
    }
}