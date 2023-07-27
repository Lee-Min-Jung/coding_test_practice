// 생각
    // 괄호쌍 검사니까 스택
// 구현
    // 괄호쌍 검사하는 부분을 함수로 따로 만들기
        // 스택 비어 있으면 무조건 넣기
        // 여는 괄호면 스택에 넣기
        // 닫는 괄호인데 스택 비어있지 않으면 스택에서 꺼내서 일치하는지 확인
    // 회전
        // s의 길이만큼 돌기
            // i부터 s길이만큼 substring한 결과 + 0부터 i 만큼 substring한 결과를 확인
        
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // s 길이만큼 반복
        for(int i = 0; i<s.length(); i++){
            String str = s.substring(i, s.length()) + s.substring(0, i);
            
            if(check(str)){
                answer += 1;
            }
        }
        
        return answer;
        
    }
    
    // 괄호 검사 
    public boolean check(String s){
        Stack<Character> st = new Stack<Character>();
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        hm.put(']', '[');
        hm.put(')', '(');
        hm.put('}', '{');
        
        for(int i = 0; i<s.length(); i++){
            Character ch = s.charAt(i);
            
            if(ch == '[' || ch == '(' || ch == '{'){
                st.push(ch);
            }else if(ch == ']' || ch == ')' || ch == '}'){
                if(st.isEmpty()){
                    return false;
                }else{
                    if(hm.get(ch) != st.pop()){
                        return false;
                    }
                }
            }

            
        }
        
        if(!st.isEmpty()){
                return false;
            }
        
        return true;
    }
}