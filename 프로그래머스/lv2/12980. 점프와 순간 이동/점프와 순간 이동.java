// 생각
    // 모든 경우의 수 다 살펴봐야 하면 완전탐색인데
    // 모든 경우의 수 안 봐도 되는 방법이 있나?
    // 뒤로 가는 걸로 생각해보면.... 
// 구현
    // n이 0이 될 때까지 반복
        // n이 짝수이다
            // n을 2로 나눈다
        // n이 홀수이다
            // n에서 1을 뺀다
            // 답에 1을 더한다

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        // 반복
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            }else{
                n -= 1;
                answer += 1;
            }
        }
        
        return answer;
    }
}