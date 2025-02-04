import java.util.*;

class Solution {
    public int[] price;
    public int[] ans = new int[2];
    public int[] percentage = new int[] {10, 20, 30, 40};
    
    public int applyDiscount(int price, int discountRate) {
        return (int) (price - price * discountRate / 100.0);
    }
    
    public int[] buy(int[][] users, int[] emoticons) {
        int[] result = new int[2];
        for(int i=0; i<users.length; i++){
            int percent = users[i][0];
            int money = users[i][1];
            int sum = 0;
            for(int j=0; j<price.length; j++){
                if(percent <= price[j]) {
                    sum += applyDiscount(emoticons[j], price[j]);
                }
            }
            if(sum <= money) {
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
            price[cnt] = percentage[i];
            combination(cnt+1, idx, emoticons, users);
        }
    } 
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        price = new int[emoticons.length];
        
        // 목표 : 
        // 1. 가입자 최대한 늘리기
        // 2. 판매액 최대
        // n명에게 m개 할인 판매 (10, 20, 30, 40%)
        // 사용자는 본인 기준에 따라 가입
        // - 본인 기준 일정 비율 이상 할인 이모티콘 모두 구매 -> 모두 구매한 가격이 가진 돈보다 크면 서비스 가입
        
        // 10부터 할인 가격 40까지 확인 (중복 순열)
        // 가입자 수와 가격 비교 
        
        combination(0,0, emoticons, users);
        return ans;
    }
}