import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int hp = health;
        int waiting = bandage[0];
        int heal = bandage[1];
        int addHeal = bandage[2];
        int time = attacks[attacks.length-1][0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < attacks.length; i++){
            map.put(attacks[i][0], attacks[i][1]);
        }
        int runTime = 0;
        for(int i = 1; i <= time; i++){
            if(!map.containsKey(i)){
                runTime++;
                if(health - hp <= heal) hp = health;
                else{
                    hp += heal;
                    if(runTime == waiting){
                        hp += addHeal;
                        runTime = 0;
                        if(hp > health) hp = health;
                    }
                }

            }
            else if(map.containsKey(i)){
                hp -= map.get(i);
                runTime = 0;
                if(hp <= 0) return -1;
            }
        }
        return answer = hp;
    }
}