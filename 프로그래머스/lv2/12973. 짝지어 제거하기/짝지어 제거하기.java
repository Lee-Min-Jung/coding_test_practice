// 스택 풀이
    // 스택이 비어 있으면 문자 넣기
    // 스택이 비어있지 않으면
        // 현재 문자와 스택에서 하나 꺼낸 거 비교해서 같으면 스택에서 지우고 다르면 현재 거를 넣기
    // 마지막까지 진행 후 스택이 비어 있지 않으면 0 비어있으면 1

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<Character>();
        
        // s 돌기
        for(int i = 0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(st.isEmpty()){
                st.push(ch);
            }else{
                if(ch == st.peek()){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
        }
        
        // 스택 확인
        if(st.isEmpty()){
            return 1;
        }
        return 0;
    }
}