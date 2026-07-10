class Solution {
    public int[] numbers;
    public int target;
    public int[] acc;
    public int answer;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        answer = 0;
        acc = new int[]{-1, 1};
        dfs(0, 0);
        return answer;
    }

    public void dfs(int depth, int result) {
        if(depth == numbers.length) {
            if(result == target) {
                answer++;
            }
            return;
        }

        for(int i = 0; i < acc.length; i++) {
            dfs(depth+1, result + acc[i] * numbers[depth]);
        }
    }
}