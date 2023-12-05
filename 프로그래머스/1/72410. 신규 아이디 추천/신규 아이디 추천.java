class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]",""); // 정규식
        new_id = new_id.replaceAll("\\.+", ".");
        new_id = new_id.replaceAll("^\\.+|\\.+$", "");
        int len = new_id.length();
        if(len == 0) {
            new_id += "a";
        }
        else if(len >= 16){
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("\\.+$", "");
        }
        while(len < 3){
            new_id += new_id.charAt(new_id.length()-1);
            len = new_id.length();
        }
        
        answer = new_id;
        
        return answer;
    }
}