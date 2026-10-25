import java.util.*;

public class Solution{
    static int max;
    static List<Set<String>> li;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= T; i++){
            max = 0;
            li = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(sc.nextLine());
            String s = st.nextToken();
            int chance = Integer.parseInt(st.nextToken());
            int[] num = new int[s.length()];

            for(int j = 0; j < s.length(); j++){
                num[j] = (int)s.charAt(j) - '0';
            }

            for(int j = 0; j <= chance; j++){
                li.add(new HashSet<>());
            }
            dfs(num, chance, 0);
            System.out.println("#" + i + " " + max);
        }
    }
    static void dfs(int[] num, int chance, int depth){
        StringBuilder sb = new StringBuilder();
        for(int n : num){
            sb.append(n);
        }

        String current = sb.toString();
        if(li.get(depth).contains(current)) return;
        li.get(depth).add(current);

        if(depth == chance){
            max = Math.max(max, Integer.parseInt(current));
            return;
        }

        for(int i = 0; i < num.length-1; i++){
            for(int j = i+1; j < num.length; j++){
                swap(num, i, j);
                dfs(num, chance, depth+1);
                swap(num, j, i);
            }
        }
    }
    static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}