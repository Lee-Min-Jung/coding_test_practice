import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        HashMap<String, Integer> xMap = new HashMap<String, Integer>();
        HashMap<String, Integer> yMap = new HashMap<String, Integer>();
        StringBuilder answer = new StringBuilder();
        
        for(String s : X.split("")){
            xMap.put(s, xMap.getOrDefault(s, 0)+1);
        }
        for(String s : Y.split("")){
            yMap.put(s, yMap.getOrDefault(s, 0)+1);
        }
        
        for(int i = 9; i>=0; i--){
            String str = String.valueOf(i);
            while(xMap.getOrDefault(str, -1) > 0 && yMap.getOrDefault(str, -1) > 0){
                answer.append(str);
                xMap.put(str, xMap.get(str)-1);
                yMap.put(str, yMap.get(str)-1);
            }
        }
        
        if(answer.toString().equals("")) return "-1";
        if(answer.toString().substring(0,1).equals("0")) return "0";
        return answer.toString();
    }
}