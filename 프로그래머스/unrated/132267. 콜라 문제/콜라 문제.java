class Solution {
    public int solution(int a, int b, int n) {
        // n보다 작으며 가장 큰 a의 배수를 구한다
        // 위에서 구한 수를 a로 나눈 후 b를 곱해서 받은 개수를 구한다
        // 원래 개수 - 배수 + 위에서 받은 걸 구한다
        // 이러한 과정을 총 개수가 a보다 작아질 때까지 반복
        int answer = 0;
        int total = n;
        
        while(n >= a){
            if(n % a == 0){
                answer += (n / a) * b;
                total = total - n + (n / a) * b;
                n = total;
            }else{
                n--;
            }
        }
        return answer;
    }
}