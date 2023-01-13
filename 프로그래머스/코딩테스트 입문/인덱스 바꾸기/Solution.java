import java.util.*;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        // my_string을 split이용해서 배열로 만들기
        // 배열 index에 num1, num2 줘서 값 바꾸기

        String[] answer = my_string.split("");
        String temp = answer[num1];
        answer[num1] = answer[num2];
        answer[num2] = temp;

        return String.join("", answer);
    }
}