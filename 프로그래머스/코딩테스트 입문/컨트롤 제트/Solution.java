// 풀이 비교
// 나의 풀이가 스택 이용한 것보다 좀 더 빠름
// 아무래도 스택 이용하면 for문을 병렬적으로 두 번 도니까 그런듯? 근데 코드 의미상으로는 스택 이용한 것이 더 좋은 것 같음

//나의 풀이
class Solution {
    public int solution(String s) {
        // 주어진 문자열을 배열로 만든다
        // 주어진 문자열을 돌면서 차례대로 더한다
        // 만약 Z가 나오면 이전 값을 뺀다

        String[] arr = s.split(" ");
        String before = "";
        int answer = 0;

        for(String str : arr){
            if(str.equals("Z")){
                answer -= Integer.parseInt(before);
            }else{
                answer += Integer.parseInt(str);
                before = str;
            }
        }

        return answer;
    }
}

// 다른 사람의 풀이 - 스택 이용
import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack<String>();
        int answer = 0;

        String[] s_arr = s.split(" ");

        for(String str : s_arr){
            if(str.equals("Z")){
                stack.pop();
            }else{
                stack.push(str);
            }
        }

        for(String number : stack){
            answer += Integer.parseInt(number);
        }

        return answer;
    }
}