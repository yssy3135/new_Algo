package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빌런호석 {


    static int nums[][];
    static int ans = 0;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //
        int n = Integer.parseInt(st.nextToken());
        //보이는 k자리수
        int k = Integer.parseInt(st.nextToken());
        //바꿀수있는 LED 개수
        int p = Integer.parseInt(st.nextToken());
        //현재층
        String x = st.nextToken();

        nums = new int[10][7];

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

        led(p,x,k);
        System.out.println(ans);

    }


    public static void led(int transCnt,String num,int seat){


        //현재 숫자에서
        for(int i = 0 ; i < seat;i++){
            char n = num.charAt(i);
            visited = new boolean[8];
            //n 이라는 숫자를 변환해봐야함
            int numArr[] = nums[n-'0'].clone();
            recursive(n-'0',0,transCnt,numArr);

        }


    }


    public static void recursive(int num,int depthCnt,int depth,int output[]){
        if(depthCnt == depth){
            System.out.println(num);
            for(int i = 0 ; i < 10 ;i++){
               boolean flag = false;
               for(int j = 0 ; j < 7; j++ ){
                    if(nums[i][j] != output[j]){
                    flag = true;
                        break;
                    }
               }
               if(!flag) ans++;
            }
        }

        for(int i = 0 ; i < 7 ;i++){
            if(!visited[i]){
                visited[i] = true;
                output[i] = output[i] == 0 ? 1 : 0;
                recursive(num,depthCnt,depth+1,output);
                output[i] = output[i] == 0 ? 1 : 0;
                visited[i] = false;
            }

        }



    }

}
