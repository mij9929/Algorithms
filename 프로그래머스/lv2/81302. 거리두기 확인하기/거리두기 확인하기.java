import java.lang.Math;
// 세로 파티션 체크.

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            if (checkDistance(places[i], i)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    public int isManhattanDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public boolean hasPartition(String[] place, int r1, int c1, int r2, int c2) {
        if(r1 > r2){
            int temp = r1;
            r1 = r2;
            r2 = temp;
        }
        
        if(c1 > c2){
            int temp = c1;
            c1 = c2;
            c2 = temp;
        }
        
        int partitionTotalCount = 0; // 파티션의 개수는 직사각형은=1 , 정사각형=2가 되어야함. 
        if(c2 > c1) partitionTotalCount++;
        if(r2 > r1) partitionTotalCount++;
        
        int partitionCount = 0;
        
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                if(place[i].charAt(j) == 'X'){
                    partitionCount++;
                }
            }
        }
        
        return partitionCount == partitionTotalCount;
    }

    public boolean checkDistance(String[] place, int k) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    for (int r = 0; r < 5; r++) {
                        for (int c = 0; c < 5; c++) {
                            if (place[r].charAt(c) == 'P' && !(i == r && j == c)) {
                                if(isManhattanDistance(i,j,r,c) == 2) {
                                    if(!hasPartition(place,i,j,r,c)){
                                        System.out.println(k + ": " + i + "," + j + "," + r + "," + c);
                                        return false;
                                    } 
                                }
                                else if(isManhattanDistance(i,j,r,c) < 2) {
                                        return false;
                                }
                                
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
