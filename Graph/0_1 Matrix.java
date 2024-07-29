class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] ans = new int[n][m];

        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int[] delrow = {+1, 0, -1, 0};
        int[] delcol = {0, -1, 0, +1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            ans[row][col] = steps;
                for(int i = 0; i < 4; i++){
                int ro = row + delrow[i];
                int co = col + delcol[i];

                if(ro >= 0 && ro < n && co >= 0 && co < m
                   && vis[ro][co] == 0){
                    vis[ro][co] = 1;
                    q.add(new Node(ro, co, steps+1));
                }
            }
            
        }

        return ans;
    }
}

class Node {
    int first;
    int second;
    int third;

    public Node(int i, int j, int k){
        this.first = i;
        this.second = j;
        this.third = k;
    }
}
