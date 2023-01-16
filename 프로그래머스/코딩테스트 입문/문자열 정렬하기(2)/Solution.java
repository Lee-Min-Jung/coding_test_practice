import java.util.*;

class Solution {
    public String solution(String my_string) {
        // my_string을 소문자로 바꾸기
        // 위의 결과를 정렬하기

        char[] charArr = my_string.toLowerCase().toCharArray();
        Arrays.sort(charArr);
        String answer = new String(charArr);

        return answer;
    }
}