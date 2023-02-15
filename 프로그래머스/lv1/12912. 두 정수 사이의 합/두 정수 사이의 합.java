class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long first = a < b ? a : b;
        long second = a < b ? b : a;
        
        answer = (first+second) * (second-first+1) / 2;
        
        return answer;
    }
}

