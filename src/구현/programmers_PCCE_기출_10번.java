package 구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class programmers_PCCE_기출_10번 {


    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        HashMap<String, Integer> map = new HashMap<>();
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);


        return Arrays.stream(Arrays.stream(data).filter(arr -> arr[map.get(ext)] < val_ext).toArray(int[][]::new)).sorted(Comparator.comparingInt(o -> o[map.get(sort_by)])).toArray(int[][]::new);
    }
}
