import java.util.Scanner;


/**
 * 백트래킹으로 풀었는데 dp..?
 * dp로 다시 풀어보기
 */
public class 격자상의_경로 {
    static boolean map[][];
    static boolean visited[][];
    static int n;
    static int m;
    static int k;

    static int a[] = {0,1};
    static int b[] = {1,0};
    static int ans = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input[] = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

         map = new boolean [n][m];

         map[0][0] = true;

         if(k != 0){
            dfs(0,0,1);
         }else{
            dfs(0,0,0);
         }

        System.out.println(ans);
    }

    static void dfs(int row,int col, int check){
        if(row == n-1  && col == m-1 && check == 0){
            ans++;
        }
        for(int i = 0 ; i < 2 ; i++){
            int nextRow = row + a[i];
            int nextCol = col + b[i];

            if(nextRow < n && nextCol < m && nextRow >= 0 && nextCol >=0){
                if(!map[nextRow][nextCol]){
                    map[nextRow][nextCol] = true;
                    int num = (nextRow)*(m)+nextCol+1;
                    if(num == k) dfs(nextRow,nextCol,check-1);
                    else dfs(nextRow,nextCol,check);
                    map[nextRow][nextCol] = false;
                }
            }
        }
    }

}
