class Solution {
    public long solution(int a, int b) {
        int first = a < b ? a : b;
        int second = a < b ? b : a;
        long answer = 0;

        for(int i = first; i<=second; i++){
            answer += i;
        }

        return answer;
    }
}

// 다른 풀이 - 이게 속도 빠름
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long first = a < b ? a : b;
        long second = a < b ? b : a;

        answer = (first+second) * (second-first+1) / 2;

        return answer;
    }
}

