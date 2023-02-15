import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] str = s.split("");
        Arrays.sort(str);

        for(int i = str.length-1; i>=0; i--){
            answer.append(str[i]);
        }

        return answer.toString();
    }
}