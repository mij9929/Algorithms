import java.lang.Math;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        double y1Point = 0;
        double y2Point = 0;
        
        long r1Pow = (long)Math.pow(r1,2);
        long r2Pow = (long)Math.pow(r2,2);
        
        for(int i=0; i<=r2; i++){
         
            if(i<=r1)
                y1Point = (long)Math.sqrt(r1Pow-(long)Math.pow(i,2));
            else
                y1Point = 0;
            
            y2Point = (long)Math.sqrt(r2Pow-(long)Math.pow(i,2));
            
            answer += (y2Point - y1Point)*4;
            
            if(Math.sqrt(r1Pow-Math.pow(i,2))%1.0 == 0.0) 
                answer+=4;
        }
        
     
        answer -= 4;

        
        return answer;
    }
    
}