package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 1806 부분합 (누적합,투포인터)
public class 부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        String tmp[] = br.readLine().split(" ");
        long sum[] = new long[n+1];

        for(int i = 1 ; i <= n; i++){
            sum[i] = Integer.parseInt(tmp[i-1]);
        }
        for(int i = 1 ; i <= n; i++){
            sum[i] = sum[i] +sum[i-1];
        }

        System.out.println(Arrays.toString(sum));

        int left = 0;
        int right = 1;
        int ans = Integer.MAX_VALUE;
        while(left <= right && right <=n){
            long cur = sum[right]-sum[left];

            if (cur >= s) {
                ans = Math.min(ans,right-left);
                left++;
            }else {
                right++;

            }


        }
        if(ans == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(ans);

        }



    }
}
