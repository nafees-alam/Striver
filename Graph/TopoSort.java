class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, vis, st, adj);
            }
        }
        
        int[] ans = new int[V];
        int i = 0;
        while(!st.isEmpty()){
            ans[i] = st.pop();
            i++;
        }
        
        return ans;
    }
    
    static void dfs(int curr, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        vis[curr] = 1;
        
        for(int adjNode : adj.get(curr)){
            if(vis[adjNode] == 0){
                dfs(adjNode, vis, st, adj);
            }
        }
        st.push(curr);
    }
}
