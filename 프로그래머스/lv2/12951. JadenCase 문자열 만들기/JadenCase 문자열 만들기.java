// 생각
    // 일단은 문자열 처리하는 문제로 보임
// 구현
    // 맨 첫 인덱스이면서 숫자가 아니면 대문자로
    // 그리고 이전 문자가 뭐였는지 저장을 한다
    // 맨 첫 인덱스 아니면 이전문자가 공백이면 대문자로


class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        // s 돌기
        char prev = ' ';
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(i == 0 && !Character.isDigit(ch)){
                sb.append(String.valueOf(Character.toUpperCase(ch)));
            }else if(i != 0 && prev == ' '){
                sb.append(String.valueOf(Character.toUpperCase(ch)));
            }else{
                sb.append(String.valueOf(Character.toLowerCase(ch)));
            }
            prev = ch;
            
        }
        
        return sb.toString();
    }
}