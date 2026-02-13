import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sharksCount = Integer.parseInt(st.nextToken());
        int eatLimit = Integer.parseInt(st.nextToken());
        long myShark = Long.parseLong(st.nextToken());

        long[] arr = new long[sharksCount];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < sharksCount; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        Stack<Long> stack = new Stack<>();

        int arrIdx = 0;
        int count = 0;

        while(count < eatLimit) {
            while(arrIdx < sharksCount && arr[arrIdx] < myShark) {
                stack.push(arr[arrIdx]);
                arrIdx++;
            }
            if(!stack.empty()) {
                myShark += stack.pop();
                count++;
            } else {
                break;
            }
        }
        System.out.println(myShark);
    }
}