// 생각
    // 괄호 검사는 너무나 유명한 스택문제인데
// 구현
    // s를 돈다
        // 여는 괄호면 스택에 넣는다
        // 닫는 괄호면 스택에서 하나 빼서 여는 괄호인지 확인한다
            // 만약 비어 있으면 false
            // 여는 괄호 아니면 멈추고 false 리턴
    // 다 돌았는데 스택에 뭐 있으면 false
import java.util.*;

class Solution {
    boolean solution(String s) {
    
        
        // s 돌기
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                st.push(ch);
            }else if(ch == ')'){
                if(st.isEmpty()){
                    return false;
                }
                if(st.pop() != '('){
                    return false;
                }
            }
        }
        
        if(!st.isEmpty()){
            return false;
        }
        
        return true;
    }
}