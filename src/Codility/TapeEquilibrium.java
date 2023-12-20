package Codility;

public class TapeEquilibrium {

    public static void main(String args[]){

        System.out.println(solution(new int[]{3, 1, 2, 4, 3}));
    }

    public static int solution(int[] A) {
        int arrSize = A.length-1;
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= A.length/2+1 ; i++) {
            int calValue = rangeSum(A, 0, arrSize - i) - rangeSum(A, arrSize - i +1, arrSize);
            if(calValue < 0) {
                calValue *= -1;
            }
            min = Math.min(min, calValue);
        }


        return min;
    }

    public static int rangeSum(int[] arr, int start, int end) {
        int sum = 0;
        for(int i = start; i <= end ; i++) {
            sum += arr[i];
        }

        return sum;
    }



}
