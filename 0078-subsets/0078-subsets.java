import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        backtrack(answer, new ArrayList<>(), nums, 0);
        return answer;
    }
    private void backtrack(List<List<Integer>> answer, List<Integer> curr, int[] nums, int start){
        // System.out.println(curr);
        // basecase
        answer.add(new ArrayList<>(curr));

        // recursive call
        for(int i=start; i<nums.length; i++){
            curr.add(nums[i]);
            backtrack(answer, curr, nums, i+1);
            curr.remove(curr.size()-1);
        }
        return;
    }
}