class Solution {
    public long solution(int price, int money, int count) {
        long sum = 0;
        long answer = 0;
        
        for(int i = 1; i<=count; i++){
            sum += price * i;
        }
        
        if(money - sum < 0){
            answer = sum - money;
        }
        
        return answer;
        
    }
}