import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.sql.Array;
import java.util.*;

public class 효율적인해킹 {

    static boolean visited[];
    static int max = 0;
    static int hackingCnt = 0;
    static int n;

    static List<Integer>[] trustRelation;

    static int ans[];

    //Todo https://www.acmicpc.net/source/42593806 참고해서 다시풀기

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        String tmp[] = input.split(" ");

        n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);



        trustRelation = new ArrayList[n+1];
        ans = new int[n+1];

        for(int i = 1; i <= n ; i++){
            trustRelation[i] = new ArrayList<>();
        }


        for(int i = 0 ; i < m ;i++){
            String relationInput[] = bf.readLine().split(" ");
            int A = Integer.parseInt(relationInput[0]);
            int B = Integer.parseInt(relationInput[1]);
            // A가B를 신뢰한다. -> B를 해킹하면 A도 해킹할 수 있다.
            trustRelation[A].add(B);
        }

        for(int i = 1 ; i<=n;i++){
            visited = new boolean[n+1];
            visited[i] = true;
            dfs(i,i);

        }

        for(int i = 1 ; i <= n ;i++){
            max = Math.max(ans[i],max);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i <= n ;i++){
            if(ans[i] == max){
                sb.append(i+" ");
            }
        }

        System.out.println(sb);
        System.out.println(Arrays.toString(ans));
    }




    public static void dfs(int num,int startNum){
        for(int trustNum : trustRelation[num]){
            if(!visited[trustNum]){
                visited[trustNum] = true;
                ans[trustNum]++;
                dfs(trustNum,startNum);
            }
        }
    }

}

