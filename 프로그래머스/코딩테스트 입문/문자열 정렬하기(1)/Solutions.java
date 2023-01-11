import java.util.*;
// 나의 풀이
class Solution {
    public int[] solution(String my_string) {
        // 문자열에서 숫자만 추출
        // 추출한 문자열을 배열로 만들어 오름차순 정렬

        String numString = my_string.replaceAll("[^0-9]","");
        String[] numStringList = numString.split("");
        int[] answer = new int[numString.length()];

        for(int i = 0; i<numStringList.length; i++){
            answer[i] = Integer.parseInt(numStringList[i]);
        }
        Arrays.sort(answer);


        return answer;

    }
}