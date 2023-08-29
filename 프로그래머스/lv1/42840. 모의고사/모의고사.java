// 생각
    // 1번 규칙: 1 2 3 4 5
    // 2 번 규칙: 2 1 2 3 2 4 2 5
    // 3번 규칙: 3 3 1 1 2 2 4 4 5 5 
    // answers 돌면서 인덱스가지고 각 번호의 사람의 정답과 비교해서 답인지 확인
// 구현
    // 각 번호의 규칙을 배열에 저장
    // answers를 돌기
        // answers[index] == 1번정답배열[index%1번정답배열 길이]
            // 정답 카운트 증가
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        // 규칙 저장
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // answers 돌기
        int[] rightCount = new int[3];
        
        for(int i = 0; i<answers.length; i++){
            if(answers[i] == one[i%one.length]){
                rightCount[0]++;
            }
            if(answers[i] == two[i%two.length]){
                rightCount[1]++;
            }
            if(answers[i] == three[i%three.length]){
                rightCount[2]++;
            }
        }
        
        // rightCount 돌면서 많이 맞힌 사람 담기
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        int max = 0;
        for(int i = 0; i<rightCount.length; i++){
            if(rightCount[i] >= max && rightCount[i] != 0){
                if(rightCount[i] != max && !answerList.isEmpty()){
                    answerList.remove(0);
                }
                answerList.add(i+1);
                max = rightCount[i];
            }
        }
        int[] answer = new int[answerList.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}