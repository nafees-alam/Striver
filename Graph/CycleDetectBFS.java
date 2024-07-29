class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(isCycleUtil(adj, vis, i)) return true;
            }
        }
        
        return false;
    }
    
    static boolean isCycleUtil(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int src){
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        
        while(!q.isEmpty()){
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();
            
            for(int i = 0; i < graph.get(node).size(); i++){
                int dest = graph.get(node).get(i);
                if(!vis[dest]){
                    vis[dest] = true;
                    q.add(new Pair(dest, node));
                } else if(dest != par) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

class Pair{
    int first;
    int second;
    
    public Pair(int i, int j){
        this.first = i;
        this.second = j;
    }
}
