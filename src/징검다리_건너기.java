import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class 징검다리_건너기 {

    static int energy[][];
    static int move[];
    static int N;
    static int k;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.nextLine());
        energy = new int[N+1][4];
        move = new int[N+1];

        for(int i = 0 ; i < N-1 ; i++){
            String input = sc.nextLine();
            String[] inputArr = input.split(" ");
            energy[i+1][1] = Integer.parseInt(inputArr[0]);
            energy[i+1][2] = Integer.parseInt(inputArr[1]);
        }
        k = sc.nextInt();

        cross(0,1,false);

        System.out.println(ans);
    }


    public static void cross(int energySum, int now, boolean userBigJump){
        if(now == N) {
            ans = Math.min(ans,energySum);
        }
        if(now > N ) return;

        // now 번호에서 점프해서 소모하는 에너지
        cross(energySum+energy[now][1],now+1,userBigJump);
        cross(energySum+energy[now][2],now+2,userBigJump);

        if(!userBigJump){
            cross(energySum+k,now+3,true);
        }

    }
}













