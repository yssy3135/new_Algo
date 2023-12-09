package 구현;

import java.util.Arrays;

public class programmers_공원산책 {

    static String[][] map;
    static int startX;
    static int startY;

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};


        startX = 0;
        startY = 0;

        map = new String[park.length][park[0].length()];

        boolean flag = false;
        for(int i = 0 ; i < park.length;i++) {
            map[i] = park[i].split("");

            for(int j = 0 ; j < map[i].length ;j++) {
                if(flag) break;

                if(map[i][j].equals("S")){
                    startX = i ;
                    startY = j;

                    flag = true;
                }
            }
            if(flag) {
                break;
            }
        }


        for(int i = 0 ; i < routes.length ; i++) {
            String way = routes[i].split(" ")[0];
            Integer moveCnt = Integer.parseInt(routes[i].split(" ")[1]);


            if(way.equals("N")) {
                move(-1,0,moveCnt);
            }else if(way.equals("S")) {
                move(1,0,moveCnt);
            }else if(way.equals("W")) {
                move(0,-1,moveCnt);
            }else if(way.equals("E")) {
                move(0,1,moveCnt);
            }


        }

        return new int[] {startX,startY};
    }

    public void move(int moveX, int moveY,  int moveCnt) {
        if(startX+(moveX*moveCnt) < 0 || startX+(moveX*moveCnt) >= map.length ||startY+(moveY*moveCnt) <0 || startY+(moveY*moveCnt) >= map[0].length ) {
            return;
        }

        for(int i = 1 ; i <= moveCnt; i++) {
            if(map[startX+(moveX*i)][startY+(moveY*i)].equals("X")) {
                return ;
            }
        }

        startX = startX+(moveX*moveCnt);
        startY = startY+(moveY*moveCnt);
    }
}
