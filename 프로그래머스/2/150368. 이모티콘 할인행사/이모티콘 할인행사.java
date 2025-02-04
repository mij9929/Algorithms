import java.util.*;

class Solution {
    public int[] price;
    public int[] ans = new int[2];
    
    public int[] buy(int[][] users, int[] emoticons) {
        int[] result = new int[2];
        for(int i=0; i<users.length; i++){
            int percent = users[i][0];
            int money = users[i][1];
            int sum = 0;
            for(int j=0; j<price.length; j++){
                if(percent <= price[j]) {
                    sum += (emoticons[j] - ((emoticons[j] * price[j])/100));
                }
            }
            if(sum < money) {
                result[1] += sum;
            } else {
                result[0]++;
            }
        }
        
        return result;
    }
    
    public void combination(int cnt, int idx, int[] emoticons, int[][] users){
        if(cnt == emoticons.length){
            int[] temp = buy(users, emoticons);
            if(ans[0] < temp[0]) {
                ans[0] = temp[0];
                ans[1] = temp[1];
            } else if(ans[0] == temp[0]) {
                if(ans[1] < temp[1]){
                    ans[1] = temp[1];
                }
            }
            return;
        }
        
        for(int i=idx; i<4; i++){
            price[cnt] = (i+1) * 10;
            combination(cnt+1, idx, emoticons, users);
        }
    } 
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        price = new int[emoticons.length];        
        combination(0,0, emoticons, users);
        return ans;
    }
}