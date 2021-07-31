package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공장컨설턴트호석 {
    static int time[];
    static int N;
    static int X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //맞춤형 선물 주문의 개수
        N = Integer.parseInt(st.nextToken());

        //제작 완료까지 남은 시간
        X = Integer.parseInt(st.nextToken());

        time = new int[N];

        st = new StringTokenizer(br.readLine());
        //공정 시간
        for(int i = 0 ; i < N ; i++){
            time[i]= Integer.parseInt(st.nextToken());
        }

        /**
         * 공정 라인의 개수 K 가 정해져 있지 않다.
         * 최소한의 비용을 쓰기위해서 공정 라인의 개수를 최소화 시키고자 한다.
         * 모든 선물을 X시간 이내에 제작하기 위해 필요한 최소 공정 라인 개수를 출력하라
         *
         * 시간 X를 기준으로 이분탐색하여 판단.
         *
         * 시간은 공정라인에 어떻게 선물을 배치하냐에 따라서도 달라진다.
         * 어떻게 배치할 것인가?
         *
         */

        bs();

    }


    public static void bs(){

        int left = 1;
        int right = N;

        while(left <= right){
            int mid = (left+right)/2;

            int time = getTime(mid);

            //시간을 줄일라면 라인개수를 증가
            if(time > X){
                left = mid+1;
            }else{
                //라인개수를 최소화 하기위해 작거나 같으면 라인개수 감소
                right = mid-1;

            }


        }

        System.out.println(left);

    }

    //공정라인의 개수를 받아
    public static int getTime(int k){

        //라인의 개수가 k일때의 시간
        Queue<Integer> pq = new PriorityQueue<>();



        for(int i = 0 ; i < N ;i++){

            if( i < k){
                pq.add(time[i]);
            }else{
                int min = pq.poll();
                min+= time[i];
                pq.add(min);
            }

        }


        int max = 0;
        while(!pq.isEmpty()){
            if(pq.size() == 1){
                max = pq.poll();
            }else{
                pq.poll();
            }

        }



        return max;
    }


}
