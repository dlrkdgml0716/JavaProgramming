import java.util.*;

class Solution {
    public static class Program{
        int progress;
        int speed;
        public Program(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Program> queue = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            queue.add(new Program(progresses[i], speeds[i]));
        }

        List<Integer> li = new ArrayList<>();
        while(!queue.isEmpty()){
            Program p1 = queue.poll();
            int day = (100 - p1.progress + p1.speed - 1) / p1.speed;
            int count = 1;
            while(!queue.isEmpty()){
                Program p2 = queue.peek();
                if(p2.progress + (p2.speed * day) >= 100){
                    count++;
                    queue.poll();
                }
                else break;
            }
            li.add(count);
        }

        return li.stream().mapToInt(i -> i).toArray();
    }
}