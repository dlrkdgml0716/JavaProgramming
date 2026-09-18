import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Block {
    int width, height, weight, idx;

    Block(int width, int height, int weight, int idx) {
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.idx = idx;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Block[] blocks = new Block[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            blocks[i] = new Block(width, height, weight, i + 1);
        }

        Arrays.sort(blocks, (a, b) -> a.weight - b.weight);

        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        for (int i = 0; i < n; i++) {
            dp[i] = blocks[i].height;
            for (int j = 0; j < i; j++) {
                if (blocks[j].width < blocks[i].width && dp[j] + blocks[i].height > dp[i]) {
                    dp[i] = dp[j] + blocks[i].height;
                    prev[i] = j;
                }
            }
        }

        int best = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[best]) best = i;
        }

        List<Integer> tower = new ArrayList<>();
        for (int cur = best; cur != -1; cur = prev[cur]) {
            tower.add(blocks[cur].idx);
        }
        Collections.reverse(tower);

        StringBuilder sb = new StringBuilder();
        sb.append(tower.size()).append('\n');
        for (int id : tower) {
            sb.append(id).append('\n');
        }
        System.out.print(sb);
    }
}