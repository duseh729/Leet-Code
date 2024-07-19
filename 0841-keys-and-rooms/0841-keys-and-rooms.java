import java.util.*;

class Solution {
    static boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        
        dfs(0, rooms);
        
        for(int i = 0; i<visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    static void dfs(int index, List<List<Integer>> rooms){
        visited[index] = true;
        List<Integer> temp = rooms.get(index);

        while(!temp.isEmpty()){
            int cur = temp.get(0);
            temp.remove(0);
            dfs(cur, rooms);
        }
    }
}