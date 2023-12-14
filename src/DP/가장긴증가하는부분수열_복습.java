package DP;

import java.util.Scanner;

public class 가장긴증가하는부분수열_복습 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int input[] = new int[n];
        int len[] = new int[n];
        int max = 0;

        for(int i = 0 ; i < n ;i++){
            input[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if(input[j] < input[i] && len[i] < len[j]+1){
                    len[i] = len[j]+1;
                }
            }
            max = Math.max(len[i],max);
        }

        System.out.println(max);

    }

}
