import java.util.*;
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] t: times){
            if(!graph.containsKey(t[0])){
                graph.put(t[0], new ArrayList<>());
            }
            graph.get(t[0]).add(new int[]{t[1], t[2]});
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{k, 0});

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        dist[k] = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int node = cur[0];
            int time = cur[1];

            if(graph.containsKey(node)){
                for(int[] g: graph.get(node)){
                    int nextNode = g[0];
                    int nextTime = g[1]+time;

                    if(nextTime<dist[nextNode]){
                        dist[nextNode] = nextTime;
                        queue.offer(new int[]{nextNode, nextTime});
                    }
                }
            }
        }

        int answer=-1;
        for(int d: dist){
            if(d==Integer.MAX_VALUE) return -1;
            answer = Math.max(answer,d);
        }
        return answer;
    }
}