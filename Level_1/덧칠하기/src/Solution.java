<<<<<<< HEAD:Level_1/덧칠하기/src/Solution.java
import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 1;
        int first = section[0];
        int roller = m;

        for(int i = 1; i < section.length; i++){
            if(m > section[i] - first){
                continue;
            }
            else{
                first = section[i];
                count++;
            }
        }

        return count;
    }
=======
import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 1;
        int first = section[0];
        int roller = m;

        for(int i = 1; i < section.length; i++){
            if(m > section[i] - first){
                continue;
            }
            else{
                first = section[i];
                count++;
            }
        }

        return count;
    }
>>>>>>> 45d2e9c7b3816c2a15ebf931143520459f507bc8:programmers/Level_1/덧칠하기/src/Solution.java
}