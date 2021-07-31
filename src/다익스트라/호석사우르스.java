package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 호석사우르스 {

    static class Info{
        int r;
        int c;
        int moveCnt;
        int shock;


        public Info(int r, int c, int moveCnt, int shock) {
            this.r = r;
            this.c = c;
            this.moveCnt = moveCnt;
            this.shock = shock;
        }
    }


    static int start[] = new int[2];
    static int end[] = new int[2];
    static int map[][];
    static int visited[][][];
    static int a[] = {-1,1,0,0};
    static int b[] = {0,0,-1,1};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][3];

        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ;j++){
                map[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        for(int a[][] : visited){
            for(int b[] : a){
                Arrays.fill(b,Integer.MAX_VALUE);
            }
        }


        bfs();
        int min = Integer.MAX_VALUE;
        for(int a : visited[end[0]-1][end[1]-1]){
            min = Math.min(min,a);
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);

        }

    }

    public static void bfs(){

        Queue<Info> que = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.shock-o2.shock ;
            }
        });
        que.add(new Info(start[0]-1,start[1]-1,1,0));

        while(!que.isEmpty()){
            Info cur = que.poll();

            int r = cur.r;
            int c = cur.c;
            int moveCnt = cur.moveCnt;
            int shock = cur.shock;

            int starti = 0;
            int endi = 0;

            int way = moveCnt%3;

            if(way == 0){
                endi =4 ;
            }else if (way == 1){
                endi =2 ;
            }else if (way == 2){
                starti = 2;
                endi = 4;

            }


            for(int i = starti ; i < endi ;i++){
                int mr = r + a[i];
                int mc = c + b[i];
                if(mr < 0 || mc < 0 || mr >= N || mc >= M)  continue;

                if(map[mr][mc] != -1 ){

                    int nextTime = shock + map[mr][mc];

                    if(visited[mr][mc][way] > nextTime){
                        visited[mr][mc][way] = nextTime;
                        que.add(new Info(mr, mc,moveCnt+1,nextTime));

                    }


                }

            }



        }




    }


}
