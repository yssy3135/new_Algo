package 구현;

public class programmers_PCCP_기출_1번 {


    public static void main(String[] args) {

    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int readyTime = bandage[0];
        int healValue = bandage[1];
        int maxHealth = health;
        int plusHeal = bandage[2];

        int continueCount = 0;


        int attackCount = 0;
        int sec = attacks[attacks.length-1][0];



        for(int i = 1 ; i <= sec ; i++ ) {
            if(i == attacks[attackCount][0] ) {
                health -= attacks[attackCount][1];
                if(health <= 0 ) break;

                attackCount++;
                continueCount = 0;
                continue;
            }


            health = overMax(health, healValue, maxHealth);
            continueCount ++;

            if(continueCount == readyTime) {
                health = overMax(health, plusHeal, maxHealth);
                continueCount = 0 ;
            }
        }

        if(health <= 0 ) {
            return -1;
        }

        return health;
    }


    public int overMax(int value, int plusValue,int maxHealth) {
        int sumValue = value + plusValue;
        if(sumValue > maxHealth) return maxHealth;
        return sumValue;
    }

}
