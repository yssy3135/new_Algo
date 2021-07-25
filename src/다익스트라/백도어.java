package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 백도어 {

    static class Point{
        int idx;
        long time;

        public Point(int idx, long time) {
            this.idx = idx;
            this.time = time;
        }
    }

    static int view[];
    static ArrayList<Point> list[] ;
    static long dis[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        view = new int[n];
        String tmp[] = br.readLine().split(" ");
        for(int i = 0 ; i < n ;i++){
            view[i] = Integer.parseInt(tmp[i]);
        }
        list = new ArrayList[n];
        for(int i = 0 ; i < n; i++){
            list[i] = new ArrayList<>();
        }
        dis = new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);


        /**
         *
         *  a0 = 0, aN-1 = 1
         *  N-1번째 분기점은 상대 넥서스이기 때문에 어쩔 수 없이 상대의 시야에 보이게 되며, 또 유일하게 상대 시야에 보이면서 갈 수 있는 곳이다.
         *
         */

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b,t));
            list[b].add(new Point(a,t));

        }


        djikstra(n);

//        System.out.println(Arrays.toString(dis));
        if(dis[n-1] == Long.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dis[n-1]);
        }

    }

    public static void djikstra(int n){
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (int) (o1.time-o2.time);
            }
        });

        dis[0] = 0;
        pq.add(new Point(0,0));

        while(!pq.isEmpty()){
            Point cur = pq.poll();
            int idx = cur.idx;
            long time = cur.time;

            if(dis[idx] < time && view[idx] == 0 ) continue;

            for(int i = 0 ; i< list[idx].size();i++){
                Point get = list[idx].get(i);
                int getIdx = get.idx;
                long getTime = get.time;

                if(dis[getIdx] > time + getTime  ){
                    if(view[getIdx] == 1 && getIdx !=n-1) continue;

                    dis[getIdx] = time+getTime;
                    pq.add(new Point(getIdx,time + getTime));


                }


            }


        }





    }



}
