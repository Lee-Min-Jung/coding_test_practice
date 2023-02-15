import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
            
        String pattern = "^[0-9]+$";
        boolean answer = Pattern.matches(pattern, s); 
        
        if(s.length() != 4 && s.length() != 6){
            answer = false;
        }
        return answer;
    }
}