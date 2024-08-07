class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        //step-1 build a sorted stack
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                topo(i, adj, vis, st);
            }
        }
        
        //step2 : Reverse the graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjT.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
            //again mark it zero to be used in dfs3
            vis[i] = 0;
            for(int it : adj.get(i)){
                //i -> it
                //it -> i
                adjT.get(it).add(i);
            }
        }
        
        //step3 : do the normal dfs(dfs3)
        int scc = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(vis[node] == 0){
                scc++;
                dfs3(node, adjT, vis);
            }
        }
        
        return scc;
    }
    
    static void topo(int curr, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st){
        vis[curr] = 1;
        
        for(int adjNode : adj.get(curr)){
            if(vis[adjNode] == 0){
                topo(adjNode, adj, vis, st);
            }
        }
        
        st.push(curr);
    }
    
    static void dfs3(int curr, ArrayList<ArrayList<Integer>> adjT, int[] vis){
        vis[curr] = 1;
        
        for(int adjNode : adjT.get(curr)){
            if(vis[adjNode] == 0){
                dfs3(adjNode, adjT, vis);
            }
        }
    }
}
