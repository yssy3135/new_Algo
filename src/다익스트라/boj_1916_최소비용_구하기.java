package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1916_최소비용_구하기 {
    static class Node{
        private int nodeNum;
        private int coast;

        public Node(int nodeNum,int coast){
            this.nodeNum = nodeNum;
            this.coast = coast;
        }

    }


    static int n;
    static int busCnt;
    static List<Node> nodeList[];
    static int coastList[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        coastList = new int[n+1];
        Arrays.fill(coastList,Integer.MAX_VALUE);
        nodeList = new ArrayList[n+1];
        busCnt = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n+1; i++){
            nodeList[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < busCnt ; i++ ) {
            String tmp[] = br.readLine().split(" ");
            nodeList[Integer.parseInt(tmp[0])].add(new Node(Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2])));
        }



        String tmp[] = br.readLine().split(" ");
        int start = Integer.parseInt(tmp[0]);
        int target = Integer.parseInt(tmp[1]);

        dijkstra(start);

        System.out.println(coastList[target]);

    }


    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.coast - o2.coast;
            }
        });
        coastList[start] = 0;

        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curNodeNum = curNode.nodeNum;
            int coast = curNode.coast;

            if(coastList[curNodeNum] < coast) continue;
            for(int i = 0 ; i <nodeList[curNodeNum].size(); i++){
                Node connectedNode = nodeList[curNodeNum].get(i);

                if(coastList[connectedNode.nodeNum]> coast + connectedNode.coast){
                    coastList[connectedNode.nodeNum] = coast + connectedNode.coast;
                    pq.add(new Node(connectedNode.nodeNum,coast + connectedNode.coast));
                }
            }
        }

    }
}
