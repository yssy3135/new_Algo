package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 창영이와퇴근 {


    static class Node{
        int r;
        int c;
        int sub;

        public Node(int r, int c, int sub) {
            this.r = r;
            this.c = c;
            this.sub = sub;
        }
    }


    static int map[][];
    static int a[] = {0,0,-1,1};
    static int b[] = {1,-1,0,0};
    static int visited[][];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];

        for(int i = 0 ; i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int a[] : visited){
            Arrays.fill(a,Integer.MAX_VALUE);
        }

        /**
         * 접근
         *
         *
         *
         *
         */


        bfs();


    }

    public static void bfs(){
        Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.sub-o2.sub;
            }
        });

        while(!pq.isEmpty()){
            Node cur =pq.poll();
            int r = cur.r;
            int c = cur.c;
            //현재까지 경사의 최대값
            int curSub = cur.sub;

            for(int i = 0 ; i < 4 ;i++){
                int mr = r+a[i];
                int mc = c+b[i];

                if(mr<0 || mc <0 || mr >= n || mc >= n) continue;
                int newSub = Math.abs(map[mr][mc] - map[r][c]);
                int nextSub = Math.max(newSub,curSub);
                /**
                 * visited에는 visited[mr][mc]를지나온 경로중에 최소 경사로가 저장
                 * 처음에는 Integer.Max_Value 로 초기화되어있어 탐색하며 최소 값을 변화시킨다.
                 * 이미 탐색했던 곳이지만 지금까지 지나왔던 최대값이 더 작다면 값을 바꾸고 계속 탐색한다.
                 * 더 크다면 탐색을 하지 않는다.
                 */
                if(visited[mr][mc] > nextSub){
                    visited[mr][mc] = nextSub;
                    pq.add(new Node(mr,mc,nextSub));
                }


            }

        }

    }





}
