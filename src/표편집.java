import javax.swing.plaf.TreeUI;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 표편집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        solution(8,2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});

    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> subList = new ArrayList<>();
        for(int i = 0 ;i < n ;i++){
            list.add("O");
        }


        Stack<Integer> removeList = new Stack<>();

        int last = n-1;

        for(int i = 0 ; i < cmd.length;i++){
            StringTokenizer st = new StringTokenizer(cmd[i]);
            String order = st.nextToken();


            if(order.equals("D")){
//                "D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
                //아래로 가는거는 ++;
                int plus = Integer.parseInt(st.nextToken());
                int chk = 0;



            }else if (order.equals("C")){
//                "C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
                list.set(k,"X");
                removeList.add(k);
                if(k == last){
                    for(int j = last ; j >= 0 ; j--){
                        if(list.get(j).equals("O")){
                            last = j;
                            k = j;
                            break;
                        }
                    }

                }else{
                    for(int j = k ; j < n ;j++){
                        if(list.get(j).equals("O")){
                            k = j;
                            break;
                        }
                    }

                }

            }else if (order.equals("U")){
                //"U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
                //위로 가는거는 --
                int minus = Integer.parseInt(st.nextToken());

                int chk = 0;
                while(chk <= minus-1){
                    if(list.get(k-1).equals("O")){
                        chk++;
                    }
                    k -=1;
                }

            }else if (order.equals("Z")){
//                "Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
                    int recover = removeList.pop();
                    list.set(recover,"O");
                    if(recover > last){
                        last = recover;
                    }
            }

            System.out.println("명령"+order);
            System.out.println("인덱스"+k);
            System.out.println(list);


        }
        System.out.println(removeList);



        System.out.println(list);

        String tmp = list.toString().replaceAll("[\\[\\], ]","");

        StringBuilder sb = new StringBuilder();

        for(String word : list){
            sb.append(word);
        }

        answer = sb.toString();

        return answer;
    }

}
