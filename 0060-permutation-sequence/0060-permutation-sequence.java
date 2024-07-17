import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        ArrayList<String> answer = new ArrayList<>();

        backtrack(new StringBuilder(), n, visited, answer, k);
        
        // System.out.println(answer);
        return answer.get(k-1);
    }
    private void backtrack(StringBuilder sb, int n, boolean[] visited, ArrayList answer, int k){
        if(answer.size()==k){
            return;
        }
        if(sb.length()==n){
            // System.out.println(sb.length()+ " " + sb);
            answer.add(sb.toString());
            return;
        }

        for(int i=1; i<=n; i++){
            if(visited[i-1]) continue;
            sb.append(i);
            visited[i-1] = true;
            backtrack(sb, n, visited, answer, k);

            visited[i-1] = false;
            sb.deleteCharAt(sb.length()-1);
        }

    }
}