import java.util.*;
class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int answer = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(grid, visited, i, j);
                    answer++;
                }
            }
        }

        // for(boolean[] v: visited){
        //     System.out.println(Arrays.toString(v));
        // }
        return answer;
    }
    void dfs(char[][] grid,boolean[][] visited, int i, int j){
        // System.out.println(i + " " +j);
        visited[i][j]=true;

        if(i>0&&grid[i-1][j]=='1'&&!visited[i-1][j]){
            dfs(grid, visited, i-1, j);
        }
        if(i<grid.length-1&&grid[i+1][j]=='1'&&!visited[i+1][j]){
            dfs(grid, visited, i+1, j);
        }
        if(j>0&&grid[i][j-1]=='1'&&!visited[i][j-1]){
            dfs(grid, visited, i, j-1);
        }
        if(j<grid[0].length-1&&grid[i][j+1]=='1'&&!visited[i][j+1]){
            dfs(grid, visited, i, j+1);
        }
    }
}