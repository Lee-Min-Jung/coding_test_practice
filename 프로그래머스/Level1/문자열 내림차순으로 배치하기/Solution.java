// 나의 풀이 - 이게 약간 더 빠름
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

// 약간 수정

import java.util.*;

class Solution {
    public String solution(String s) {

        String[] str = s.split("");
        Arrays.sort(str);

        StringBuilder answer = new StringBuilder(String.join("", str));

        return answer.reverse().toString();
    }
}