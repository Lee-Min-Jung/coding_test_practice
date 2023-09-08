// 생각
    // map만들어서 참여자 저장 싹 하고 완수자를 map에서 찾으면서 못 완수한 사람 리턴
// 구현
    // for(participant)
        // map에 모두 저장해서 값 1로, 동명이인이면 값 2되게
    // for(completion)
        // 해당 값을 map에서 찾아서 값 1씩 빼기
    // for(map)
        // 값 0인 거 찾아서 key 리턴
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        // participant 돌기
        for(int i = 0; i<participant.length; i++){
            hm.put(participant[i], hm.getOrDefault(participant[i], 0)+1);
        }
        
        
        // completion 돌기
        for(int i = 0; i<completion.length; i++){
            hm.put(completion[i], hm.get(completion[i])-1);
        }
        
        
        // map돌기
        String answer = "";
        for(String key : hm.keySet()){
            if(hm.get(key) != 0){
                answer = key;
            }
        }
        
        return answer;
    }
}