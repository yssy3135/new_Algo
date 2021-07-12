package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자문자열과영단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        solution("one4seveneight");

    }

    public static int solution(String s) {
        int answer = 0;

        System.out.println(stringTonumber(s));



        return answer;
    }


    public static String stringTonumber(String s){
        if(s.contains("zero")){
            s = s.replace("zero","0");
        }else if (s.contains("one")){
            s = s.replace("one","1");
        }else if (s.contains("two")){
            s = s.replace("two","2");
        }else if (s.contains("three")){
            s = s.replace("three","3");
        }else if (s.contains("four")){
            s = s.replace("four","4");
        }else if (s.contains("five")){
            s = s.replace("five","5");
        }else if (s.contains("six")){
            s = s.replace("six","6");
        }else if (s.contains("seven")){
            s = s.replace("seven","7");
        }else if (s.contains("eight")){
            s = s.replace("eight","8");
        }else if (s.contains("nine")){
            s = s.replace("nine","9");
        }else{
            return s;
        }


        return stringTonumber(s);
    }

}
