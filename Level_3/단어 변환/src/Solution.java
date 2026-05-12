import java.util.*;
class Solution {
    class Node {
        String word;
        int dist;

        Node(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }
    public int solution(String begin, String target, String[] words) {
        boolean hasTarget = false;
        for (String w : words) {
            if (w.equals(target)) {
                hasTarget = true;
                break;
            }
        }
        if (!hasTarget) return 0;

        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];

        queue.add(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.word.equals(target)) {
                return curr.dist;
            }
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(curr.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], curr.dist + 1));
                }
            }
        }
        return 0;
    }
    private boolean canConvert(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) diffCount++;
        }
        return diffCount == 1;
    }
}