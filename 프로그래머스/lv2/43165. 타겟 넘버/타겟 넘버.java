// numbers의 맨 첫수의 양수를 dfs로 돌린다
//                    음수를 dfs로 돌린다
// 각 dfs 수행하며 다음 원소로 갈 때 플러스 마이너스 값을 다 살펴야 한다.
import java.util.*;

class Solution {
    static int[] numbers;
    static int target;
    
    public int solution(int[] numbers, int target) {
        // 세팅
        this.numbers = numbers;
        this.target = target;
        
        // 탐색 수행
        
        return dfs(0,0);
        
        
        
    }
    
    static int dfs(int nodeIndex, int sum){
        int answer = 0;
        
        if(nodeIndex == numbers.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
        answer += dfs(nodeIndex+1, sum+numbers[nodeIndex]);
        answer += dfs(nodeIndex+1, sum-numbers[nodeIndex]);
        
        return answer;
    }
}


