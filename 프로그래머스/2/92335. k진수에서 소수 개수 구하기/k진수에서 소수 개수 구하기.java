import java.lang.Math;

class Solution {
    public boolean isPrime(long num){
        if(num == 1)  return false;
        long end = (long)Math.sqrt(num) + 1;
        for(int i=2;i<end;i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            int reminder = n%k;
            sb.insert(0, Integer.toString(reminder));
            n = n/k;
        }
        
        String converted = sb.toString();
        int len = converted.length();
        long prime = 0;
        for(int i=0; i<len; i++){
            long num = (int) (converted.charAt(i) - '0');
            if(num != 0){
                prime *= 10;
                prime += num;
                
            }
            if(num ==0 || i == len-1){
                if(prime !=0 && isPrime(prime)) {
                    answer++;
                }
                prime = 0;
            }
            
        }
        
        return answer;
    }
}