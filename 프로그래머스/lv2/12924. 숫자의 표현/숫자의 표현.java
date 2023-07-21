// 생각
    // 일단 반복문.... 아님 재귀??
// 구현
    // n보다 작을 때까지 n for문 돌기
        // 1부터 시작해서 재귀 함수로 보내기
    // 재귀
        // 시작 수와 마지막 수 지금까지의 합을 매개변수로 받기
        // 누적 합이 마지막 수보다 크면 return
        // 누적 합이 마지막 수와 같으면 답에 1 더하기
        // 아니면 시작수에 1 더한 값을 시작으로, 합 구해서 다시 호출 

class Solution {
    static int answer;
    
    public int solution(int n) {
        answer = 0;
        
        for(int i = 1; i<=n; i++){
           recur(i, i, n);
        }
        
        return answer;
        
    }
    
    public void recur(int start, int sum, int end){
        if(sum == end){
            answer += 1;
            return;
        }
        if(sum > end){
            return;
        }
        recur(start+1, sum+start+1, end);
    }
}