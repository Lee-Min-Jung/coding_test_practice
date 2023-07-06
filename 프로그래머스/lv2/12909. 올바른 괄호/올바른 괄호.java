// s를 돈다
    // 여는 괄호면 스택에 넣는다
    // 닫는 괄호면 스택에서 pop 하면서 여는 괄호인지 확인한다
        // 만약 여는 괄호 아니면 바로 올바르지 않은 거니까 멈추기
    // 다 하고 나서 스택 비어있지 않으면 올바르지 않은 것


import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<Character>();
        char[] charArr = s.toCharArray();
        
        // s 돌기
        for(Character ch : charArr){
        
            // 여는 괄호면 스택에 넣기
            if(ch == '('){
                st.push(ch);
                continue;
            }
            // 닫는 괄호면 스택에서 pop하면서 여는 괄호 나오는지 확인
            if(ch == ')'){
                if(!st.isEmpty() && st.pop() == '('){
                    continue;
                }else{
                    return false;
                }
            }
            
        }
        // 마지막에 스택 확인
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}