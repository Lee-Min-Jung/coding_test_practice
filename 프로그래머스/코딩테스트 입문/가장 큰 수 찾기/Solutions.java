import java.util.*;

class Solution {
    public int[] solution(int[] array) {
        // 주어진 배열을 하나씩 살펴보면서 최댓값과 최댓값 인덱스 찾아서 저장해놓기

        int maxValue = array[0];
        int maxIndex = 0;

        for(int i = 0; i<array.length; i++){
            if(array[i] > maxValue){
                maxValue = array[i];
                maxIndex = i;
            }
        }

        int[] answer = new int[2];

        answer[0] = maxValue;
        answer[1] = maxIndex;

        return answer;

    }
}