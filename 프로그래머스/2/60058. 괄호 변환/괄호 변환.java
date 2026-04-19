import java.util.*;

class Solution {

     public String solution(String p) {
        return recursion(p);
     }
    
    public String recursion(String p) {
        if(p.length() == 0) return "";
        
        if(isCorrect(p)) return p; // 바로 올바른 문자열이면 return;
        
        List<String> result = split(p);
        String u = result.get(0);
        String v = result.get(1);
        
        if(isCorrect(u)) return u + recursion(v); // u가 올바르면, v에 대해 재귀
        
        String remain = "(" + recursion(v) + ")"; // 일단 앞 뒤로 () 붙이고, v에 대해 재귀, 위에 u는 없는셈?
        for(int i=1; i<u.length()-1; i++) {
            if(u.charAt(i) == '(') remain += ')';
            else remain += '(';
        }
        
        return remain;
    }
    
    public List<String> split(String p) {
        String u = "";
        String v = "";
        int index = 0;
        int checkPoint = 0;
        if(p.charAt(0) == '(') checkPoint++;
        else checkPoint--;
        
        for(int i= 1; i<p.length(); i++) {
            if(p.charAt(i) == '(') checkPoint++;
            else checkPoint--;
            
            if(checkPoint == 0) {
                index = i;
                break;
            }
        }
        
        u = p.substring(0, index+1);
        v = p.substring(index+1);
        ArrayList<String> list = new ArrayList<>();
        list.add(u);
        list.add(v);
        
        return list;
    }
    
    public boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(s.charAt(i));
            else {
                if(stack.size() == 0) return false;
                stack.pop();
            }
        }
        
        return stack.size() == 0;
    }
}