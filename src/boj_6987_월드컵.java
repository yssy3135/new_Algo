import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class boj_6987_월드컵 {

    public static class Country{
        int win;
        int draw;
        int loose;

        public Country(int win,int draw,int loose){
            this.win = win;
            this.draw = draw;
            this.loose = loose;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "win=" + win +
                    ", draw=" + draw +
                    ", loose=" + loose +
                    '}';
        }
    }

    static Country result[][] = new Country[4][6];
    static boolean visited[][] = new boolean[6][6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 4 ; i++){
            String input[] = br.readLine().split(" ");
            System.out.println(Arrays.toString(input));
            for(int j  = 0 ; j  < 18; j+=3){
                result[i][j/3] = new Country(Integer.parseInt(input[j]),Integer.parseInt(input[j+1]),Integer.parseInt(input[j+2]) );
            }
        }

    }


    public void  backTracking(int start){


        for(int i = start+1 ; i < 6;i++){
//            if(visited[start])

        }

    }


}
