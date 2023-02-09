class Solution {
    public long[] solution(int x, int n) {
        long num = x;
        long[] answer = new long[n];

        for(int i = 0; i<n; i++){
            answer[i] = num;
            num += x;
        }

        return answer;
    }
}