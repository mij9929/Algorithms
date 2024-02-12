class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        for(int[] query : queries){
            String subString = my_string.substring(query[0],query[1]+1);

            int len = subString.length();
            String reverseSubString = "";
            for(int i=len-1; i>=0; i--){
                reverseSubString += subString.charAt(i);
            }
            my_string = 
                my_string.substring(0,query[0]) 
                + reverseSubString + my_string.substring(query[1]+1, my_string.length());
        }
        
        return answer = my_string;
    }
}