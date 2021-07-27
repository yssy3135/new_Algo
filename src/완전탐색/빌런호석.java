package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 빌런호석 {


    static int nums[][];
    static int cal[][];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //
        n = Integer.parseInt(st.nextToken());
        //보이는 k자리수
        int k = Integer.parseInt(st.nextToken());
        //바꿀수있는 LED 개수
        int p = Integer.parseInt(st.nextToken());
        //현재층
        String x = st.nextToken();

        nums = new int[10][7];
        cal = new int[10][10];

        nums[0] = new int[]{1,1,1,1,1,1,0};
        nums[1] = new int[]{1,1,0,0,0,0,0};
        nums[2] = new int[]{1,0,1,1,0,1,1};
        nums[3] = new int[]{1,1,1,0,0,1,1};
        nums[4] = new int[]{1,1,0,0,1,0,1};
        nums[5] = new int[]{0,1,1,0,1,1,1};
        nums[6] = new int[]{0,1,1,1,1,1,1};
        nums[7] = new int[]{1,1,0,0,0,1,0};
        nums[8] = new int[]{1,1,1,1,1,1,1};
        nums[9] = new int[]{1,1,1,0,1,1,1};

        for(int j = 0 ; j < 10 ; j++){
            for(int z = j+1; z < 10 ; z++){
                int cnt = 0;
                for(int i = 0 ; i < 7 ; i++){
                    if(nums[j][i] != nums[z][i] )cnt++;
                }
                cal[j][z] = cal[z][j] = cnt;
            }
        }

        for(int a[] : cal){
            System.out.println(Arrays.toString(a));
        }



        int cnt = 0;
        int X = Integer.parseInt(x);
        for (int Y = 1; Y <= n; Y++) {

            int cost = 0;
            int temp1 = X; int temp2 = Y;



            for (int i = 0; i < k; i++) {

                cost += cal[temp1 % 10][temp2 % 10];
                temp1 /= 10; temp2 /= 10;
            }

            if (1 <= cost && cost <= p) {
                cnt++;
            }
        }
        System.out.println(cnt);


    }



}
