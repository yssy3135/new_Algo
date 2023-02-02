package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_9934_완전_이진_트리 {

    /**
     * 완전이진 트리의 특성상 왼쪽 subTree와 오른쪽 subTree의 크기가 동일하다.
     */

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }

    static int k;
    static int[] node;
    static ArrayList<Integer>[] savedTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        savedTree = new ArrayList[k];

        node = new int[(int)Math.pow(2,k)-1];



        for (int i = 0; i < k; i++) {
            savedTree[i] = new ArrayList<>();
        }
        for (int i = 0; i <node.length; i++) {
            node[i] = Integer.parseInt(st.nextToken());

        }
        bs(0,node.length,0  );

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < savedTree.length;i++){
            savedTree[i].forEach(num -> sb.append(num+" "));
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void bs(int start,int end,int depth){

        if(start == end) return;
        int mid = (start+end)/2;
        savedTree[depth].add(node[mid]);

        bs(start,mid,depth+1);
        bs(mid+1,end,depth+1);

    }
}
