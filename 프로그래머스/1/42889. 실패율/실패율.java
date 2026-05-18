import java.util.*;

class Stage {
    public int stage;
    public int failCount;
    public int totalCount;
    public double failPercent;
    public Stage(int stage) {
        this.stage = stage;
        this.totalCount = 0;
        this.failCount = 0;
        this.failPercent = 0;
    }
}
class Solution {
    // 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        Stage[] s = new Stage[N];
        for(int i=0; i<N; i++) {
            Stage st = new Stage(i+1);
            s[i] = st;
        }
        
        int idx = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<stages.length; j++) {
                // 현재 해당 스테이지에 머무르고 있으면 failCount++
                if(s[i].stage == stages[j]) s[i].failCount++;
                // 현재 해당 스테이지에 머무르고 있거나, 더 높으면 totalCount++
                if(s[i].stage <= stages[j]) s[i].totalCount++;
            }
            if(s[i].totalCount == 0) {
                s[i].failPercent = 0;
                continue;
            }
            s[i].failPercent = (double)(s[i].failCount) / (double)(s[i].totalCount);
        }
        
        answer = Arrays.stream(s)
        .sorted((a, b) -> {
            int cmp = Double.compare(b.failPercent, a.failPercent); // 실패율 내림차순
            if (cmp != 0) return cmp;
            return Integer.compare(a.stage, b.stage); // 같으면 스테이지 오름차순
        })
        .mapToInt(stage -> stage.stage)
        .toArray();
        
        
        return answer;
    }
}