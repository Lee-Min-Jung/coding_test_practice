class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int divisor = 1;
        int small = n < m ? n : m;
        int big = n > m ? n : m;
        int maxYackSu = 0;
        int minBaeSu = 0;
        
        // 최대공약수
        while(divisor <= small){
            if(n % divisor == 0 && m % divisor == 0){
                maxYackSu = divisor;
            }
            divisor++;
        }
        
        answer[0] = maxYackSu;
        
        // 최소공배수
        if(maxYackSu == 1){
            answer[1] = n * m;
        }else{
            answer[1] = (n / maxYackSu) * (m / maxYackSu) * maxYackSu;
        }
        
        return answer;
        
    }
}