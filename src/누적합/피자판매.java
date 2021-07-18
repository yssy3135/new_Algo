package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 피자판매 {


    static class Info{
       ArrayList<Integer> list;
       HashMap<Integer,Integer> map;

        public Info(ArrayList<Integer> list, HashMap<Integer, Integer> map) {
            this.list = list;
            this.map = map;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pizzaSize = Integer.parseInt(br.readLine());

        StringTokenizer st=  new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int pizzaA[] = new int[m];
        int pizzaB[] = new int[n];

        for(int i = 0 ; i < m ; i++){
            pizzaA[i] = Integer.parseInt(br.readLine());
        }

        for(int i  = 0 ; i < n; i++){
            pizzaB[i] = Integer.parseInt(br.readLine());
        }

        Info ainfo = sum(pizzaA,m);

//        ArrayList<Integer> alist = ainfo.list;
        HashMap<Integer,Integer> amap = ainfo.map;

        Info binfo = sum(pizzaB,n);
//        ArrayList<Integer> blist = binfo.list;
        HashMap<Integer,Integer> bmap = binfo.map;


        int ans = 0;
        for(int i = 0 ; i <= pizzaSize ;i++){
            if(amap.containsKey(i) && bmap.containsKey(pizzaSize-i)){
                ans += amap.get(i)*bmap.get(pizzaSize-i);
            }
//            System.out.println("포인트a"+i+"포인트b"+(pizzaSize-i));
//            System.out.println(ans);

        }

        System.out.println(ans);
    }


    public static Info sum(int arr[],int size){

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < size;i++){
            int sum = 0;
            for(int j = i  ; j < i+size-1;j++){
                sum += arr[j%size];
                list.add(sum);
                if(map.containsKey(sum)){
                    map.replace(sum, map.get(sum)+1);
                }else{
                    map.put(sum,1);
                }
            }
        }


        int total = 0;
        for(int i = 0 ; i < size;i++){
            total +=arr[i];
        }

        map.put(total,1);
        map.put(0,1);
        list.add(0);



        return new Info(list,map);
    }


}
