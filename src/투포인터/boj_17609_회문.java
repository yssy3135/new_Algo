package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class boj_17609_회문 {
    static String input[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        input = new String[n];

        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
            String spell[] = input[i].split("");
            if(check(spell)){
                System.out.println(0);
            }
        }


    }

    private static boolean check(String[] spell) {
        int start = 0;
        int end = spell.length - 1;

        while (start <= end) {
            if (!spell[start].equals(spell[end])) {
                List<String> spellList = Arrays.asList(spell);
                boolean a = twoPointer(spellList.subList(start, end));
                boolean b = twoPointer(spellList.subList(start+1 , end+1));

                if (!a && !b) {
                    System.out.println(2);
                } else {
                    System.out.println(1);
                }
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean twoPointer(List<String> spell) {
        int start = 0;
        int end = spell.size() - 1;
//        System.out.println(spell);

        while (start <= end) {
            if (!spell.get(start).equals(spell.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
