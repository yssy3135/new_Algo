package 위상정렬;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 장난감조립 {
    static class Node{
        int conNode;
        int weight;

        public Node(int conNode, int weight) {
            this.conNode = conNode;
            this.weight = weight;
        }
    }


    static int num[];
    static ArrayList<Node> list[];
    static int cnt[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        num = new int[n+1];
        cnt = new int[n+1];

        list = new ArrayList[n+1];
        for(int i = 1 ; i <=n ;i++){
            list[i] = new ArrayList<>();
        }


        for(int i = 0 ; i < m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //x를 만드는데 y가 k개 필요하다
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y,k));
            num[y]++;

        }
        ArrayList<Integer> chk = new ArrayList<>();
        topology(n);

        for(int i = 1 ; i< list.length;i++){
            if(list[i].size() ==0){
                System.out.println(i +" "+cnt[i]);
            }
        }



    }

    public static void topology(int lastNum){
        Queue<Node> que=  new LinkedList<>();

        que.add(new Node(lastNum,1));
        cnt[lastNum] = 1;
        while(!que.isEmpty()){
            int curNum = que.peek().conNode;
            que.poll();

            for(int i =0 ; i <list[curNum].size();i++){
                int getNum = list[curNum].get(i).conNode;
                int getWeight = list[curNum].get(i).weight;

                num[getNum]--;

                cnt[getNum] += (cnt[curNum] * getWeight);

                if(num[getNum] == 0 ){

                    que.add(list[curNum].get(i));
                }

            }




        }
    }


}
