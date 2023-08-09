// 생각
    // 분류별 개수는 map으로 저장
// 구현
    // clothes 돌면서 분류별로 개수 세서 map에 저장
    // 만약 map에 분류가 1개밖에 없다
        // 해당 분류의 개수를 리턴
    // map에 분류가 2개 이상
        // 각 분류의 개수 합 + 각 분류끼리의 곱 리턴

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        // 분류별 개수 저장
        for(int i = 0; i<clothes.length; i++){
            String type = clothes[i][1];
            hm.put(type, hm.getOrDefault(type, 0)+1);
        }
        
        // 분류별 돌면서 개수 계산
        int answer = 1;
        
        for(String key : hm.keySet()){
            answer *= hm.get(key)+1;
            
        }
        
        return answer-1;
        
        
    }
}