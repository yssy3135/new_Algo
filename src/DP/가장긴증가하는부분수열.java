package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
         int list[] = new int[n+1];
        int len[] = new int[n+1];
        for(int i = 0 ; i < n ;i++){
            list[i] = sc.nextInt();
        }
        int max = 0;
        for(int i = 0 ; i < n; i++) {
            int sum = 0;

            for(int j = 0 ; j <= i ;j++){
                if(list[i] > list[j]){
                    sum = Math.max(sum,len[j]);
                }
            }
            len[i] = sum+1;
            max = Math.max(len[i],max);
        }

        System.out.println(max);

    }

}
