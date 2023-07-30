import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        String temp = "";
        for(int i=0; i<len; i++){
            if(s.charAt(i)-48 >= 0 && s.charAt(i)-48 <= 9){
                answer*=10;
                answer += s.charAt(i)-48;
            }
            else{
                temp+=s.charAt(i);
                int result = charNumToInt(temp);
                if(result != -1){
                    answer*=10;
                    answer += result;
                    temp = "";
                    
                }
            }
        }
        
        return answer;
    }
    
    public int charNumToInt(String word){
        if(word.equals("zero")) return 0;
        else if(word.equals("one")) return 1;
        else if(word.equals("two")) return 2;
        else if(word.equals("three")) return 3;
        else if(word.equals("four")) return 4;
        else if(word.equals("five")) return 5;
        else if(word.equals("six")) return 6;
        else if(word.equals("seven")) return 7;
        else if(word.equals("eight")) return 8;
        else if(word.equals("nine")) return 9;
        else return -1;
        
        
    }
}