class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.length; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.second - y.second);
        pq.add(new Pair(0, 0));
        int[] dist = new int[n];
        int[] ways = new int[n];
        ways[0] = 1;
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;
        int mod = 1000000007;

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.first;
            int dis = p.second;

            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int wt = it.second;

                if(dis + wt < dist[adjNode]){
                    dist[adjNode] = dis + wt;
                    ways[adjNode] = ways[node]%mod;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                } else if(dis + wt == dist[adjNode]){
                    ways[adjNode] = (ways[node] + ways[adjNode])%mod;
                }
            }
        }

        return (ways[n-1])%mod;
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
