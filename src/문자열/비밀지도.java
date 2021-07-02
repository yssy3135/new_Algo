package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비밀지도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] str = new String[n];

        System.out.println(Integer.toBinaryString(arr1[0]));


        for(int i = 0 ; i < n;i++   ){
            str[i] = String.format("%"+n+"s",Integer.toBinaryString(arr1[i] | arr2[i]));
            str[i] = str[i] .replaceAll("1","#");
            str[i] = str[i] .replaceAll("0"," ");
        }


        return str;
    }
}
