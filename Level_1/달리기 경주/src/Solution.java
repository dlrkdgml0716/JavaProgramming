import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerRank = new HashMap<String, Integer>();

        for(int i = 0; i < players.length; i++){
            playerRank.put(players[i], i);
        }
        for(int i = 0; i < callings.length; i++){
            String calledplayer = callings[i];
            int currentIndex = playerRank.get(callings[i]);

            String frontPlayer = players[currentIndex - 1];

            players[currentIndex - 1] = calledplayer;
            players[currentIndex] = frontPlayer;

            playerRank.put(calledplayer, currentIndex - 1);
            playerRank.put(frontPlayer, currentIndex);
        }
        return players;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        String[] p = {"mumu", "soe", "poe", "kai", "mine"};
        String[] c = {"kai", "kai", "mine", "mine"};

        String[] result = sol.solution(p, c);

        System.out.println("최종 순위: " + Arrays.toString(result));
    }
}

