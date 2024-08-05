class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        int l = flights.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < l; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        
        while(!q.isEmpty()){
            Tuple tp = q.peek();
            q.remove();
            int stops = tp.first;
            int node = tp.second;
            int dis = tp.third;
            
            if(stops > k){
                continue;
            }
            
            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int wt = it.second;
                
                if(stops <= k && dis + wt < dist[adjNode]){
                    dist[adjNode] = dis + wt;
                    q.add(new Tuple(stops+1, adjNode, dist[adjNode]));
                }
            }
        }
        
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }
}

class Pair{
    int first;
    int second;
    
    public Pair(int i, int j){
        first = i;
        second = j;
    }
}

class Tuple{
    int first;
    int second;
    int third;
    
    public Tuple(int i, int j, int k){
        first = i;
        second = j;
        third = k;
    }
}
