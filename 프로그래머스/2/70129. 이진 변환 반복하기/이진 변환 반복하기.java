class Solution {
    public int[] solution(String s) {
        int[] answer = new int[]{0,0};
        int cnt = 0;
        while(!s.equals("1")){
            int prevLen = s.length();
            int len = s.replace("0", "").length();
            s = Integer.toBinaryString(len);
            System.out.println(s);
            answer[0] ++;
            answer[1] += (prevLen - len);
        }
              
       
        return answer;
    }
}