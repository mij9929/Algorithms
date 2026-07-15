import java.util.*;

class FileName {
    String original;
    String head;
    int number;
    String tail;
    int idx;

    public FileName(
            String original,
            String head,
            String number,
            String tail,
            int idx
    ) {
        this.original = original;
        this.head = head.toUpperCase();
        this.number = Integer.parseInt(number);
        this.tail = tail;
        this.idx = idx;
    }
}

class Solution {
    public String[] solution(String[] files) {
        PriorityQueue<FileName> pq = new PriorityQueue<>((a, b) -> {
            int headCompare = a.head.compareTo(b.head);

            if (headCompare != 0) {
                return headCompare;
            }

            if (a.number != b.number) {
                return Integer.compare(a.number, b.number);
            }

            return Integer.compare(a.idx, b.idx);
        });

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            int len = file.length();

            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();

            int idx = 0;

            // HEAD
            while (idx < len) {
                char ch = file.charAt(idx);

                if (ch >= '0' && ch <= '9') {
                    break;
                }

                head.append(ch);
                idx++;
            }

            // NUMBER
            while (idx < len) {
                char ch = file.charAt(idx);

                if (ch >= '0' && ch <= '9') {
                    number.append(ch);
                    idx++;
                } else {
                    break;
                }
            }

            // TAIL
            while (idx < len) {
                tail.append(file.charAt(idx));
                idx++;
            }

            FileName fileName = new FileName(
                    file,
                    head.toString(),
                    number.toString(),
                    tail.toString(),
                    i
            );

            pq.offer(fileName);
        }

        String[] answer = new String[files.length];
        int answerIdx = 0;

        while (!pq.isEmpty()) {
            answer[answerIdx++] = pq.poll().original;
        }

        return answer;
    }
}