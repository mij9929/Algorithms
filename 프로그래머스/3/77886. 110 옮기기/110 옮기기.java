import java.util.*;

class Solution {
    /**
    모든 110 뽑음
    111보단 (혹은 1만 있을 경우)앞에
    else 가장 뒷자리 0앞에
    **/
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        int idx = 0;
        for(String str : s){
            Stack<Character> st = new Stack<>();
            int cnt = 0;
            for(int i=0; i<str.length(); i++){
                st.push(str.charAt(i));
                if(st.size() >= 3){
                    char s1 = st.pop();
                    if(s1 != '0'){
                        st.push(s1);
                        continue;
                    }
                    char s2 = st.pop();
                    if(s2 != '1'){
                        st.push(s2);
                        st.push(s1);
                        continue;
                    }
                    char s3 = st.pop();
                    if(s3 != '1'){
                        st.push(s3);
                        st.push(s2);
                        st.push(s1);
                        continue;
                    }
                    
                    cnt++;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){
                sb.insert(0, st.pop());
            }
                       
            if(sb.toString().contains("0")){
                int pos = sb.toString().lastIndexOf("0")+1;
                for(int i=0; i<cnt; i++)
                    sb.insert(pos, "110");
            }
            
            else{
                for(int i=0; i<cnt; i++){
                    sb.insert(0, "110");
                }
            }
            
            answer[idx++] = sb.toString();
            
        }
           
        
        return answer;
    }
    
}