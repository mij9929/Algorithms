import java.util.*;

class Word {
    public String word;
    public int start;
    public int end;
    public boolean spoiler;

    public Word(String word, int start, int end) {
        this.word = word;
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return word + " -> start = " + start + ", end = " + end + "\n";
    }
}

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        List<Word> words = new ArrayList<>();

        int len = message.length();
        boolean[] isSpoiler = new boolean[len];

        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                isSpoiler[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;

        for (int i = 0; i < len; i++) {
            char c = message.charAt(i);

            if (c == ' ') {
                if (sb.length() > 0) {
                    int end = i - 1;

                    Word word = new Word(sb.toString(), start, end);

                    for (int j = start; j <= end; j++) {
                        if (isSpoiler[j]) {
                            word.spoiler = true;
                            break;
                        }
                    }

                    words.add(word);
                    sb = new StringBuilder();
                }

                start = i + 1;
            } else {
                sb.append(c);
            }
        }

        // 마지막 단어 처리
        if (sb.length() > 0) {
            int end = len - 1;

            Word word = new Word(sb.toString(), start, end);

            for (int j = start; j <= end; j++) {
                if (isSpoiler[j]) {
                    word.spoiler = true;
                    break;
                }
            }

            words.add(word);
        }

        Set<String> normalWords = new HashSet<>();

        for (Word word : words) {
            if (!word.spoiler) {
                normalWords.add(word.word);
            }
        }

        Set<String> counted = new HashSet<>();
        int answer = 0;

        for (Word word : words) {
            if (!word.spoiler) {
                continue;
            }

            if (normalWords.contains(word.word)) {
                continue;
            }

            if (counted.contains(word.word)) {
                continue;
            }

            counted.add(word.word);
            answer++;
        }

        return answer;
    }
}