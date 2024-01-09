package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = null;
        while(!(input = br.readLine()).equals(".")){
            String[] words = input.split("");
            Stack<String> stOpen = new Stack<>();
            boolean flag = false;

            for(int i = 0 ; i < words.length; i++) {
                if(words[i].equals("(") || words[i].equals("[") ) {
                    stOpen.push(words[i]);
                }


                if(words[i].equals(")") || words[i].equals("]")) {
                    if(stOpen.isEmpty()) {
                        flag = true;
                    }

                    String openWord =  stOpen.peek() ;

                    if(openWord.equals("(") && words[i].equals(")")) {
                        stOpen.pop();
                    }

                    if(openWord.equals("[") && words[i].equals("]")){
                        stOpen.pop();
                    }
                }
            }

            if(stOpen.isEmpty() && !flag) {
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }

    }
}
