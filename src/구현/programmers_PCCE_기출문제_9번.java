package 구현;

public class programmers_PCCE_기출문제_9번 {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;



        return solve(board,h,w);
    }


    static int dh[] = {0,0,-1,1};
    static int dw[] = {-1,1,0,0};
    public int solve(String[][] board, int h, int w) {
        int sum = 0;
        for(int i = 0; i < 4; i ++) {
            int check_h = h + dh[i];
            int check_w = w + dw[i];

            if(check_h >= 0 && check_h < board.length && check_w >= 0 && check_w <board[0].length) {
                if(board[h][w].equals(board[check_h][check_w])){
                    sum+=1;
                }
            }
        }
        return sum;
    }
}
