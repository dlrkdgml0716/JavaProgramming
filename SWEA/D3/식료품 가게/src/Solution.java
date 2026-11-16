import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int i = 1; i <= TC; i++) {
            int N = sc.nextInt(); // 상품 개수
            List<Integer> li = new ArrayList<>();
            List<Integer> product = new ArrayList<>();
            for(int j = 0; j < N*2; j++) {
                li.add(sc.nextInt());
            }

            for(int j = 0; j < li.size() - 1; j++) {
                int target = li.get(j);
                if(li.get(j) == 0) continue;
                for(int k = j+1; k < li.size(); k++) {
                    if(li.get(k) != 0 && target%3 == 0 && (target + target/3 == li.get(k))) {
                        product.add(target);
                        li.set(j, 0);
                        li.set(k, 0);
                        break;
                    }
                }
            }

            System.out.print("#" + i);
            for(int j = 0; j < product.size(); j++) {
                System.out.print(" " + product.get(j));
            }

            System.out.println();
        }
    }
}