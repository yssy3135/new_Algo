package 구현;

import java.util.*;

public class programmers_달리기경주 {

    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String,Integer> scoreMap = new HashMap<>();


        for(int i = 0 ; i < players.length; i++) {
            scoreMap.put(players[i], i+1);
        }

        for(String s :callings) {

        }

        for(String calling : callings) {
            int curScore = scoreMap.get(calling);
            if(curScore == 1 )continue;

            String backwordPlayer = players[curScore-1];
            players[curScore-1] = calling;
            players[curScore] = backwordPlayer;
            scoreMap.put(calling, curScore-1);
            scoreMap.put(backwordPlayer, curScore);
        }


        return players;
    }

}
