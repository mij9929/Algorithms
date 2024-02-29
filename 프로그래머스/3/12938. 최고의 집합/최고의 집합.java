class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n>s) return new int[] {-1};
        
        int q = s / n;
        int r = s % n;
        
        for(int i=0; i<n; i++){
            if(i < n - r)
                answer[i] = q;
            else
                answer[i] = q+1;
        }
        return answer;
    }
}