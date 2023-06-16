import java.util.*;

public class Solution {
    public int solution(int n) {
        String[] str = String.valueOf(n).split("");
        int answer = 0;
        
        for(int i = 0; i<str.length; i++){
            answer += Integer.parseInt(str[i]);
        }
        
        return answer;
    }
}