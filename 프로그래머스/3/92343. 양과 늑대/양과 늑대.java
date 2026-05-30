import java.util.*;
import java.lang.Math;

class Solution {
    private int answer;
    private int[] info;
    private List<Integer>[] list;
    
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        this.info = info;
        list = new ArrayList[info.length];
        
        for(int i=0; i<info.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges) {
            int parent = edge[0];
            int child = edge[1];
            list[parent].add(child);
        }
        
        List<Integer> candidates = new ArrayList<>();
        
        for(int child : list[0]) {
            candidates.add(child);
        }
        
        // 시작점: 루트노드
        // 루트노드는 양 1마리로 시작
        dfs(1, 0, candidates);
        
        return answer;
    }
    
    private void dfs(int sheep, int wolf, List<Integer> candidates) {
        answer = Math.max(answer, sheep);
        
        for(int next: candidates) {
            int nextSheep = sheep;
            int nextWolf = wolf;
            
            if(info[next] == 0) 
                nextSheep ++;
            else 
                nextWolf++;
            
            if(nextWolf >= nextSheep) // 늑대 수가 양 이상이면 종료
                continue;
            
            // 현재 후보 목록
            List<Integer> nextCandidates = new ArrayList<>(candidates);

            // 이번에 방문할 노드 후보에서 제거
            nextCandidates.remove(Integer.valueOf(next));
            
            // 방문할 노드의 자식들은 후보에 추가,
            for(int child: list[next]) {
                nextCandidates.add(child);
            }
            
            dfs(nextSheep, nextWolf, nextCandidates);
        }
    }
}