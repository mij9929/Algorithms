import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        boolean[] visited = new boolean[y + 1]; // 방문 여부 체크
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0}); // 초기값: {현재 값, 연산 횟수}
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int depth = current[1];

            // 다음 단계 연산
            for (int next : new int[]{value + n, value * 2, value * 3}) {
                if (next == y) return depth + 1; // 목표 값 도달
                if (next > y || visited[next]) continue; // 범위 초과 또는 방문 여부 체크
                
                queue.add(new int[]{next, depth + 1}); // 다음 값 큐에 추가
                visited[next] = true; // 방문 처리
            }
        }

        return -1; // 변환 불가능한 경우
    }
}
