// 생각
    // 재귀로 계속 하다가 종료조건 오면 종료해야할듯
// 구현
    // 재귀(int[] numbers, int index, int sum)
        // if(index == numbers.length-1)
            // if(sum == target) : count++
            // 종료
        // 재귀(numbers, index+1, sum+현재값)
        // 재귀(numbers, index+1, sum-현재값)

class Solution {
    static int targetCopy;
    static int answer;
    public int solution(int[] numbers, int target) {
        // 초기화
        targetCopy = target;
        answer = 0;
        // 재귀에 넣기
        recur(numbers, 0, 0);
        
        // 정답
        return answer;
    }
    
    public void recur(int[] numbers, int index, int sum){
        if(index == numbers.length){
            if(sum == targetCopy){
                answer++;
            }
            return;
        }
        recur(numbers, index+1, sum+numbers[index]);
        recur(numbers, index+1, sum-numbers[index]);
    }
}