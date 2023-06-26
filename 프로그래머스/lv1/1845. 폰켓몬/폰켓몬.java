//  N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return 하도록 

// nums를 돈다
    // map에 번호와 개수를 저장한다
// count 변수를 만들어 골라야 하는 개수를 센다
// map을 count가 특정 수가 될 때까지 돈다
    // key를 set에 집어 넣는다

// 위 과정을 마친 후 set의 개수를 답으로 리턴

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> ponMap = new HashMap<Integer, Integer>();
        
        // num 돌기
        for(int num : nums){
            ponMap.put(num, ponMap.getOrDefault(num, 0)+1);
        }
        
        int count = 0;
        
        // map 돌기
        HashSet<Integer> ponSet = new HashSet<Integer>();
        for(int key : ponMap.keySet()){
            if(ponMap.get(key) > 0){
                ponSet.add(key);   
            }
            ponMap.put(key, ponMap.get(key)-1);
            count++;
            if(count == nums.length/2){
                break;
            }
        }
        
        // 리턴
        return ponSet.size();
    }
}