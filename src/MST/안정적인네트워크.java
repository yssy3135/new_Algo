package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 안정적인네트워크 {

    static class Node {
        int a;
        int b;
        int dis;

        public Node(int a, int b, int dis) {
            super();
            this.a = a;
            this.b = b;
            this.dis = dis;
        }


    }


    static int parents[];
    static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.dis - o2.dis;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //컴퓨터의 개수
        int n = Integer.parseInt(st.nextToken());
        //연결되어 있는 컴퓨터들의 쌍의 개수
        int m = Integer.parseInt(st.nextToken());


        parents = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(find(x,y)) continue;

            union(x, y);
        }

        for (int i = 0; i < n - 1; i++) {
            String tmp[] = br.readLine().split(" ");
            if(i == 0) continue;
            for (int j = i; j < n; j++) {
                pq.add(new Node(i + 1, j + 1, Integer.parseInt(tmp[j])));
            }
        }

        /**
         * 회사 측에서는 네트워크에 고장이 발생하더라도 컴퓨터들이 연결되어 있도록 안정적인 네트워크를 구축하고자 한다.
         * 네트워크에 고장이 발생하는 경우는 두 가지가 있다.
         * 첫 번째는 직접 연결되어 있는 두 컴퓨터의 연결이 끊어지는 경우이다.
         * 회사 측은 이런 경우에도 이 두 컴퓨터가 다른 컴퓨터들을 경유하여 연결되어 있기를 원한다.
         * 두 번째는 컴퓨터가 고장 나는 경우이다. 회사 측은 이런 경우에는 고장 나지 않은 컴퓨터들끼리 연결되어 있기를 원한다.
         */

        int sum = 0;
        ArrayList<int[]> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (find(cur.a,cur.b)) continue;

            union(cur.a, cur.b);
            sum += cur.dis;

            list.add(new int[]{cur.a, cur.b});
        }
        System.out.println(sum + " " + list.size());

        for (int a[] : list) {
            System.out.println(a[0] + " " + a[1]);
        }


    }


    public static int getParent(int x) {
        if (parents[x] == x) return x;

        return getParent(parents[x]);
    }

    public static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }

    }

    public static boolean find(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a == b) {
            return true;
        } else {
            return false;
        }


    }
}
