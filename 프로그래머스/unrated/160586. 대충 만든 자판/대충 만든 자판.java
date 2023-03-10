import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // keymap을 보고 hashmap에 각 알파벳의 위치를 저장한다
        // 위에서 구한 hashmap을 이용해 targets의 값을 구하고 더한다
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> position = new HashMap<Character, Integer>();
        
        for(int i = 0; i<keymap.length; i++){
            for(int j = 0; j<keymap[i].length(); j++){
                char ch = keymap[i].charAt(j);
                int pos = position.getOrDefault(ch, j+1);
                position.put(ch, Math.min(pos, j+1));
            }
        }
        
        for(int i = 0; i<targets.length; i++){
            for(int j = 0; j<targets[i].length(); j++){
                char ch = targets[i].charAt(j);
                if(position.containsKey(ch)){
                    answer[i]+=position.get(ch);
                }else{
                    answer[i]=-1;
                    break;
                }
            }
            
            
            
        }
        
        
        return answer;
    }
}