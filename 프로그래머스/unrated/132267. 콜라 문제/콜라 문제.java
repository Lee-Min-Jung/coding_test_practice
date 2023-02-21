class Solution {
    public int solution(int a, int b, int n) {
        
        int answer = 0;
        
        while(n >= a){
            answer += (n / a) * b;
            n = b * (n / a) + n % a;
        }
        return answer;
    }
}