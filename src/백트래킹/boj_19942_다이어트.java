package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_19942_다이어트 {

    public static class Ingredient {
        int pro;
        int fat;
        int carb;
        int vitamin;
        int coast;

        public Ingredient(int pro, int fat, int carb, int vitamin,int coast) {
            this.pro = pro;
            this.carb = carb;
            this.vitamin = vitamin;
            this.fat = fat;
            this.coast = coast;
        }

        public void plus(Ingredient ingredient) {
            this.pro += ingredient.pro;
            this.carb += ingredient.carb;
            this.vitamin += ingredient.vitamin;
            this.fat += ingredient.fat;
            this.coast += ingredient.coast;
        }

        public boolean judge() {
            if (this.pro >= minValue.pro &&
                    this.carb >= minValue.carb &&
                    this.vitamin >= minValue.vitamin &&
                    this.fat >= minValue.fat){
                return true;
            }
            return false;
        }
    }

    static int n;
    static Ingredient minValue;
    static Ingredient[] ingredients;
    static boolean[] selected;
    static int ans = Integer.MAX_VALUE;
    static List<Integer> ansList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String tmp[] = br.readLine().split(" ");

        minValue = new Ingredient(
                Integer.parseInt(tmp[0]),
                Integer.parseInt(tmp[1]),
                Integer.parseInt(tmp[2]),
                Integer.parseInt(tmp[3]),
                0
        );

        ingredients = new Ingredient[n];
        selected = new boolean[n];

        for (int i = 0; i < n; i++) {
            String input[] = br.readLine().split(" ");
            ingredients[i] = new Ingredient(
                    Integer.parseInt(input[0]),
                    Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]),
                    Integer.parseInt(input[3]),
                    Integer.parseInt(input[4])
            );
        }
        backTracking(0);


        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
            ansList.stream().forEach(num -> System.out.printf(num+" "));
        }


    }

    public static void backTracking(int start) {
        //기준을 만족하는지 체크
        int coast = checkValidation();
        if( coast != -1){
            if(ans >coast){
                List<Integer> checkedNum = new ArrayList<>();
                for(int j = 0 ; j < n ;j++){
                    if(selected[j]){
                        checkedNum.add(j+1);
                    }
                }
                ansList = checkedNum;
                ans = coast;
            }
            return;
        }


        for (int i = start; i < n; i++) {
            if (!selected[i]) {
                selected[i] = true;
                backTracking(i + 1);
                selected[i] = false;
            }

        }

    }

    public static int checkValidation() {
        Ingredient sum = new Ingredient(0, 0, 0, 0,0);
        for (int i = 0; i < n; i++) {
            if (selected[i]) {
                sum.plus(ingredients[i]);
            }
        }

        if(!sum.judge()){
            return -1;
        }
        return sum.coast;

    }

}
