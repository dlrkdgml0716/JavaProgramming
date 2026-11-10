import java.util.*;

public class Solution {
    static int[] state;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int i = 1; i <= TC; i++){
            int N = sc.nextInt();
            int[][] city = new int[N][3];
            state = new int[N];

            for(int j = 0; j < N; j++){
                city[j][0] = sc.nextInt();
                city[j][1] = sc.nextInt();
                city[j][2] = sc.nextInt();
            }

            solve(city, N);

            System.out.print("#" + i + " ");
            for(int j = 0; j < N; j++){
                if(state[j] == -1) System.out.print("K ");
                else if(state[j] == -2) System.out.print("D ");
                else System.out.print(find(j) + " ");
            }
            System.out.println();
        }
    }
    static void solve(int[][] city, int N){
        double[] max = new double[N];
        int[] count = new int[N];

        for(int i = 0; i < N; i++){
            int x = city[i][0];
            int y = city[i][1];
            int s = city[i][2];

            for(int j = 0; j < N; j++){
                if(i==j) continue;
                double temp = (double)s / (Math.pow(city[j][0] - x, 2) + Math.pow(city[j][1] - y, 2));

                if(temp <= city[j][2]) continue;
                if(temp > max[j]){
                    max[j] = temp;
                    count[j] = 1;
                    state[j] = i + 1;
                }
                else if(temp == max[j]) count[j]++;
            }
        }
        for(int i = 0; i < N; i++){
            if(count[i] == 0) state[i] = -1;
            else if(count[i] > 1) state[i] = -2;
        }
    }
    static int find(int n){
        if(state[n] == -1 || state[n] == -2) return n + 1;

        int next = state[n] - 1;
        if(state[next] == -1 || state[next] == -2) return next + 1;
        return find(next);
    }
}