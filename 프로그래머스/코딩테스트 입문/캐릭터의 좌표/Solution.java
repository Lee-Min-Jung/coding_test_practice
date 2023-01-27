import java.lang.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        // keyinput for문 돌면서 하나씩 확인
        // 방향에 맞게 좌표 수정
        // 벗어나면 되돌리기
        int[] answer = {0,0};
        int maxWidth = (board[0]-1)/2;
        int maxHeight = (board[1]-1)/2;


        for(String str : keyinput){
            if(str.equals("left")){
                answer[0] -= 1;
            }else if(str.equals("right")){
                answer[0] += 1;
            }else if(str.equals("up")){
                answer[1] += 1;
            }else if(str.equals("down")){
                answer[1] -= 1;
            }

            if(Math.abs(answer[0]) > maxWidth){
                if(str.equals("left")){
                    answer[0] += 1;
                }else if(str.equals("right")){
                    answer[0] -= 1;
                }
            }
            if(Math.abs(answer[1]) > maxHeight){
                if(str.equals("up")){
                    answer[1] -= 1;
                }else if(str.equals("down")){
                    answer[1] += 1;
                }
            }

        }


        return answer;

    }
}