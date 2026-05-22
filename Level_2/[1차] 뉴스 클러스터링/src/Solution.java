import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> list1 = makeMultiSet(str1);
        List<String> list2 = makeMultiSet(str2);

        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }
        int intersection = 0;
        List<String> copyList2 = new ArrayList<>(list2);
        for (String s : list1) {
            if (copyList2.remove(s)) {
                intersection++;
            }
        }
        int union = list1.size() + list2.size() - intersection;
        double jacard = (double) intersection / union;
        return (int) (jacard * 65536);
    }
    private List<String> makeMultiSet(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);
            if (Character.isLetter(first) && Character.isLetter(second)) {
                list.add("" + first + second);
            }
        }
        return list;
    }
}