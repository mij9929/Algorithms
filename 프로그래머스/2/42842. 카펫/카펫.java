class Solution {
    public int[] solution(int brown, int yellow) {
        
        int sum = brown/2 + 2; // 가로와 세로의 합
        int garo = sum - 3;
        int sero = 3;
        while(garo >= sero){
            if((garo-2)*(sero-2) == yellow)
                break;
            garo--;
            sero++;
        }
        int[] answer = new int[2];
        answer[0] = garo;
        answer[1] = sero;
        
        return answer;
    }
}