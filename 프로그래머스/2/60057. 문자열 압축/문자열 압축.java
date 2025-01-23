class Solution {
    public int solution(String s) {
        int answer = s.length();
        int len = s.length();
        
        for(int size=1; size <= len/2; size++){ // 문자 압축률 단위
            StringBuilder compressed = new StringBuilder(); // 압축 문자열 StringBuilder
            String prev = s.substring(0, size); // 이전 단위 문자열
            int count = 1; // 반복 횟수
            
            for(int i = size; i < len; i += size){
                String current;
                if(i + size > len) { // 남은 문자열
                    current = s.substring(i);
                } else {
                    current = s.substring(i, i + size);
                }
                
                if(prev.equals(current)){ // 이전 문자열과 같으면 count++
                    count++;
                } else{ // 다를 경우
                    compressed.append(count > 1 ? count : "").append(prev);
                    prev = current;
                    count = 1;
                }
            }
            
            // 남은 문자열
            compressed.append(count > 1 ? count : "").append(prev);
                
            // 새로운 압축 문자열이 더 작으면 answer 갱신
            answer = Math.min(answer, compressed.length());
        }
        
        return answer;
    }
}