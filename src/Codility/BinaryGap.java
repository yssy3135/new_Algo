package Codility;

public class BinaryGap {

    public static void main(String args[]){

        System.out.println(solution(32));
    }


    public static int solution(int N) {

        String binaryNum = makeBinary(N);

        String[] splitBinaryNum = binaryNum.split("");

        return findMaxBinaryGap(splitBinaryNum);

    }

    private static int findMaxBinaryGap(String[] splitBinaryNum) {
        int max = 0;
        int cnt = 0 ;

        for(int i = 0; i < splitBinaryNum.length; i++) {
            if(splitBinaryNum[i].equals("1")) {
                max = Integer.max(max, cnt);
                System.out.println(cnt);
                cnt = 0;
            }else if (splitBinaryNum[i].equals("0")) {
                cnt++;
            }
        }

        max = Integer.max(max, cnt);

        return max;
    }

    public static String makeBinary(int num) {
        StringBuilder sb = new StringBuilder();

        while(num > 1) {
            sb.append(num%2);
            num = num/2;
        }
        sb.append(num);
        sb.reverse();

        return sb.toString();
    }



}
