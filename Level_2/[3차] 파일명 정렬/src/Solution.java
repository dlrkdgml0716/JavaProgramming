import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            String[] file1 = splitFile(f1);
            String[] file2 = splitFile(f2);

            int headCompare = file1[0].compareToIgnoreCase(file2[0]);
            if (headCompare != 0) {
                return headCompare;
            }

            int num1 = Integer.parseInt(file1[1]);
            int num2 = Integer.parseInt(file2[1]);

            return Integer.compare(num1, num2);
        });

        return files;
    }

    private String[] splitFile(String file) {
        String head = "";
        String number = "";

        int i = 0;
        for (; i < file.length(); i++) {
            char c = file.charAt(i);
            if (Character.isDigit(c)) {
                break;
            }
            head += c;
        }
        for (; i < file.length(); i++) {
            char c = file.charAt(i);
            if (!Character.isDigit(c) || number.length() >= 5) {
                break;
            }
            number += c;
        }
        return new String[]{head, number};
    }
}