package Codility;

public class Cyclic_rotation {

    public static void main(String args[]){

        System.out.println();
    }

    public int[] solution(int[] A, int K) {
        // Implement your solution here

        for (int i = 0; i < K; i++) {
            arrRotation(A);
        }

        return A;
    }

    private static void arrRotation(int[] A) {
        if(A.length == 0 ) return;
        Integer last = A[A.length-1];

        for(int i = A.length-1; i >= 0; i--) {
            if(i == 0) {
                A[i] = last;
                continue;
            }
            A[i] = A[i - 1];
        }
    }


}
