package Codility;

import java.util.ArrayList;
import java.util.List;

public class FrogJmp {

    public static void main(String args[]){

        System.out.println();
    }

    public int solution(int X, int Y, int D) {
        // Implement your solution here

        if(X >= Y) return 0;

        int dis = Y - X;

        return dis%D == 0 ? dis/D : (dis/D)+1;
    }

}
