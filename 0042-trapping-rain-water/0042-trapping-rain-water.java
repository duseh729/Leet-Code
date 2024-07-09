// 1. 문제 파악
// height 배열이 주어지는데 height는 블록의 높이이다. 그리고 양 옆의 블록이 현재 의 블록보다 높으면 빗물을 담을 수 있다. 예를 들어 [1, 0, 1]이라면 빗물을 1만큼 담을 수 있다.
// 2. 접근 방법
// 스택으로 앞에서부터 높거나 같다면 pop을 해준 후 차이나는 index - 1 만큼 하면 빗물의 높이를 구할 수 있을 거 같다.

import java.util.*;

class Solution {
    public int trap(int[] height) {
        Stack<Integer> rainStack = new Stack<>();

        int answer = 0;

        for(int i=0; i<height.length; i++){
                while(!rainStack.isEmpty() && height[rainStack.peek()]<height[i] ){
                    int currentStackItem = rainStack.pop();
                    if(rainStack.isEmpty()){
                        rainStack.push(i);
                        break;
                    }
                    int distance = i-rainStack.peek()-1;
                    int waters = Math.min(height[i], height[rainStack.peek()]) - height[currentStackItem];
                    answer+=distance*waters;
                }
            rainStack.push(i);
            // System.out.println(i + ": " +rainStack);
        }
        return answer;
    }
}