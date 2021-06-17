package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1939 중량제한
public class 중량제한 {
    static class Node{
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    static ArrayList<Node> list[];
    static boolean visited[];
    static int factory_a;
    static int factory_b;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //섬의개수
        n = Integer.parseInt(st.nextToken());
        //다리의 개수수
       int m = Integer.parseInt(st.nextToken());

       list = new ArrayList[n+1];
       visited = new boolean[n+1];
       for(int i = 1 ; i <= n;i++){
           list[i] = new ArrayList<>();
       }


        int maxWeight = 0;
        for(int i = 0 ; i < m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
            maxWeight = Math.max(maxWeight,c);
        }

        st = new StringTokenizer(br.readLine());
        factory_a = Integer.parseInt(st.nextToken());
        factory_b = Integer.parseInt(st.nextToken());


        //이분탐색
        binary(maxWeight);



    }
    public static void binary(int max){

        int left = 0;
        int right = max;

        while(left <= right){
            int mid = (left+right)/2;
            //중량의 최대값 == 경로 다리 무게의 최솟값 중 최대값
            if(bfs(mid)){
                left = mid+1;
            }else{
                right = mid-1;
            }

        }

        System.out.println(left-1);


    }


    public static boolean bfs(int limit){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(factory_a,0));
        visited = new boolean[n+1];
        visited[factory_a] = true;

        while(!que.isEmpty()){
            int cur = que.peek().num;
            int weight = que.peek().weight;
            que.poll();

            if(cur == factory_b){

                return true;
            }
            for(int i = 0 ; i < list[cur].size();i++){
                int get = list[cur].get(i).num;
                int getWeight = list[cur].get(i).weight;
                if(!visited[get]&&getWeight >=limit){
                    visited[get] = true;
                    que.add(list[cur].get(i));
                }

            }

        }

        return false;


    }


}
