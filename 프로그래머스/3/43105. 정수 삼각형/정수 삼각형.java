class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] arr = new int[n+1][n+1];
		int[] dp = new int[n];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				arr[i][j] = triangle[i-1][j-1] + Math.max(arr[i-1][j-1], arr[i-1][j]);
			}
		}
		
		int max = -1;
		for(int i=1; i<n+1; i++)
		{
			if(max < arr[n][i]) max = arr[n][i];
		}
		
		answer = max;
        return answer;
    }
}