package 구현;

import java.util.Arrays;
import java.util.Comparator;

public class programmers_요격시스템 {


    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        int missile = -1;
        int turret = 0 ;
        for(int[] target : targets) {
            if(missile == -1) {
                turret ++;
                missile = target[1];
            }

            if(target[0] < missile && missile <= target[1]) continue;

            turret++;
            missile = target[1];
        }

        return turret;
    }
}
