// 생각
    // 도시이름을 돌면서 캐시에 있는지 없는지, 자리 있는지 등 확인한 후 하나 거칠 때 마다 상황에 맞게 실행시간 더하기
    // 캐시를 만들어야 하는데 큐를 이용해서 만들 수 있다
// 구현
    // 큐 만들기
    // 도시이름 돌기
        // 만약 큐에 해당 도시가 없으면서 캐시크기 안 넘쳤다
            // map에 해당 도시 넣고 횟수 1로 만들기
            // 정답 5 더하기
        // 큐에 해당 도시가 없으면서 캐시크기 넘쳤다
            // 최근에 가장 적게 사용된 거 하나 빼고 해당 도시를 넣는다
            // 정답 5 더하기
        // 큐에 해당 도시가 있다
            // 정답 1 더하기

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<String>();
        int answer = 0;
        
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        // 도시 이름 돌기
        for(String city : cities){
            city = city.toLowerCase();
            
            if(q.contains(city)){ // 캐시 hit
                q.remove(city);
                q.add(city);
                answer += 1;
            }else{ // 캐시 miss
                if(q.size() >= cacheSize){
                    q.remove();
                }
                q.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}