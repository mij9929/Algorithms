import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            graph[from].add(to);
            graph[to].add(from);
        }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next : graph[now]) {
                if(distance[next] != -1) continue;
                
                distance[next] = distance[now] + 1;
                queue.offer(next);
            }
        }
        
        int maxDistance = 0;
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distance[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                answer++;
            }
        }
        
        return answer;
    }
}