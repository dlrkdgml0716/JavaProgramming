import java.util.*;

public class Solution{
    static List<String> li;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            li = new ArrayList<>();
            int N = sc.nextInt(); // 암호 길이
            int M = sc.nextInt(); // 단서 개수
            sc.nextLine();

            boolean[] visited = new boolean[10];
            bfs(N, visited, "");

            String[] hint = new String[M];
            int[] A = new int[M];
            int[] B = new int[M];

            for(int j = 0; j < M; j++) {
                hint[j] = sc.next();
                A[j] = sc.nextInt();
                B[j] = sc.nextInt();
            }

            int answer = 0;

            for(int j = 0; j < li.size(); j++) {
                String candidate = li.get(j);
                boolean isPossible = true;

                for(int k = 0; k < M; k++) {
                    int countA = 0;
                    int countB = 0;

                    for(int l = 0; l < N; l++) {
                        for(int m = 0; m < N; m++) {
                            if(candidate.charAt(l) == hint[k].charAt(m)) {
                                if(l == m) {
                                    countA++;
                                }
                                else {
                                    countB++;
                                }
                            }
                        }
                    }
                    if(countA != A[k] || countB != B[k]) {
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible) answer++;
            }

            System.out.println("#" + i + " " + answer);
        }
    }
    static void bfs(int N, boolean[] visited, String s) {
        if(s.length() == N) {
            li.add(s);
            return;
        }
        for(int i = 1; i <= 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                bfs(N, visited, s + i);
                visited[i] = false;
            }
        }
    }
}