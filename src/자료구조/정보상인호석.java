package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 정보상인호석 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Q = Integer.parseInt(br.readLine());

        long sum = 0;

        HashMap<String, PriorityQueue> map = new HashMap<>();
        for(int i = 0 ; i < Q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());


            if (q == 1) {

                for(int j = 0 ; j < k ; j++){
                    int num = Integer.parseInt(st.nextToken());

                    if(map.containsKey(name)){

                        map.get(name).add(num);
                    }else{


                        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return o2-o1;
                            }
                        });
                        pq.add(num);
                        map.put(name,pq);

                    }
                }


            }else {

                if(map.containsKey(name)){

                    PriorityQueue<Integer> pq = map.get(name);
                    if(pq.size() <= k){
                        while(!pq.isEmpty()){
                            sum += pq.poll();
                        }
                    }else{
                        for(int j = 0 ; j < k ; j++){
                            sum+=pq.poll();
                        }
                    }

                }

            }

        }

        System.out.println(sum);

        /**
         * 가치순으로 가장 비싼 정보들을 구매
         */


    }
}
