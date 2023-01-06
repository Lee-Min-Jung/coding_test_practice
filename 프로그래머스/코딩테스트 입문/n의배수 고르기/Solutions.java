import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        // 주어진 배열 돌기
        // 돌면서 n으로 나누었을 때 나머지 없는지 확인
        // 나머지 없으면 남기고 나머지 생기면 버리기
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i = 0; i<numlist.length; i++){
            int num = numlist[i];
            if(num % n == 0){
                answer.add(num);
            }
        }

        int[] answer2 = new int[answer.size()];
        for(int i = 0; i<answer2.length; i++){
            answer2[i] = answer.get(i).intValue();
        }

        return answer2;

    }
}