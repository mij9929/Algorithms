import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        int rol = arr1.length;
        int col = arr2[0].length;
        
        // 곱셈행렬 size = r1 * c2
        // 3*2 행렬, 2*2행렬 => 3*2행렬
        answer = new int[rol][col];
        
        for(int i=0; i<rol; i++) {
            for(int j=0; j<col; j++) {
                for(int k=0; k<arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}