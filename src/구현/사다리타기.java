package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 사다리타기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        String ans[] = br.readLine().split("");

        String map[][] = new String[n][k];

        String move[][] = new String[n][k];

        String str[] = new String[k];
        for(int i = 0 ; i < k; i++){
            str[i] = Character.toString('A'+i);
        }

        move[0] = str.clone();
        int disappear = -1;

        boolean flag = false;
        for(int i = 0 ; i < n; i++){
            map[i] = br.readLine().split("");
            for(int j = 0 ; j < k-1 ; j++){
                if(flag) continue;

                if(map[i][j].equals("?")){
                    disappear= i;
                    flag = true;
                }else if(map[i][j].equals("-")){
                    String tmp = str[j];
                    str[j] = str[j+1];
                    str[j+1] = tmp;
                    move[i] = str.clone();
                }

            }

        }

        for(int i = n-1 ; i >disappear;i--){
            for(int j = 0 ; j < k-1 ; j++){
                if(map[i][j].equals("-")){
                    String tmp = ans[j];
                    ans[j] = ans[j+1];
                    ans[j+1] = tmp;
                    move[i] = ans.clone();
                }
            }
        }

        StringBuilder sb = new StringBuilder();


        String top[] = new String[k-1];
        String bottom[] = new String[k-1];




        boolean isAble = true;
        for(int i = 0 ; i < k-1; i++){

            if(str[i].equals(ans[i])){
                sb.append("*");
            }else if(str[i].equals(ans[i+1]) && str[i+1].equals(ans[i])){

                sb.append("-");
            }else{
                if(sb.length() !=0 && sb.charAt(sb.length()-1) == '-'){
                    sb.append("*");
                    continue;
                }
                isAble = false;
                break;
            }


        }
        if(isAble){
            System.out.println(sb.toString());
        }else{
            System.out.println("x".repeat(k-1));
        }



    }
}
