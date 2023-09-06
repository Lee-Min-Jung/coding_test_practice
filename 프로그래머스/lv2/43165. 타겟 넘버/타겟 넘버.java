// 생각
    // 재귀 dfs
// 구현
    // recur()

class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        
        recur(numbers, 0, 0, target);
        
        return answer;
    }
    
    public void recur(int[] numbers, int sum, int index, int target){
        if(index == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        recur(numbers, sum+numbers[index], index+1, target);
        recur(numbers, sum-numbers[index], index+1, target);
    }
}