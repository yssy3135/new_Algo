package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 물병 {
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        // 한번에 k개씩 옮길수 있다.
        k = Integer.parseInt(st.nextToken());



        int ans = n;
        if(n <=k){
            System.out.println(0);
        }else{
            while(true){

                if(res(ans) <= k){
                    break;
                }else{
                    ans++;
                }
            }
            System.out.println(ans-n);
        }

    }

    //2로 나눠서 나머지 개수가 물병의 개수
   public static int res(int num){
        int cnt = 0;

        while(num>0){
            if(num%2 == 1) cnt++;
            num /=  2;
        }
        return cnt;
    }


}
