import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int jobsIdx = 0;
        int count = 0;

        List<int[]> jobList = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            jobList.add(new int[]{jobs[i][0], jobs[i][1], i});
        }

        Collections.sort(jobList, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[2] - o2[2];
        });

        while (count < jobs.length) {
            while (jobsIdx < jobList.size() && jobList.get(jobsIdx)[0] <= time) {
                pq.add(jobList.get(jobsIdx));
                jobsIdx++;
            }

            if (pq.isEmpty()) {
                time = jobList.get(jobsIdx)[0];
            } else {
                int[] currentJob = pq.poll();

                time += currentJob[1];
                answer += time - currentJob[0];

                count++;
            }
        }

        return answer / jobs.length;
    }
}