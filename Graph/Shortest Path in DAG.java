class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i = 0; i < N; i++){
		    ArrayList<Pair> temp = new ArrayList<>();
		    adj.add(temp);
		}
		for(int i = 0; i < M; i++){
		    int u = edges[i][0];
		    adj.get(u).add(new Pair(edges[i][1], edges[i][2]));
		}
		
		//step 1 : find topo
		Stack<Integer> st = new Stack<>();
		int[] vis = new int[N];
		for(int i = 0; i < N; i++){
		    if(vis[i] == 0){
		        topoSort(adj, i, vis, st);
		    }
		}
		
		// step-2 : shortest dist
		int[] dist = new int[N];
		for(int i = 0; i < N; i++){
		    dist[i] = (int)(1e9);
		}
		int src = 0;   //here taking src as 0
		dist[src] = 0;
		
		while(!st.isEmpty()){
		    int curr = st.pop();
		    
		    for(int i = 0; i < adj.get(curr).size(); i++){
		        int v = adj.get(curr).get(i).first;
		        int wt = adj.get(curr).get(i).second;
		        
		        if(dist[curr] + wt < dist[v]){
		            dist[v] = dist[curr] + wt;
		        }
		    }
		}
		
		for (int i = 0; i < N; i++) {
        if (dist[i] == 1e9) dist[i] = -1;
    }
		
		return dist;
	}
	
	static void topoSort(ArrayList<ArrayList<Pair>> adj, int curr, int[] vis, Stack<Integer> st){
	    vis[curr] = 1;
	    
	    for(int i = 0; i < adj.get(curr).size(); i++){
	        int adjNode = adj.get(curr).get(i).first;
	        if(vis[adjNode] == 0){
	            topoSort(adj, adjNode, vis, st);
	        }
	    }
	    
	    st.push(curr);
	}
}

class Pair {
    int first;
    int second;
    
    public Pair(int i, int j){
        this.first = i;
        this.second = j;
    }
}
