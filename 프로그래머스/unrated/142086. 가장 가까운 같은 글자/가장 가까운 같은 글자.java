import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int[] answer = new int[s.length()];
        
        for(int i = 0; i<s.length(); i++){
            String str = String.valueOf(s.charAt(i));
            if(hm.get(str) != null){
                answer[i] = i - hm.get(str);
                hm.put(str, i);
            }else{
                answer[i] = -1;
                hm.put(str, i);
            }
        }
        
        return answer;
        
    }
}