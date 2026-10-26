import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 10; i++){
            int dump = sc.nextInt();
            int[] box = new int[100];

            for(int j = 0; j < 100; j++){
                box[j] = sc.nextInt();
            }

            for(int j = 0; j < dump; j++){
                Arrays.sort(box);
                box[0]++;
                box[99]--;
            }
            Arrays.sort(box);
            int result = box[99] - box[0];
            System.out.println("#" + i + " " + result);
        }
    }
}