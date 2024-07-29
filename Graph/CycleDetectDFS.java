class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(isCycleUtil(adj, vis, i, -1)) return true;
            }
        }
        
        return false;
    }
    
    static boolean isCycleUtil(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int curr, int par){
        vis[curr] = true;
        
        for(int adjNode : graph.get(curr)){
            if(!vis[adjNode]){
                if(isCycleUtil(graph, vis, adjNode, curr)){
                    return true;
                }
            } else if(par != adjNode){
                return true;
            }
        }
        
        return false;
    }
}
