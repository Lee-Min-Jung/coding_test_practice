import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Integer[] scoreInteger = new Integer[score.length];
        for(int i = 0; i<score.length; i++){
            scoreInteger[i] = Integer.valueOf(score[i]);
        }
        Arrays.sort(scoreInteger, Comparator.reverseOrder());
        
        for(int i = 1; i<=score.length/m; i++){
            answer += scoreInteger[m*i-1] * m;
        }
        
        return answer;
    }
}