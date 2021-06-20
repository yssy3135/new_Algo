package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


// 백준 2457 공주님의 정원 (그리디) 복습하기
public class 공주님의정원 {
    static class Flower{
        int open;
        int close;

        public Flower(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }

    static Flower infos[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        infos = new Flower[n];



        for(int i = 0 ;i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int openM = Integer.parseInt(st.nextToken());
            int openD = Integer.parseInt(st.nextToken());



            int open = getDay(openM) + openD;

            int closeM = Integer.parseInt(st.nextToken());
            int closeD = Integer.parseInt(st.nextToken());


            int close = getDay(closeM) + closeD;

            infos[i] = new Flower(open,close);
        }

        Arrays.sort(infos, new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return o1.open-o2.open;
            }
        });

        int start= getDay(3)+1;
        int end = getDay(11)+30;
        int cnt = 0;
        int idx = 0;
        int big = 0;
        while(start<=end){


            for(int i = idx ; i < n ;i++){
                if(infos[i].open> start) break;
                if(infos[i].close > big ){
                    big = infos[i].close;

                    idx = i;
                }
            }

            //끝지점이 시작지점과 같다.
            if(big ==start){
               cnt = 0;
                break;
            }else{
                start = big;
                cnt++;
            }


        }

        System.out.println(cnt);

    }


    public static int getDay(int mon){
        int day = 0;
        for(int i = 1 ; i < mon ; i++){
            if(i == 4 || i == 6 || i == 9 || i == 11){
                day +=30;
            }else if (i == 2){
                day +=28;
            }else{
                day +=31;
            }
        }

        return day;
    }


}
