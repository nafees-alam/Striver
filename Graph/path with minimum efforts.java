class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        int[][] dist = new int[n][m];
        for(int[] arr : dist){
            Arrays.fill(arr, (int)1e9);
        }

        dist[0][0] = 0;

        pq.add(new Tuple(0, 0, 0));
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while(!pq.isEmpty()){
            int dis = pq.peek().first;
            int row = pq.peek().second;
            int col = pq.peek().third;
            pq.remove();

            if(row == n-1 && col == m-1){
                    return dis;
                }
            
            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    int effort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), dis);
                    if(effort < dist[nrow][ncol]){
                    dist[nrow][ncol] = effort;
                    pq.add(new Tuple(effort, nrow, ncol));
                    }
                }
            }
        }

        return 0;
    }
}

class Tuple{
    int first;
    int second;
    int third;

    public Tuple(int i, int j, int k){
        first = i;
        second = j;
        third = k;
    }
}
