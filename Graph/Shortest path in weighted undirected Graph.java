class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[1] = 0;
        dist[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        pq.add(new Pair(1,0));
        int[] par = new int[n+1];
        for(int i = 0; i < n+1; i++){
            par[i] = i;
        }
        
        
        while(!pq.isEmpty()){
            int curr = pq.peek().node;
            int dis = pq.peek().dist;
            pq.remove();
            
            for(Pair it : adj.get(curr)){
                int adjNode = it.node;
                int wt = it.dist;
                
                if(dist[curr] + wt < dist[adjNode]){
                    par[adjNode] = curr;
                    dist[adjNode] = dist[curr] + wt;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(dist[n] == 1e9){
            ans.add(-1);
            return ans;
        }
        
        int node = n;
        while(par[node] != node){
            ans.add(0,node);
            node = par[node];
        }
        ans.add(0, 1);
        
        return ans;
    }
}

class Pair{
    int node;
    int dist;
    
    public Pair(int i, int j){
        this.node = i;
        this.dist = j;
    }
}
