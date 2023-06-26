// participant에는 있는데 completion에는 없는 사람들 구하기
// participant를 돌기
    // map에 이름: 1,2... 이런식으로 저장하기
// completion을 돌기
    // map에서 이름을 키로 해서 값을 찾고 값에 -1 하기
// map을 돌기
    // 각 키의 값이 1인 것이 답

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantMap = new HashMap<String, Integer>();
        
        // 참여자 돌면서 map 만들기
        for(String name : participant){
            participantMap.put(name, participantMap.getOrDefault(name, 0)+1);
        }
        
        // 완주자 돌기
        for(String name : completion){
            participantMap.put(name, participantMap.get(name)-1);
        }
        
        // map 돌기
        String answer = "";
        for(String key : participantMap.keySet()){
            if(participantMap.get(key) == 1){
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}