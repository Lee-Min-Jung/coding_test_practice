// board: 게임 화면의 격자의 상태가 담긴 2차원 배열 
// moves: 인형을 집기 위해 크레인을 작동시킨 위치
// 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수


// board를 돌면서 0제외 숫자들만 따로 배열을 만든다
// moves를 돌면서
    // moves의 값에 맞는 걸 위에서 만든 배열에서 찾아서 제거
    // 위에서 찾은 값을 스택에 집어 넣기
    // 스택에 연속된 값 있는지 확인해서 연속된 값이면 제거하고 개수 증가
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // board 돌면서 0제외 숫자들만의 배열 만들기
        List[] realBoard = new ArrayList[board.length+1];
        for(int i = 0; i<realBoard.length; i++){
            realBoard[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == 0){
                    continue;
                }else{
                    realBoard[j+1].add(board[i][j]);
                }
            }
        }
        // 답 변수
        int count = 0;
        
        // moves 돌기
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i = 0; i<moves.length; i++){
            int pick = -1;
            // 뽑아서 스택에 넣기
            if(!realBoard[moves[i]].isEmpty()){
                pick = (int)realBoard[moves[i]].get(0);
                realBoard[moves[i]].remove(0);
                st.add(pick);
            }else{
                continue;
            }
            // 스택 확인
            if(st.size() >= 2){
                int num1 = st.pop();
                int num2 = st.pop();
                if(num1 == num2){
                    count += 2;
                }else{
                    st.add(num2);
                    st.add(num1);
                }
                
            }
            
            
        }
        

      
        
        return count;
    }
}