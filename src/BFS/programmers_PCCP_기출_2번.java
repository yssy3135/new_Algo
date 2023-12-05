package BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_PCCP_기출_2번 {


    public static void main(String[] args) {

    }


    class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    static int x[] = {0,0,-1,1};
    static int y[] = {-1,1,0,0};
    static int map[][];
    static boolean visit[][];
    public int solution(int[][] land) {
        int answer = 0;

        map = new int[land.length][land[0].length];
        visit = new boolean[land.length][land[0].length];
        map = land;

        int landCnt = 1;
        HashMap<Integer, Integer> landMap = new HashMap<>();

        for(int i = 0 ; i < map[0].length; i++) {
            int sum = 0;
            for(int j = 0 ; j < map.length; j++) {
                if(map[j][i] > 0 && !visit[j][i] ){
                    int oilCount = bfs(new Node(j, i), landCnt);
                    sum += oilCount;
                    landMap.put(landCnt,oilCount);

                    landCnt++;
                }
            }
        }


        for(int i = 0 ; i < map[0].length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0 ; j < map.length; j++) {
                if(map[j][i] > 0){
                    set.add(map[j][i]);
                }
            }
            int sum = 0;
            for(int idx : set) {
                sum += landMap.get(idx);
            }
            answer = Math.max(answer,sum);
        }

        return answer;
    }



    public int bfs(Node startNode, int landCnt) {
        Queue<Node> que = new LinkedList<Node>();
        que.add(startNode);

        int sum = 1;
        visit[startNode.x][startNode.y] = true;
        map[startNode.x][startNode.y] = landCnt;
        while(!que.isEmpty()) {
            Node node = que.poll();

            for(int i = 0 ; i < 4 ; i++) {
                int nextX = node.x + x[i];
                int nextY = node.y + y[i];

                if(nextX >= 0 && nextX < map.length &&  nextY >= 0 && nextY <map[0].length && !visit[nextX][nextY]) {
                    if(map[nextX][nextY] == 1){
                        que.add(new Node(nextX, nextY));
                        sum += 1;
                        map[nextX][nextY] = landCnt;
                        visit[nextX][nextY] = true;
                    }
                }
            }
        }

        return sum;
    }


}
