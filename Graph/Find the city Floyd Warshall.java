class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = (int)1e9;
            }
        }

        for(int[] it : edges){
            mat[it[0]][it[1]] = it[2];
            mat[it[1]][it[0]] = it[2];
        }

        for(int i = 0; i < n; i++){
            mat[i][i] = 0;
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(mat[i][k] == (int)1e9 || mat[k][j] == (int)1e9){
                        continue;
                    }
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        int countCity = n;
        int cityNo = -1;

        for(int city = 0; city < n; city++){
            int cnt = 0;
            for(int adjCity = 0; adjCity < n; adjCity++){
                if(mat[city][adjCity] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= countCity){
                countCity = cnt;
                cityNo = city;
            }
        }

        return cityNo;
    }
}
