class Solution {
    public String solution(String s, int n) {
        String answer = "";
        int len = s.length();
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            if(c == ' ') {
                answer += c;
                continue;
            }
            if(c >= 'a'){
                if(c + n > 'z') c = (char)(c + n - 26);
                else c = (char)(c + n);
            }
            else {
                if(c + n > 'Z') c = (char)(c + n - 26);
                else 
                    c = (char)(c + n);
            }
            
            answer += c;
            
        }
        
        return answer;
    }
}