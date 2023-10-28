package Codility;

public class PermMissingElem {

    public static void main(String args[]){

        System.out.println();
    }

    public int solution(int[] A) {
        // Implement your solution here

        boolean checkArr[] = new boolean[A.length+1];

        for(int i = 0 ; i < A.length; i++) {
            checkArr[A[i]] = true;
        }

        int ans = 0;

        for(int i = 1 ; i < checkArr.length; i++) {
            if(!checkArr[i]) {
                ans = i;
                break;
            }
        }

        return ans;
    }

}
