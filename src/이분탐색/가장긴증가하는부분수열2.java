package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2 {

    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());

        StringTokenizer st=  new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        list.add(0);

        for(int i = 0 ; i < n;i++){
            int input = Integer.parseInt(st.nextToken());

            if(list.get(list.size()-1) < input){
                list.add(input);
            }else{
                // 더 작다 그럼 증가하는것이 아니니깐
                list.set(BS(input),input);
            }
        }


        System.out.println(list.size()-1);


    }

    public static int BS(int input){
        int left = 0;
        int right = list.size()-1;

        while(left <= right){
            int mid = (left+right)/2;

            if (list.get(mid) < input) {
                left = mid+1;
            }else {
                right = mid-1;
            }


        }


        return left;
    }
}






