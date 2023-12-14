package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2_복습 {


    static int arr[];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis();

    }

    public static void lis(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ;i++){
            if(list.size() == 0 || list.get(list.size()-1) < arr[i]){
                list.add(arr[i]);
            }else{
                list.set(lower_bounder(list,arr[i]),arr[i]);
            }
        }
        System.out.println(list.size());
    }

    public static int lower_bounder(ArrayList<Integer> list,int target){
       //low_bounder 는 target보다 큰 가장 작은 정수값
        int left = 0;
        int right = list.size()-1;
        while(left < right){
            int mid = ( left + right )/2;

            if(list.get(mid) >= target){
                //크거나 같은거니까 포함
                right = mid;
            }else{
                //작은거니까 포함 ㄴㄴ
                left = mid+1;
            }
        }


        return left;
    }


}
