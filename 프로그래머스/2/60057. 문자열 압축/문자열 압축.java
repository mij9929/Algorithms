class Solution {
    public int solution(String s) {
        int answer = s.length(); // 최대 압축 길이는 일단 주어진 문자열의 길이로 초기화
        int length = s.length();
        
        // 문자열을 1개 단위부터 length/2개 단위까지 자르면서 압축
        for (int unit = 1; unit <= length / 2; unit++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, unit); // 이전에 비교한 문자열
            int count = 1; // 반복되는 횟수
            
            // 단위(unit)만큼씩 자르며 압축 진행
            for (int i = unit; i < length; i += unit) {
                String current;
                if (i + unit > length) { // 마지막 남은 부분은 unit만큼 자를 수 없을 때
                    current = s.substring(i);
                } else {
                    current = s.substring(i, i + unit);
                }
                
                if (prev.equals(current)) { // 이전 문자열과 같은 경우 반복 횟수 증가
                    count++;
                } else { // 이전 문자열과 다른 경우
                    compressed.append(count > 1 ? count : "").append(prev); // 압축된 문자열 추가
                    prev = current; // 이전 문자열 갱신
                    count = 1; // 반복 횟수 초기화
                }
            }
            
            // 남은 문자열 처리
            compressed.append(count > 1 ? count : "").append(prev);
            
            // 압축된 문자열의 길이와 현재까지의 최소 길이 비교하여 갱신
            answer = Math.min(answer, compressed.length());
        }
        
        return answer;
    }
}
