class Solution {
    public String solution(String s, int n) {
        char[] alphabet = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            alphabet[i] = s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i] == ' ') sb.append(' ');
            else if(alphabet[i] >= 'a' && alphabet[i] <= 'z'){
                sb.append((char)((alphabet[i] - 'a' + n) % 26 + 'a'));
            }
            else if(alphabet[i] >= 'A' && alphabet[i] <= 'Z'){
                sb.append((char)((alphabet[i] - 'A' + n) % 26 + 'A'));
            }
        }

        return sb.toString();
    }
}