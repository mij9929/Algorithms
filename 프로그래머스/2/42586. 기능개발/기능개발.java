import java.util.*;

class Progress {
    public int progress;
    public int speed;

    public Progress(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }

    public String toString() {
        return " " + this.progress;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();
        int n = progresses.length;
        Deque<Progress> queue =  new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            Progress p = new Progress(progresses[i], speeds[i]);
            queue.offer(p);
        }

        while(!queue.isEmpty()) {
            for(int i=0; i<queue.size(); i++) {
                Progress offer = queue.pollFirst();
                offer.progress+=offer.speed;
                queue.offer(offer);
            }
            int count = 0;

            while(!queue.isEmpty() && queue.peek().progress >= 100) {
                queue.poll();
                count++;
            }

            if(count > 0)
                ans.add(count);
        }

        return ans.stream().mapToInt(i->i).toArray();
    }
}