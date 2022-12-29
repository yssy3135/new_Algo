package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 염색체 {


    static int n;
    private static final String REGEX = "^[A-F]?A+F+C+[A-F]?$";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String words[] = new String[n];

        for (int i = 0; i <n; i++) {
            words[i] = br.readLine();
        }

        Arrays.stream(words).forEach(word -> {
            System.out.println(word.matches(REGEX) ? "Infected!" : "Good"+word);
        });
    }
}
