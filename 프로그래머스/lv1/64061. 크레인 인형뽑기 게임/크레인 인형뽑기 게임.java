import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // moves를 돌면서 moves의 원소 하나를 가져와 해당 원소를 행으로 하는 것 중 0아닌 걸 찾아서 저장후 해당 원소 0으로 만들기
        // 스택에서 하나 꺼낸 후 위에서 저장한 것과 비교해서 같으면 답에 2 더하고 제거, 같지 않으면 스택에 추가
        Stack<Integer> dollStack = new Stack<Integer>();
        int answer = 0;
        
        for(int i = 0; i<moves.length; i++){
            int col = moves[i]-1;
            for(int j = 0; j<board.length; j++){
                if(board[j][col] == 0){
                    continue;
                }else{
                    if(!dollStack.isEmpty()){
                        if(dollStack.peek() == board[j][col]){
                            answer += 2;
                            dollStack.pop();
                            board[j][col] = 0;
                        }else{
                            dollStack.push(board[j][col]);
                            board[j][col] = 0;
                        }
                    }else{
                        dollStack.push(board[j][col]);
                        board[j][col] = 0;
                    }
                    break;
                }
            }
            
        }
        
        return answer;
    }
}