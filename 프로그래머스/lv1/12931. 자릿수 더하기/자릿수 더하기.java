import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String[] n_arr = String.valueOf(n).split("");
        
        for(int i = 0; i<n_arr.length; i++){
            answer += Integer.parseInt(n_arr[i]);
        }
        
        return answer;
    }
}