import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        class Word {
            String text;
            int start, end;
            boolean isSpoiler = false;

            Word(String text, int start, int end) {
                this.text = text;
                this.start = start;
                this.end = end;
            }
        }
        List<Word> words = new ArrayList<>();
        String[] split = message.split(" ");
        int currentPos = 0;
        for (String s : split) {
            int start = currentPos;
            int end = start + s.length() - 1;
            words.add(new Word(s, start, end));
            currentPos = end + 2;
        }
        Set<String> normalWords = new HashSet<>();
        for (Word w : words) {
            for (int[] range : spoiler_ranges) {
                if (!(w.end < range[0] || w.start > range[1])) {
                    w.isSpoiler = true;
                    break;
                }
            }
            if (!w.isSpoiler) {
                normalWords.add(w.text);
            }
        }
        int answer = 0;
        Set<String> revealedSpoilers = new HashSet<>();

        for (Word w : words) {
            if (w.isSpoiler) {
                if (!normalWords.contains(w.text) && !revealedSpoilers.contains(w.text)) {
                    answer++;
                }
                revealedSpoilers.add(w.text);
            }
        }

        return answer;
    }
}

// 증복을 피해야 되는 문제에서 HashSet을 적극 활용할 것