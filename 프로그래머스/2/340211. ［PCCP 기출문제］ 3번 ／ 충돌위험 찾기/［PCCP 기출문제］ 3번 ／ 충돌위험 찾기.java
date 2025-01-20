import java.util.*;

class Solution {
    // 시간 -> 로봇들이 지나온 좌표 리스트
    Map<Integer, List<int[]>> map = new HashMap<>();
    
    public void robotMove(int[] routes, int[][] points){
        int startX = points[routes[0] - 1][0];
        int startY = points[routes[0] - 1][1];
        int[] newPosition = {startX, startY}; 
        map.putIfAbsent(0, new ArrayList<>());  
        map.get(0).add(newPosition);
        int idx = 1;  // 시작 위치 이후부터 진행
        
        // 경로를 따라 이동
        for (int i = 1; i < routes.length; i++) {
            int nextX = points[routes[i] - 1][0];
            int nextY = points[routes[i] - 1][1];
            
            // 이동을 완료할 때까지
            while (startX != nextX || startY != nextY) {
                if (startX < nextX) startX++;
                else if (startX > nextX) startX--;
                else if (startY < nextY) startY++;
                else if (startY > nextY) startY--;
                
                newPosition = new int[]{startX, startY};  // 새로운 위치
                map.putIfAbsent(idx, new ArrayList<>());
                map.get(idx).add(newPosition);
                idx++;
            }
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int robotsCount = routes.length;
        
        // 로봇들의 이동 경로 기록
        for (int i = 0; i < robotsCount; i++) {
            robotMove(routes[i], points);
        }
        
        // 충돌 파악
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            List<int[]> list = new LinkedList<>();
            
            for (int[] arr : entry.getValue()) {
                // 중복 체크 후 리스트에 추가
                boolean isDuplicate = false;
                for (int[] existingArr : list) {
                    if (Arrays.equals(existingArr, arr)) {
                        isDuplicate = true;  // 중복 발견
                        break;
                    }
                }
                if (!isDuplicate) {
                    list.add(arr);  // 중복되지 않으면 추가
                }
            }
            
            for(int[] arr : list){
                int cnt = 0;
                for(int[] entryArr : entry.getValue()){
                    if(Arrays.equals(arr, entryArr)){
                        cnt++;
                    }
                }
                if(cnt > 1) answer++;   
            }
        }
        
        
        return answer;  // 충돌 횟수 반환
    }
}
