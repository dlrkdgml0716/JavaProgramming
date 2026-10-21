import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int[][] map = new int[9][9];
            for(int j = 0; j < 9; j++){
                for(int k = 0; k < 9; k++){
                    map[j][k] = sc.nextInt();
                }
            }

            boolean check = true;
            for(int j = 0; j < 9; j++){
                Set<Integer> set1 = new HashSet<>();
                Set<Integer> set2 = new HashSet<>();
                for(int k = 0; k < 9; k++){
                    set1.add(map[j][k]);
                    set2.add(map[k][j]);
                }
                if(set1.size() != 9 || set2.size() != 9){
                    check = false;
                    break;
                }
            }
            if(check){
                for (int r = 0; r < 9; r += 3) {
                    for (int c = 0; c < 9; c += 3) {
                        Set<Integer> box = new HashSet<>();

                        for (int dr = 0; dr < 3; dr++) {
                            for (int dc = 0; dc < 3; dc++) {
                                box.add(map[r + dr][c + dc]);
                            }
                        }

                        if (box.size() != 9) {
                            check = false;
                            break;
                        }
                    }
                    if(!check) break;
                }
            }
            System.out.print("#" + (i+1) + " ");
            if(check) System.out.println(1);
            else System.out.println(0);
        }
    }
}