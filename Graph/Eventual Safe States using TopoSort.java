class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<List<Integer>> adjRev = new ArrayList<>();
        int[] inDeg = new int[V];
        
        for(int i = 0; i < V; i++){
            adjRev.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++){
            for(int adjNode : adj.get(i)){
                adjRev.get(adjNode).add(i);
                inDeg[i]++;
            }
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            for(int adjNode : adjRev.get(curr)){
                inDeg[adjNode]--;
                if(inDeg[adjNode] == 0){
                    q.add(adjNode);
                }
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}
