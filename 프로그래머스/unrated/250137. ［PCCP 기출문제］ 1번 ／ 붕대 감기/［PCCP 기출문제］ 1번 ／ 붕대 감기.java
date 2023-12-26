class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int lastAttackTime = attacks[attacks.length-1][0];
        int idx = 0;
        int success = 0;
        int maxHealth = health;
        for(int i=1; i<=lastAttackTime; i++){
            if(attacks[idx][0] == i){
                health -= attacks[idx][1];
                idx++;
                success=0;
                if(health <= 0)
                    return -1;
                else
                    continue;
            }
    
            health += bandage[1];
            success++;
            if(success == bandage[0]){
                health += bandage[2];
                success=0;
            }
            
            if(health >= maxHealth)
                health = maxHealth;
        }
    
        return answer = health;
    }
}