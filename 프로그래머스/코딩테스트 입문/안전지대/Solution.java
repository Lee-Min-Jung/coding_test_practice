import java.util.*;

class Solution {
    public int solution(int[][] board) {
        ArrayList<ArrayList<Integer>> index_list = new ArrayList<ArrayList<Integer>>();
        int N = board.length;
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        int answer = 0;

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == 1){
                    ArrayList<Integer> a1 = new ArrayList<Integer>();
                    a1.add(i);
                    a1.add(j);
                    index_list.add(a1);
                }
            }
        }


        for(ArrayList a : index_list){
            for(int i = 0; i<8; i++){
                int nx = (int)a.get(0) + dx[i];
                int ny = (int)a.get(1) + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    board[nx][ny] = 1;
                }
            }
        }

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == 0){
                    answer += 1;
                }
            }
        }

        return answer;
    }
}