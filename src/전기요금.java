import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전기요금 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0) break;

            int left = 0;
            int right = bill(a);

            //left와 right 는 사용량
            while(left <= right){
                int mid = (left + right)/2;
                int mon = bill(left) + bill(right);


                if(bill(left) + bill(right) < a){
                    left = mid+1;
                }else if ( bill(left) + bill(right) >a){
                    right = mid-1;
                }else{
                    System.out.println("left"+left+"right"+right);
                    break;
                }

            }
        }




    }


    public static int bill(int watt){
        int pay = 0 ;
        while( watt > 0){
            if(watt > 1000000){
                int over = watt-1000000;
                watt -= over;
                pay += 7*over;
            }else if ( watt > 10000){
                int over = watt-10000;
                watt -= over;
                pay += 5*over;
            }else if ( watt > 100){
                int over = watt-100;
                watt -= over;
                pay += 3*over;
            }else{
                pay += 2*watt;
                watt = 0;
            }
        }

        return pay;
    }

}
