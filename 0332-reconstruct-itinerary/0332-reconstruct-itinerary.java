class Solution {
    HashMap<String, PriorityQueue<String>> adj;
    LinkedList<String> result;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        result = new LinkedList<>();

        for(List<String> t: tickets) {
            String u = t.get(0);
            String v = t.get(1);
            adj.putIfAbsent(u, new PriorityQueue<>());
            adj.get(u).add(v);
        }

        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    private void dfs(String node) {
        while(adj.containsKey(node) && !adj.get(node).isEmpty()) {
            String next = adj.get(node).poll();
            dfs(next);
        }
        result.add(node);
    }
   
}