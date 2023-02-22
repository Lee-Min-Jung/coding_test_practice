import java.util.*;

class Solution {
    public int solution(int n) {
        boolean[] check = new boolean[n+1];
        Arrays.fill(check, true);
        int answer = 0;
        
        for(int i = 2; i<=n; i++){
            if(check[i]){
                for(int j = 2; j*i<=n; j++){
                    check[j*i] = false;
                }
                answer++;
            }
        }
        return answer;
    }
}