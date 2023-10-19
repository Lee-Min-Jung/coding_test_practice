import java.util.*;

class Solution {
    
    public String solution(String p) {
        // 맨 처음 주어진 게 올바른 괄호 문자열인지 확인
        boolean isRight = isRightP(p);
        if(isRight){
            return p;
        }
        
       
        String answer = recur(p);
        
        
        return answer;
    }
    // 분리
    static String recur(String str){
        if(str.equals("")) return "";
        
        String u = "";
        String v = "";
        for(int i = 0; i<str.length(); i++){
            u = str.substring(0, i+1);
            // 균형 잡힌
            if(isBalanceP(u)){
                v = str.substring(i+1, str.length());
                break;
            }
        }
        // u가 올바른 괄호 문자열
        if(isRightP(u)){
            return u + recur(v);
        }
        // u가 올바른 괄호 문자열 아님
        else{
            return "(" + recur(v) + ")" + makeU(u);
        }
    }
    // u조작 
    static String makeU(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<str.length()-1; i++){
            char ch = str.charAt(i);
            if(ch == '('){
                sb.append(')');
            }else if(ch == ')'){
                sb.append('(');
            }
        }
        return sb.toString();
    }
    // 균형잡힌 괄호 문자열 확인
    static boolean isBalanceP(String str){
        int openCount = 0;
        int closeCount = 0;
        
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(') openCount++;
            if(ch == ')') closeCount++;
        }
        
        if(openCount == closeCount) return true;
        
        return false;
    }
    // 올바른 괄호 문자열 확인
    static boolean isRightP(String str){
        Stack<Character> st = new Stack<Character>();
        
        // str돌기
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            // 여는 괄호
            if(ch == '('){
                st.push(ch);
            }
            // 닫는 괄호
            else if(ch == ')'){
                if(st.isEmpty()){
                   return false; 
                }else if(st.pop() != '('){
                    return false;
                }
            }
        }
        
        // 스택 비어있는지 확인
        if(st.isEmpty()){
            return true;
        }
        
        return false;
    }
}