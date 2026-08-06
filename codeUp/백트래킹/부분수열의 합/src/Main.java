import java.util.*;
public class Main {
    static int count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = 0;
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++){
            nums[i] = scanner.nextInt();
        }
        solved(target, nums, 0 ,0, 0);

        System.out.print(count);
    }
    static void solved(int target, int[] nums, int start, int depth, int current){
        if(depth > nums.length){
            return;
        }
        if(depth > 0 && target == current){
            count++;
        }
        for(int i = start; i < nums.length; i++){
            solved(target, nums, i+1, depth + 1, current + nums[i]);
        }
    }
}