package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 거리두기확인하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



    }

    static int a[] = {0,0,-1,1};
    static int b[] = {1,-1,0,0};
    static boolean visited[][];
    static String map[][];
    static int ans = 1;
    public static int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
        for(int i = 0 ; i < places.length;i++){
            map = new String[5][];
            for(int j = 0 ; j < places[i].length;j++){
                map[j] = places[i][j].split("");
            }

            Loop:
            for(int j = 0 ; j < 5;j++){
                for(int k = 0 ; k < 5 ;k++){
                    if(map[j][k].equals("P")){

                        visited = new boolean[5][5];
                        visited[j][k] = true;

                        dfs(j,k,0);

                        if(ans == 0){
                            answer[i] = 0;
                            break Loop;
                        }

                    }
                }
            }


            System.out.println(Arrays.toString(answer));


        }



        return answer;
    }

    public static void dfs(int r,int c,int depth){
        if(depth == 3) return;

        for(int i = 0 ; i < 4 ;i++){
            int mr = r+a[i];
            int mc = c+b[i];

            if(mr >=5 || mc >= 5 || mr <0 || mc <0) continue;

            if(depth==2 && map[mr][mc].equals("P") && !visited[mr][mc]){
                ans = 0;
                return;
            }

            if(!visited[mr][mc] && map[mr][mc].equals("O")){
                visited[mr][mc] = true;
                dfs(mr,mc,depth+1);
            }


        }


    }


}
