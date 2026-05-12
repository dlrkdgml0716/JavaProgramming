import java.util.*;
class Solution {
    boolean[] visited;
    ArrayList<String> allPaths;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        allPaths = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(allPaths);

        return allPaths.get(0).split(" ");
    }

    private void dfs(String current, String path, String[][] tickets, int count) {
        if (count == tickets.length) {
            allPaths.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }
}