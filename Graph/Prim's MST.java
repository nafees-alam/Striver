class Solution {

  // YOU CAN ALSO CALCULATE THE NODE AND PATH OF MST(SEE STRIVER'S VIDEO)
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.second - y.second);
        pq.add(new Pair(0, 0));
        int[] vis = new int[V];
        int sum = 0;
        
        while(!pq.isEmpty()){
            int node = pq.peek().first;
            int dis = pq.peek().second;
            pq.remove();
            
            if(vis[node] == 1) continue;
            vis[node] = 1;
            sum += dis;
            
            for(int i = 0; i < adj.get(node).size(); i++){
                int wt = adj.get(node).get(i)[1];
                int adjNode = adj.get(node).get(i)[0];
                
                if(vis[adjNode] == 0){
                    pq.add(new Pair(adjNode, wt));
                }
            }
        }
        
        return sum;
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
