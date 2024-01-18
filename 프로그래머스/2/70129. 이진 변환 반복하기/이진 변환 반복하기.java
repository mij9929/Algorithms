class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        
        while(s.equals("1") == false){
            String removeString = s.replace("0","");
            int zeroCount = s.length() - removeString.length();
            s = Integer.toBinaryString(removeString.length());
            answer[0]++;
            answer[1] += zeroCount;
        }
        
        return answer;
    }
}