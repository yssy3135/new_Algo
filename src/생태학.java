import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class 생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word;
        int countOfTree = 0;
        Map<String,Float> treeMap = new TreeMap<>();

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            word = sc.nextLine();
            ++countOfTree;
            if(treeMap.containsKey(word)){
                treeMap.put(word, treeMap.get(word)+1);
            }else{
                treeMap.put(word,  1f);
            }
        }

            Set<String> treeNames = treeMap.keySet();
            int finalCountOfTree = countOfTree;
            treeNames.forEach(tree -> {
                float numberOfTree = treeMap.get(tree);
                float percent = (numberOfTree / finalCountOfTree)*100;
                System.out.println(tree+ " "+ String.format("%.4f",percent));
            });



    }

}
