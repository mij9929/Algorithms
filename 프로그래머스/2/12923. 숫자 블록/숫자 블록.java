class Solution {
    public int[] solution(long begin, long end) {
        int size = (int) (end - begin + 1);
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++) {
            long num = begin + i;
            answer[i] = getMaxBlock(num);
        }
        
        return answer;
    }
    
    private int getMaxBlock(long num) {
        if (num == 1) return 0; // 1번 위치에는 항상 0
        
        int maxBlock = 1; // 최소한 1은 항상 약수
        
        // 약수를 구할 때 sqrt(n)까지만 탐색하여 성능 최적화
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                long pair = num / i; // i와 짝이 되는 약수
                
                // num이 i로 나누어 떨어지면 두 개의 약수를 확인
                if (pair <= 10_000_000) return (int) pair; // 큰 값부터 확인
                if (i <= 10_000_000) maxBlock = (int) i;  
            }
        }
        return maxBlock;
    }
}
