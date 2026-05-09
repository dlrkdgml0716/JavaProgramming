import java.util.*;
class Solution {
    int[] parent;

    public int solution(int n, int[][] costs) {
        int totalCost = 0;
        parent = new int[n];
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int connectedEdges = 0;
        for (int[] edge : costs) {
            if (connectedEdges == n - 1) break;

            int node1 = edge[0];
            int node2 = edge[1];
            int cost = edge[2];

            if (find(node1) != find(node2)) {
                union(node1, node2);
                totalCost += cost;
                connectedEdges++;
            }
        }
        return totalCost;
    }
    private int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            parent[root2] = root1;
        }
    }
}