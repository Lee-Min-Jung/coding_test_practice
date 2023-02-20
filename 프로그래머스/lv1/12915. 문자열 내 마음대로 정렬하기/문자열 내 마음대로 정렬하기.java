import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        // strings를 돌면서 각 문자열의 n 번째 문자를 구한다
        
        for(int i = 0; i<strings.length; i++){
            strings[i] = strings[i].charAt(n) + strings[i];
        }
        
        Arrays.sort(strings);
        
        for(int i = 0; i<strings.length; i++){
            strings[i] = strings[i].substring(1, strings[i].length());
        }
        
            
        return strings;
    }
}