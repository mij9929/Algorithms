import java.util.*;
import java.lang.Math;

class Solution {
    public int[] swap(int i, int j){
        return new int[] {j, i};
    }
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int height = 0;
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]) sizes[i] = swap(sizes[i][0], sizes[i][1]);
            width = Math.max(width, sizes[i][0]);
            height = Math.max(height, sizes[i][1]);
        }
        
        return width*height;
    }
}