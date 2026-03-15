import java.util.*;

class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new StringBuilder(new String(chars)).reverse().toString();
    }
}

// sort정렬에는 배열만 가능 단순 String 객체 안됨
// char은 람다식 불가 Character형은 가능