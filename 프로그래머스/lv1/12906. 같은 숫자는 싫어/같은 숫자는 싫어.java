// 스택 만들기
// arr 돌면서 스택 활용
    // 스택 비어있으면 넣기
    // 비어있지 않으면 하나 빼서 넣으려는 것과 비교 후 같으면 안 넣고 안 같으면 넣기
// 스택에서 다 빼내면서 배열 만들기(반대로 돌아야 함)

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<Integer>();
        
        // arr 돌기
        for(int num : arr){
            if(st.isEmpty()){
                st.push(num);
            }else if(st.peek() != num){
                st.push(num);
            }
        }
        
        // 정답
        int[] answer = new int[st.size()];
        for(int i = answer.length-1; i>=0; i--){
            answer[i] = st.pop();
        }
        
        
        return answer;
        
    }
}