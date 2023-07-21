// 재귀 피보나치는 반복되는 부분이 너무 많아서 범위가 클수록 성능이 안 좋으니 메모이제이션으로 해보기

class Solution {
    public int solution(int n) {
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 2; i<=n; i++){
            nums[i] = nums[i-2]%1234567 + nums[i-1]%1234567;
        }
        
        return nums[n]%1234567;
    }
}