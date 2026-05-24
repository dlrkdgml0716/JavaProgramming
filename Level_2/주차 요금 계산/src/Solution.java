import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            int time = convertToMinutes(st.nextToken());
            String carNumber = st.nextToken();
            String status = st.nextToken();

            if (status.equals("IN")) {
                inTimeMap.put(carNumber, time);
            } else {
                int inTime = inTimeMap.remove(carNumber);
                int parkedTime = time - inTime;
                totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkedTime);
            }
        }

        int maxTime = convertToMinutes("23:59");
        for (String carNumber : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(carNumber);
            int parkedTime = maxTime - inTime;
            totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkedTime);
        }

        int[] answer = new int[totalTimeMap.size()];
        int idx = 0;

        for (String carNumber : totalTimeMap.keySet()) {
            int totalTime = totalTimeMap.get(carNumber);
            int fee = baseFee;

            if (totalTime > baseTime) {
                int extraTime = totalTime - baseTime;
                int overTimeUnits = (extraTime + unitTime - 1) / unitTime;
                fee += overTimeUnits * unitFee;
            }

            answer[idx++] = fee;
        }

        return answer;
    }

    private int convertToMinutes(String timeStr) {
        int hours = Integer.parseInt(timeStr.substring(0, 2));
        int minutes = Integer.parseInt(timeStr.substring(3));
        return hours * 60 + minutes;
    }
}