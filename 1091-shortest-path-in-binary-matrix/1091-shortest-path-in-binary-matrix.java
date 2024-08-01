import java.util.*;
class Solution {    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int n=grid.length;
        boolean[][] visited = new boolean[n][n];

        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];
            int dist = temp[2];
            if(r==n-1 && c==n-1) return dist;

            for(int i=0; i<8; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0){
                    if(!visited[nr][nc]){
                        visited[nr][nc]=true;
                        queue.add(new int[]{nr, nc, dist+1});
                    }
                }
            }
        }

        return -1;
    }
}