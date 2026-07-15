import java.util.*;

class Solution {
    public Map<String, Integer> words;
    public int[] solution(String msg) {
        ArrayList<Integer> result = new ArrayList<>();
        words = new HashMap<>();
        // 단어 초기화
        for(int i=0; i<26; i++) {
            char ch = (char)('A' + i);
            words.put(String.valueOf(ch), i+1);
        }
        
        int len = msg.length();
        for(int idx = 0; idx<len; idx++) {
            StringBuilder sb = new StringBuilder();
            for(int i = idx; i < len; i++) {
                sb.append(msg.charAt(i));
                
                if(words.containsKey(sb.toString()) && i == len-1) {
                    result.add(words.get(sb.toString()));
                    idx = i;
                    break;
                }
                
                else if(!words.containsKey(sb.toString())){
                    words.put(sb.toString(), words.size()+1);
                    sb.deleteCharAt(sb.length()-1);
                    result.add(words.get(sb.toString()));
                    idx = i-1;
                    break;
                }
            }
            
        } 
        
        int[] answer = {};
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}