class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int curr : adj.get(i)){
                indegree[curr]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;
        
        while(!q.isEmpty()){
            int node = q.remove();
            count++;
            
            for(int adjNode : adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0){
                    q.add(adjNode);
                }
            }
        }
        
        if(count == V){
            return false;
        }
        
        return true;
    }
}
