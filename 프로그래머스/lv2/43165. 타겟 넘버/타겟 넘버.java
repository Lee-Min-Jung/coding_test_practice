// 생각
    // numbers를 돌면서 가지치기 하면서 양수 음수로 나누어 numbers 끝까지 경우를 구한 후 수 다 더하면 되는데..
    // 깊이 탐색하면 되니까 dfs인듯
// 구현
    // numbers의 맨 첫 원소의 양수를 시작으로 해서 dfs를 돈다
    // numbers의 맨 첫 원소의 음수를 시작으로 해서 dfs를 돈다
    // dfs
        // 들어온 원소의 인덱스, 지금까지의 합, numbers 배열을 매개변수로 받는다
        // 들어온 인덱스 다음부터 다시 dfs를 돈다
            // 이때 음수 양수로 나누어 dfs를 돌게 해야 한다
        // 들어온 인덱스가 numbers의 길이와 같으면
            // 지금까지의 합이 target과 같은지 비교한 후 답을 1 증가

class Solution {
    static int answer = 0;
    static int target;
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        
        // dfs 돌기
        dfs(0, 0, numbers);
        
        // 답 리턴
        return answer;

    }
    
    public void dfs(int index, int sum, int[] numbers){
        if(index == numbers.length){
            if(sum == target){
                answer += 1;
            }
        }else{
            dfs(index+1, sum+numbers[index], numbers);
            dfs(index+1, sum-numbers[index], numbers);
        }
       
    }
}