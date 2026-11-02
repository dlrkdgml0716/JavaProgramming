import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            int T = sc.nextInt();
            sc.nextLine();
            String target = sc.nextLine();
            String s = sc.nextLine();

            HashMap<String, Integer> map = new HashMap<>();
            for(int j = 0; j <= s.length() - target.length(); j++){
                String str = s.substring(j, j+target.length());
                map.put(str, map.getOrDefault(str, 0) + 1);
            }

            System.out.println("#" + T + " " + map.get(target));
        }
    }
}
