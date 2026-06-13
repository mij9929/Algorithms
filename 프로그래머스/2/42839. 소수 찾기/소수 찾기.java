import java.util.*;

class Solution {
    Set<Integer> numSet;
    String numbers;
    boolean[] visited;
    int len;
    
    public int solution(String numbers) {
        this.numbers = numbers;
        len = numbers.length();
        numSet = new HashSet<>();
        
        for (int depth = 1; depth <= len; depth++) {
            visited = new boolean[len];
            StringBuilder sb = new StringBuilder();
            permutation(0, depth, sb);
        }
        
        return numSet.size();
    }
    
    public void permutation(int v, int depth, StringBuilder sb) {
        if (v == depth) {
            int num = Integer.parseInt(sb.toString());
            
            if (isPrime(num)) {
                numSet.add(num);
            }
            
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(numbers.charAt(i));
                
                permutation(v + 1, depth, sb);
                
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}