package 구현;

import java.util.HashMap;
import java.util.Map;

public class programmers_추억_점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String,Integer> nameScoreMap = new HashMap<>();

        for(int i = 0 ; i < name.length; i++) {
            //이름 점수 스코어링
            nameScoreMap.put(name[i],yearning[i]);
        }


        for(int i = 0 ;i < photo.length; i++) {
            String[] photoArr = photo[i];
            int sum = 0;
            for(String includeName : photoArr) {
                Integer score = nameScoreMap.computeIfAbsent(includeName,key -> 0);
                sum += score;
            }
            answer[i] = sum;
        }


        return answer;
    }
}
