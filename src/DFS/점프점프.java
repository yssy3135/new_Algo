package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class 점프점프 {
    static int n;
    static int bg[];
    static boolean visited[];
    static int ans = 1;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        bg = new int[n];
        visited = new boolean[n];

        for(int i  = 0 ; i < n ; i++) {
            bg[i] = sc.nextInt();
        }

        int startPoint = sc.nextInt()-1;

        visited[startPoint] = true;
        dfs(startPoint);

        System.out.println(ans);
    }

    public static void dfs(int curPoint){

        if(curPoint+bg[curPoint] < n && !visited[curPoint+bg[curPoint]] ){
            visited[curPoint+bg[curPoint]] = true;
            dfs(curPoint+bg[curPoint]);
            ans++;
        }

        if(curPoint-bg[curPoint] >= 0 && !visited[curPoint-bg[curPoint]]){
            visited[curPoint-bg[curPoint]] = true;
            dfs(curPoint-bg[curPoint]);
            ans++;
        }
    }


}
