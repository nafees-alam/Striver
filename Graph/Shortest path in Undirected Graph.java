class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int adjNode : adj.get(curr)){
                if(dist[curr] + 1 < dist[adjNode]){
                    dist[adjNode] = 1 + dist[curr];
                    q.add(adjNode);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}
