// 생각
    // 1과 2를 배치한 합이 n을 만들 수 있는 모든 경우의 수를 구해야 함
    // 조합의 느낌
// 구현
    // 규칙이 피보나치 수열...   
    // 피보나치 수열의 값을 재귀로 구해도 되고 dp로 구해도 된다

class Solution {
    public long solution(int n) {
        long[] dp = new long[n+1];
        
        if(n == 1){
            return 1;
        }
        
        dp[1] = 1;
        dp[2] = 2;
      
        
        // n보다 작은 수까지 돌면서 dp 채우기
        for(int i = 3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        return dp[n];
    }
}






