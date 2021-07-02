package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 실패율 {
    static class Stage{
        int num;
        double failrate;

        public Stage(int num,double failrate){
            this.num = num;
            this.failrate = failrate;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int [N];



        //도달
        int clear[] = new int[N+2];
        //지금
        int now[] = new int[N+2];

        for(int i = 0 ; i < stages.length; i++){
            for(int j = 1 ; j < stages[i] ;j++){
                clear[j]++;
                now[j]++;
            }
            now[stages[i]] ++;
        }

//         for(int i = 0 ; i < clear.length; i++){
//             System.out.println("도달"+ (now[i] ) + "성공" +(clear[i]));
//         }


        Stage fail[] = new Stage[N+2];
        fail[0] = new Stage(0,0);

        for(int i = 1 ; i <= N+1; i++) {
            if(now[i]== 0){
                fail[i] = new Stage(i,0.0);
            }else if(clear[i] ==0){
                fail[i] =  new Stage(i,100.0) ;
            }else if (now[i] == clear[i] ){
                fail[i] = new Stage(i,0.0);
            }else{

                fail[i] =  new Stage(i,( (double)(now[i]-clear[i])/(double)now[i])) ;
            }
            // System.out.println((double)(now[i]-clear[i])/(double)now[i]);
        }

        Arrays.sort(fail,new Comparator<Stage>(){

            @Override
            public int compare(Stage o1,Stage o2){

                return Double.compare(o2.failrate,o1.failrate) == 0 ? o1.num - o2.num : Double.compare(o2.failrate,o1.failrate);
            }
        });

        int idx = 0;
        for(int i = 0 ; i < fail.length;i++){
            if(fail[i].num != 0 && fail[i].num != N+1 ){
                answer[idx] = fail[i].num;
                idx++;
            }
        }

        return answer;
    }
}
