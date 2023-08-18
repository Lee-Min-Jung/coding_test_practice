// 생각
    // 대놓고 큐를 쓰라고 알려 줬음. 근데 우선순위 큐인가
// 구현
    // 우선순위 큐를 만들어서 priorities를 우선순위 큐에 넣는다
    // 우선순위 큐를 돈다
        // priorities를 돈다
            // 우선순위 큐의 값과 priorities의 값이 같다
                // priorities를 도는 index와 location 값이 같다
                    // answer에 1 추가하고 답으로 return
                // priorities를 도는 index와 location 값이 다르다
                    // 큐에서 값 하나 빼고 answer에 1 추가하고 다음 priorities로 넘어간다
            // 우선순위 큐의 값과 priorities의 값이 다르다
                // 다음 priorities로 넘어간다

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 우선순위 큐 만들어서 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i = 0; i<priorities.length; i++){
            pq.add(priorities[i]);
        }
        
        // 우선순위큐와 priorities 돌면서 정답 찾기
        int answer = 0;
        
        while(!pq.isEmpty()){
            for(int i = 0; i<priorities.length; i++){
                if(pq.peek() == priorities[i]){
                    if(i == location){
                        answer++;
                        return answer;
                    }else{
                        pq.poll();
                        answer++;
                    }
                }
            }
        }
        
        return 1;
        
    }
}