class Solution {
    public int solution(int n) {
        // n보다 작은 수 다 살펴보기
        // 살펴보면서 해당 수보다 작은 수로 나누어 나머지 없으면 합성수
        int answer = 0;
        for(int i = 1; i<=n; i++){
            int check = 0;
            for(int j = 1; j<=i; j++){
                if(i % j == 0){
                    check += 1;
                }
            }
            if(check >= 3){
                answer += 1;
            }
        }
        return answer;
    }
}