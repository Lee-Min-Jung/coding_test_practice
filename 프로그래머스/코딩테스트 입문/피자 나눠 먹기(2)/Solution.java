class Solution {
    public int solution(int n) {
        // n의 배수를 6으로 나누기
        // 위의 결과에서 나머지가 생기지 않는 것이 답
        int num = 1;
        int answer = 0;
        while(n*num % 6 != 0){
            num++;
        }
        answer = (n*num)/6;
        return answer;

    }
}

// 다른 풀이 1
class Solution {
    public int solution(int n) {
        int answer = 1;

        while(true){
            if(6*answer%n==0) break;
            answer++;
        }

        return answer;
    }
}