import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {

    static int maze[][];
    static int N;
    static int M;

    static int a[] = {-1,0,0,1};
    static int b[] = {0,1,-1,0};


    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

         N = Integer.parseInt(input[0]);
         M = Integer.parseInt(input[1]);

        maze = new int[N][M];

        for(int i = 0 ; i <N ;i++ ){
            String row[] = sc.nextLine().split("");
            for(int j = 0 ; j < M ;j++){
                maze[i][j]  = Integer.parseInt(row[j]);
            }
        }
        bfs();


    }

    public static void bfs(){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0,0));

        while(!que.isEmpty()){
            Point cur = que.poll();

            if(cur.x == N-1 && cur.y == M-1){
                System.out.println(maze[cur.x][cur.y]);
                break;
            }

            for(int i = 0 ; i < 4 ;i++){
                int x = cur.x + a[i];
                int y = cur.y + b[i];


                if(x >= 0 && y >= 0 && x < N && y < M){
                    if( maze[x][y] == 1){
                        maze[x][y] = maze[cur.x][cur.y]+1;
                        que.add(new Point(x,y));
                    }
                }

            }
        }


    }
}
