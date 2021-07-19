package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 전구_복습 {

    static class Info{
        int idx;
        int num;

        public Info(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        String tmp[] = br.readLine().split(" ");
        String tmp2[] = br.readLine().split(" ");

        int switchNum[] = new int[n];
        int bulbNum[] = new int[n];

        HashMap<Integer,Integer> swichIdx = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            switchNum[i] = Integer.parseInt(tmp[i]);
            bulbNum[i] = Integer.parseInt(tmp2[i]);
            swichIdx.put(switchNum[i],i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n;i++){
            list.add(swichIdx.get(bulbNum[i]));
        }

        ArrayList<Integer> returnList = lis(list);

        Stack<Integer> st = new Stack<>();
        for (int i  : returnList){
            st.add(switchNum[i]);
        }

        st.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop()+" ");
        }
        System.out.println(returnList.size());
        System.out.println(sb.toString());

    }

    public static ArrayList lis(ArrayList<Integer> list){

        ArrayList<Integer> lisList = new ArrayList<>();
        ArrayList<Info> track =new ArrayList<>();

        for(int i = 0 ; i < list.size();i++ ){
            int get = list.get(i);
            if(lisList.size() == 0 || lisList.get(lisList.size()-1) < get){
                lisList.add(get);
                track.add(new Info(lisList.size()-1,get));
            }else{
                int setIdx = bs(lisList,get);
                lisList.set(setIdx,get);
                track.add(new Info(setIdx,get));
            }
        }

        int last= lisList.size()-1;

        ArrayList<Integer> resList = new ArrayList<>();
        for(int i = track.size()-1 ; i >= 0 ; i--){
            if(track.get(i).idx == last){
                resList.add(track.get(i).num);
                last--;
            }
        }


        return resList;
    }

    public static int bs(ArrayList<Integer> list,int target){
        int left = 0;
        int right = list.size()-1;

        while(left < right){
            int mid = (left+right)/2;

            if(list.get(mid) >= target){
                right = mid;
            }else{
                left= mid+1;
            }

        }

        return left;
    }




}
