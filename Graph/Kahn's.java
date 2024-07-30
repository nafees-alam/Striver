class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] indegree = new int[V];
        
        for(int i = 0; i < V; i++){
            for(int node : adj.get(i)){
                indegree[node]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] ans = new int[V];
        int k = 0;
        
        while(!q.isEmpty()){
            int curr = q.remove();
            ans[k++] = curr;
            
            for(int adjNode : adj.get(curr)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0){
                    q.add(adjNode);
                }
            }
        }
        
        return ans;
    }
}
