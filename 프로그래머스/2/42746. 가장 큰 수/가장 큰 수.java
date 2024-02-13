import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNum = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strNum[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(strNum, (o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);});
        
        if(strNum[0].equals("0")) return "0"; // 만약 00000으로 나오면 0이어야함
        
        StringBuilder sb = new StringBuilder();
        for(String s : strNum){

            sb.append(s);
        }
        return sb.toString();
    }
}