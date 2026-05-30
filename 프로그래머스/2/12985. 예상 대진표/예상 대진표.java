class Solution
{
    public int solution(int n, int a, int b)
    {
        // 바로 만나면 최소 1경기는 하기 때문에
        int answer = 1;
        while((a+1)/2 != (b+1)/2){
            a = (a+1)/2;
            b = (b+1)/2;
            answer++;
        }

        return answer;
    }
}