package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카카오프렌즈컬러링북 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


    }
    static boolean visited[][];
    static int[] a = {1 , -1 , 0 , 0};
    static int[] b = {0 , 0 , 1 , -1};
    static int cnt = 1;
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        visited = new boolean[m][n];

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n; j++) {

                if(picture[i][j] != 0 && !visited[i][j]) {
                    dfs(picture,i,j,picture[i][j]);
                    answer[1] = Math.max(answer[1], cnt);
                    answer[0]++;
                    cnt =1;
                }

            }
        }



        return answer;
    }

    public static int dfs (int arr[][] , int i ,int j,int target) {
        visited[i][j] =	true;


        for(int k = 0 ; k < 4 ;k ++) {
            int nexti = i + a[k];
            int nextj = j + b[k];

            if(nexti >= 0 && nextj >= 0 && nexti < arr.length && nextj < arr[0].length) {
                if(arr[nexti][nextj] == target  && !visited[nexti][nextj]) {
                    cnt = cnt+1;
                    dfs(arr,nexti,nextj,target);
                }
            }


        }


        return cnt;

    }


}
