// 생각
    // numbers 각각을 돌 때 플러스 마이너스 각각을 붙여가며 가지치기해서 결과를 확인해야 함  \
    // numbers를 돌면서 값 하나를 확인하며 재귀적으로 플러스 마이너스 붙인 함수를 부르기
// 구현
    // 재귀함수 호출
    // 전역 변수로 answer 선언
    // 재귀 함수
        // 지금까지의 합, numbers 배열, 현재 인덱스를 매개변수로 받기
        // 현재 인덱스+1 == numbers의 길이
            // 지금까지의 합이 target과 같다
                // 정답 1 증가
            // 지금까지의 합이 target과 같지 않다
                // 패스
        // 현재 인덱스 < numbers의 길이
            // 지금까지의 합에 현재 들어온 수 더하기
            // 다음에 살펴야 할 값에 플러스 붙인 재귀 함수 호출
            // 다음에 살펴야 할 값에 마이너스 붙인 재귀 함수 호출


class Solution {
    static int answer;
    static int targetNum;
    
    public int solution(int[] numbers, int target) {
        // 초기화
        answer = 0;
        targetNum = target;
        
        // 재귀함수 호출
        recur(0, numbers, 0);
        
        // 정답
        return answer;
    }
    
    public void recur(int sum, int[] numbers, int index){
        if(index == numbers.length){
            if(sum == targetNum){
                answer++;
            }
        }else{
            recur(sum+numbers[index], numbers, index+1);
            recur(sum-numbers[index], numbers, index+1);
        }
    }
}