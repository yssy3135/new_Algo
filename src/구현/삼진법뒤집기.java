package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class 삼진법뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


    }
    public int solution(int n) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();

        while(n/3 > 0){
            sb.append(n%3);
            n = n/3;
        }
        sb.append(n);

        char num[] = sb.toString().toCharArray();
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < num.length ;i++){
            st.add(num[i]-'0');
        }

        int idx = 0;
        while(!st.isEmpty()){

            answer += st.pop()*Math.pow(3,idx);
            idx++;
        }


        System.out.println(answer);

        return answer;
    }

}
