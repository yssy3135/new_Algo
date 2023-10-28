package Codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OddOccurrencesInArray {

    public static void main(String args[]){

        int arr[] = {9, 3, 9, 3, 9, 7, 9};

        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int oddNum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int arrValue : A) {
            if (map.get(arrValue) == null) {
                map.put(arrValue, 1);
                continue;
            }
            map.put(arrValue, map.get(arrValue) + 1);
        }

        Set<Integer> keys = map.keySet();

        for (Integer key : keys) {
            Integer value = map.get(key);
            if(value%2 == 1) {
                oddNum = key;
                break;
            }
        }

        return oddNum;

    }


}
