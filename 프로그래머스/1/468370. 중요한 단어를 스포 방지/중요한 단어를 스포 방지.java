import java.util.*;

class Word {
    public String word;
    public int start;
    public int end;

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
                    words.add(new Word(sb.toString(), start, i - 1));
                    sb = new StringBuilder();
                }

                start = i + 1;
            } else {
                sb.append(c);
            }
        }

        // 마지막 단어 처리
        if (sb.length() > 0) {
            words.add(new Word(sb.toString(), start, len - 1));
        }

        int answer = 0;

         Set<String> normalWords = new HashSet<>();

        for (Word word : words) {
            boolean hasSpoilerChar = false;

            for (int i=word.start; i<= word.end; i++) {
                if (isSpoiler[i]) {
                    hasSpoilerChar = true;
                    break;
                }
            }

            // 단어 전체가 스포 구간에 전혀 안 걸렸으면 일반 단어
            if (!hasSpoilerChar) {
                normalWords.add(word.word);
            }
        }

        Set<String> counted = new HashSet<>();

        for (Word word : words) {
            boolean hasSpoilerChar = false;

            for (int i=word.start; i<=word.end; i++) {
                if (isSpoiler[i]) {
                    hasSpoilerChar = true;
                    break;
                }
            }

            if (!hasSpoilerChar) {
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