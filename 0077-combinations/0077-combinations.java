import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        
        backtrack(1, new ArrayList<>(), n, k, ans);
        return ans;
    }
    private void backtrack(int start, List<Integer> curr, int n, int k, List<List<Integer>> ans){
        // basecase
        if(curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        // recursive call
        for(int i = start; i<=n; i++){
            curr.add(i);
            backtrack(i+1, curr, n, k, ans);
            curr.remove(curr.size()-1);
        }
    }
}
