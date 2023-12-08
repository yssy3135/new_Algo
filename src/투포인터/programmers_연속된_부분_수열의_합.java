package 투포인터;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class programmers_연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = sequence;



        int left = 0;
        int right = 0;

        int minLeft = 0;
        int minRight = sequence.length;

        int sum = sequence[0];

        while(left <= right ) {

            if(sum == k ) {
                if(right - left < minRight - minLeft) {
                    minRight = right;
                    minLeft = left;
                }

                sum -= sequence[left];
                left++;
                if(left >= sequence.length) break;

            }

            if(sum < k) {
                right++;

                if(right >= sequence.length) break;
                sum += sequence[right];
            }

            if(sum > k) {
                sum -= sequence[left];
                left++;
            }




        }

        return new int[] {minLeft, minRight};
    }
}
