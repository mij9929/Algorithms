import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> relation = new HashMap<>();
        Map<String, Integer> money = new HashMap<>();
        
        for(int i=0; i<enroll.length; i++) {
            relation.put(enroll[i], referral[i]);
            money.put(enroll[i], 0);
        }
        
        for(int i=0; i<seller.length; i++) {
            String s = seller[i];
            int pay = amount[i] * 100;
            
            while(true) {
                int portion = pay / 10; // 뺏기는 돈
                int mine = pay - portion; // 내 돈
                money.put(s, money.get(s) + mine);
                
                s = relation.get(s);
                if(s.equals("-")) break;
                pay = portion;
                if(portion == 0) break;
            }
        }
        
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++)
            answer[i] = money.get(enroll[i]);
        
        return answer;
    }
}