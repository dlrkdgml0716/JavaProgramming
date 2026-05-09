import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        int length = people.length;
        Arrays.sort(people);

        int start = 0;
        int last = length - 1;
        while(true){
            if(start >= last){
                count += length - count*2;
                break;
            }
            if(people[start] + people[last] <= limit){
                count++;
                start++;
                last--;
            }
            else last--;
        }
        return count;
    }
}