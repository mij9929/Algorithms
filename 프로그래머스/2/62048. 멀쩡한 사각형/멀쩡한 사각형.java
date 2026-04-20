import java.lang.Math;

class Solution {
    // 가로 길이 W
    // 세로 길이 H
    // 대각선으로 반토막: 대각 길이 루트2
    // 삼각형에서 높이별로, 몇개의 사각형을 구할 수 있는지 체크
    // 대각선에 y좌표별 x 좌표 구하기
    // y = -(h/w * x) + h
    // y = -(3/2 * x) + 12
    // y - h = -(h/w * x)
    // (h - y) * (w/h) = x
    public long solution(int w, int h) {
        long answer = 0;
        double tempX = 0;
        double slope = ((double)w/(double)h);
        for(int i=1; i<=h; i++) {
            tempX = (double)(h - i) * slope;
            
            answer += (long)tempX; 
        }
        return answer*2;
    }
}