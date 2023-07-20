import java.util.*;

class Solution {
    public String solution(String s) {
        // 문자열 쪼개서 배열로 만들기
        String[] strArr = s.split(" ");
        
        // 정수 배열로 만들기
        int[] intArr = new int[strArr.length];
        for(int i = 0; i<intArr.length; i++){
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(intArr);
        
        // 최소 최대 찾아 답 만들기
        String answer = String.valueOf(intArr[0]) + " " + String.valueOf(intArr[intArr.length-1]);
        
        return answer;
    }
}