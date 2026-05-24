import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> nameMap = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();

        for(String r : record) {
            String[] split = r.split(" ");
            String command = split[0];
            if(command.equals("Enter") || command.equals("Change")) {
                String uid = split[1];
                String nickname = split[2];
                nameMap.put(uid, nickname);
            }
        }
        
        
        for(String r : record) {
            String[] split = r.split(" ");
            String command = split[0];
            if(command.equals("Enter")) {
                String uid = split[1];
                String nickname = nameMap.get(uid);
                answer.add(nickname +"님이 들어왔습니다.");
            }
            
            else if (command.equals("Leave")) {
                String uid = split[1];
                String nickname = nameMap.get(uid);
                answer.add(nickname +"님이 나갔습니다."); 
            }
            
        }
        
        return answer.toArray(new String[0]);
    }
}