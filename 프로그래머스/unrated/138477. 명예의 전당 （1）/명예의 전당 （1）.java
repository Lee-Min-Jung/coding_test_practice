import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        // score를 돌면서 점수를 하나씩 본다
            // k보다 작거나 같
                // 맨 처음 거가 최저 점수가 된다
                // 다음 거 살폈을 때 최저 보다 작으면 최저 점수 바꾼다
            // k보다 클 때
                // 살폈을 때 최저보다 크면 집어 넣고 최저를 다시 구한다
        
        int[] answer = new int[score.length];
        List<Integer> kScore = new ArrayList<Integer>();
        int min = score[0];
        
        for(int i = 0; i<score.length; i++){
            if(i <= (k-1)){
                kScore.add(score[i]);
                if(score[i] < min){
                    min = score[i];
                }
            }else{
                if(score[i] > min){
                    kScore.remove(Integer.valueOf(min));
                    kScore.add(score[i]);
                    min = Collections.min(kScore);
                }
            }
            answer[i] = min;
        }
        
        return answer;
    }
}