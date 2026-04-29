import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> idToNickname = new HashMap<>();

        List<String[]> log = new ArrayList<>();

        for (String r : record) {
            String[] parts = r.split(" ");
            String command = parts[0];
            String id = parts[1];

            if (command.equals("Enter")) {
                idToNickname.put(id, parts[2]);
                log.add(new String[]{id, "님이 들어왔습니다."});
            } else if (command.equals("Leave")) {
                log.add(new String[]{id, "님이 나갔습니다."});
            } else if (command.equals("Change")) {
                idToNickname.put(id, parts[2]);
            }
        }

        String[] answer = new String[log.size()];
        for (int i = 0; i < log.size(); i++) {
            String id = log.get(i)[0];
            String message = log.get(i)[1];
            answer[i] = idToNickname.get(id) + message;
        }

        return answer;
    }
}