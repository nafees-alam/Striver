class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < K; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            
            for(int j = 0; j < len; j++){
                if(s1.charAt(j) - 'a' != s2.charAt(j) - 'a'){
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        
        ArrayList<Integer> list = topoSort(adj, K);
        String ans = "";
        for(int i : list){
            ans = ans + (char)(i + (int)('a'));
        }
        
        return ans;
    }
    
    static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, int K){
        int[] inDeg = new int[K];
        for(int i = 0; i < K; i++){
            for(int node : adj.get(i)){
                inDeg[node]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < K; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            
            for(int adjNode : adj.get(curr)){
                inDeg[adjNode]--;
                if(inDeg[adjNode] == 0){
                    q.add(adjNode);
                }
            }
        }
        
        return ans;
    }
}
