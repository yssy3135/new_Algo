import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 병사_배치하기 {

    static int n;
    static int max = Integer.MAX_VALUE;
    static int ans = Integer.MAX_VALUE;
    static List<Integer> soldierList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        soldierList = new ArrayList<>();
        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            soldierList.add(sc.nextInt());
        }

        dfs(0,0,new ArrayList<>());

        System.out.println(ans);
    }

    public static void dfs(int exclude,int index,List<Integer> list){
        if(exclude >=ans) return;
        if(index == n-1){
            if(validation(list)){
                ans = Math.min(exclude,ans);
            }
            return;
        }
        //다음 순서가 현재보다 크면 무조건 열외해야한다.
        if(soldierList.get(index) < soldierList.get(index+1)){
            dfs(exclude+1,index+1,list);
            return;
        }

        List<Integer> newList = new ArrayList<>();

        newList.addAll(list);
        newList.add(soldierList.get(index));
        dfs(exclude,index+1,newList);
        dfs(exclude,index+1,list);
    }

    public static boolean validation(List<Integer> list){
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i) < list.get(i+1)){
                return false;
            }
        }
        return true;
    }

}
// 가장 긴 증가하는 부분수열 LIS - dp