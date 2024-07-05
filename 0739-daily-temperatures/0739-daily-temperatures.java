import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Arrays.fill(answer, 0);
        
        Deque<int[]> temperaturesStack = new ArrayDeque<>();

        for(int i=0; i<temperatures.length; i++){
            if(temperaturesStack.isEmpty()){
                // 0: index, 1: temperature
                temperaturesStack.push(new int[]{i, temperatures[i]});
            }else{
                while(true){
                    if(temperaturesStack.isEmpty()){
                        temperaturesStack.push(new int[]{i, temperatures[i]});
                        break;
                    }
                    int[] currentStackValue = temperaturesStack.peek();
                    if(currentStackValue[1]<temperatures[i]){
                        answer[currentStackValue[0]] = i-currentStackValue[0];
                        temperaturesStack.pop();
                    }else{
                        temperaturesStack.push(new int[]{i, temperatures[i]});
                        break;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(temperaturesStack.peek()));

        return answer;
    }
}