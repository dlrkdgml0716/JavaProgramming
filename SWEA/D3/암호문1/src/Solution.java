import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 10; i++){
            List<Integer> li = new ArrayList<>();
            int N = sc.nextInt();
            for(int j = 0; j < N; j++){
                li.add(sc.nextInt());
            }

            int command = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();

            String[] arr = s.split("I");
            for(int j = 1; j < arr.length; j++){
                StringTokenizer st = new StringTokenizer(arr[j]);
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                for(int k = x; k <= x+y-1; k++){
                    li.add(k, Integer.parseInt(st.nextToken()));
                }
            }
            System.out.print("#" + i + " ");
            for(int j = 0; j < 10; j++){
                System.out.print(li.get(j) + " ");
            }
            System.out.println();
        }
    }
}