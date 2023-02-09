class Solution {
    public int solution(int n) {
        int num = 1;
        int answer = 0;

        while(num <= n){
            if(n % num == 1){
                answer = num;
                break;
            }
            num++;
        }

        return answer;
    }
}