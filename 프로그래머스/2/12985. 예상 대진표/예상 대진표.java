class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        a-=1;
        b-=1;
        while(a/2 != b/2){
            a/=2;
            b/=2;
            answer++;
        }

        return answer;
    }
}