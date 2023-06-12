// 1번 수포자: 1 2 3 4 5 반복, 5개
// 2번 수포자: 2 1 2 3 2 4 2 5 반복, 8개
// 3번 수포자: 3 3 1 1 2 2 4 4 5 5 반복, 10개
// answers의 개수가 곧 문제의 개수

// answers를 돌면서 각 수포자 배열과 비교해서 정답 개수 구하기
    // 각 수포자 배열은 계속 반복되니 비교할 때 나머지 연산 이용
    // answers의 인덱스 % 각 수포자 배열 길이
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 각 수포자 배열
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
      
        int[] score = new int[3];
        
        for(int i = 0; i<answers.length; i++){
            if(answers[i] == first[i%first.length]){
                score[0]++;
            }
            if(answers[i] == second[i%second.length]){
                score[1]++;
            }
            if(answers[i] == third[i%third.length]){
                score[2]++;
            }
            
        }
        
        // 테스트 확인
        for(int n : score){
            System.out.println(n);
        }
        
        // 많이 맞힌 사람 찾기
        int max = score[0];
        List<Integer> answer = new ArrayList<Integer>();
        
        for(int i = 0; i<3; i++){
            if(score[i] >= max & score[i] != 0){
                max = score[i];
            }
        }
        
        for(int i = 0; i<3; i++){
            if(score[i] == max){
                answer.add(i+1);
            }
        }
        
        Collections.sort(answer);
        
        // 결과 리턴
        int[] answerArr = new int[answer.size()];
    
        if(answer.isEmpty()){
            return answerArr;
        }else{
            for(int i = 0; i<answer.size(); i++){
                answerArr[i] = answer.get(i);
            }
        }
        return answerArr;
        
     
    }
}