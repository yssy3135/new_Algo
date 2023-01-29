package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//todo 복습
public class boj_12931_두배더하기 {
    static int n;
    static int arr[];
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        String tmp[] = br.readLine().split(" ");

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
            sum += arr[i];
        }


        while(sum !=0 ){
            int minusCnt = 0;
            for(int i = 0 ; i < n; i++){
                if(arr[i]%2 == 1){
                    arr[i] -= 1;
                    minusCnt++;
                }
            }

            if(minusCnt >0 ){
                sum-= minusCnt;
                cnt+= minusCnt;
            }else{
                for(int i = 0 ; i < n; i++){
                        arr[i] /= 2;
                }
                sum/=2;
                cnt++;
            }

        }

        System.out.println(cnt);



    }
}
