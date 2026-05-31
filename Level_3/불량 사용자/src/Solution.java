import java.util.*;
public class Solution {
    private Set<Set<String>> resultSet = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }
        boolean[] visited = new boolean[user_id.length];
        Set<String> currentCombination = new HashSet<>();
        dfs(0, visited, currentCombination, user_id, banned_id);
        return resultSet.size();
    }
    private void dfs(int depth, boolean[] visited, Set<String> currentCombination, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            resultSet.add(new HashSet<>(currentCombination));
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && user_id[i].matches(banned_id[depth])) {
                visited[i] = true;
                currentCombination.add(user_id[i]);

                dfs(depth + 1, visited, currentCombination, user_id, banned_id);

                visited[i] = false;
                currentCombination.remove(user_id[i]);
            }
        }
    }
}