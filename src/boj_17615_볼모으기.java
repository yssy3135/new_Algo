import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_17615_볼모으기 {

    static String input[];
    static int n;
    static int ans = Integer.MAX_VALUE;
    static int redAmount;
    static int blueAmount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        input = new String[n];

        input = br.readLine().split("");

        redAmount = 0;
        blueAmount = 0;
        for(int i = 0 ; i < input.length; i++){
            if(input[i].equals("R")){
                redAmount++;
                continue;
            }
            blueAmount++;
        }

        // 둘중 많은걸 왼쪽 오른쪽 옮겨보고 더 작은게 답
        move("R");
        move("B");
        System.out.println(ans);

    }

    public static void move(String color){
        //왼쪽으로
        int moveCnt = 0 ;
        for(int i = n-1 ; i >= 0 ;i--){
            if(input[i].equals(color)){
                moveCnt++;
            }else{
                break;
            }
        }

        ans = Math.min(ans,bringColorBallCnt(color) - moveCnt);
        moveCnt = 0 ;
        for(int i = 0 ; i < input.length;i++) {
            if(input[i].equals(color)){
                moveCnt++;
            }else{
                break;
            }
        }
        ans = Math.min(ans,bringColorBallCnt(color) - moveCnt);
    }

    public static int bringColorBallCnt(String color){
        if(color.equals("R")){
            return redAmount;
        }
        return blueAmount;
    }


}
