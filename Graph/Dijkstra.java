class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        pq.add(new Pair(0, S));
        dist[S] = 0;
        
        while(!pq.isEmpty()){
            int node = pq.peek().second;
            pq.remove();
            
            for(int i = 0; i < adj.get(node).size(); i++){
                int wt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                
                if(dist[node] + wt < dist[adjNode]){
                    dist[adjNode] = dist[node] + wt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        
        return dist;
    }
}

class Pair{
    int dist;
    int second;
    
    public Pair(int i, int j){
        this.dist = i;
        this.second = j;
    }
}

