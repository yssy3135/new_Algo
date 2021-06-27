package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 길찾기게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        solution(new int[][] {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});



    }

    static class Node{
        Node left;
        Node right;
        int x;
        int y;
        int num;


        public Node(int x,int y,int num) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }





    static Node node[];
    static ArrayList<Integer> preList ;
    static ArrayList<Integer> postList;
    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        //조건 트리구성.
        //y축이 가장 큰게 루트
        //그러면 y축 기준으로 정렬시켜서 같다면 왼쪽게 먼저 나오게(x축이 작은게)
        node = new Node[nodeinfo.length];

        preList = new ArrayList<>();
        postList = new ArrayList<>();

        for(int i = 0 ; i < nodeinfo.length;i++){
            node[i] = new Node(nodeinfo[i][0],nodeinfo[i][1],i+1);
        }

        //트리의 쵀대 높이는 n개

        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.y-o1.y == 0 ? o1.x-o2.x : o2.y-o1.y;
            }
        });



        Node root = node[0];

        for(int i = 1 ; i < node.length;i++){
            insert(root,node[i]);
        }

        pre(root);
        post(root);

        answer = new int[2][1];
        answer[0] = Arrays.stream(preList.toArray()).mapToInt(i -> (int) i).toArray();
        answer[1] = Arrays.stream(postList.toArray()).mapToInt(i -> (int) i).toArray();

        System.out.println(Arrays.deepToString(answer));

        return answer;
    }

    //node 는 root
    public static void insert(Node node,Node insertNode){
        if(node.x > insertNode.x){
            if(node.left == null){
                node.left = insertNode;
            }else{
                insert(node.left,insertNode);
            }
        }else{
            if(node.right == null){
                node.right = insertNode;
            }else {
                insert(node.right,insertNode);
            }

        }
    }

    //루트 -> 왼쪽 -> 오른쪽
    public static void pre(Node node){
        if(node == null) return;
        preList.add(node.num);
        pre(node.left);
        pre(node.right);
    }
    //왼쪽 -> 오른쪽 -> 루트
    public static void post(Node node){
        if(node == null) return;

        post(node.left);
        post(node.right);
        postList.add(node.num);
    }

}


