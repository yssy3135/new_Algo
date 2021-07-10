import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열지옥에빠진호석 {

    static char map[][];
    static String str[];
    static int a[] = {0,0,-1,1,1,-1};
    static int b[] = {1,-1,0,0,1,-1};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp[] = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);

        map = new char[n][m];
        str = new String[k];

        //맵 설정
        for(int i = 0 ; i < n ;i++){
            map[i] = br.readLine().toCharArray();
        }

        //문자열 받기
        for(int i = 0 ; i < k ;i++){
            str[i] = br.readLine();
        }

    }

    public static void recursive(int r,int c,String curStr){
        int cnt = 0;
        for(int i = 0 ; i < str.length;i++){
            if(curStr.length() <= str.length){
                if(curStr.equals(str[i])){

                }
                cnt++;
            }

        }




        for(int i = 0 ; i < 6 ;i++){
            int mr = r+a[i];
            int mc = c+b[i];

            if( mr == n){
                mr %= n;
            }else if (mc == m){
                mc%= m;
            }else if( mr <= -1){
                mr = n-1;
            }else if(mc <= -1){
                mc = m-1;
            }else if (mr == n && mc == m){
                mr = 0;
                mc = 0;
            }else if (mr == -1 && mc == -1){
                mr = n-1;
                mc = m-1;
            }






        }

    }



}
