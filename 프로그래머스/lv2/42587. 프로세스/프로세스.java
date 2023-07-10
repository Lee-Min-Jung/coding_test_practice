// 우선순위큐를 만든다. 숫자 큰 수가 우선순위 높도록. 
// 우선순위큐를 돈다 
    // 우선순위큐에 있는 값과 priorities의 index 값이 같지 않다
        // priorities의 다음 값으로 넘어간다
    // 우선순위큐에 있는 값과 priorities의 index 값이 같다
        // index 값과 location 값이 같다
            // answer에 1 더한 후 리턴
        // index 값과 location 값이 같지 않다
            // pq의 값을 하나 빼고 answer을 1 증가
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 우선순위큐 선언
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        // 우선순위큐에 넣기
        for(int i = 0; i<priorities.length; i++){
            pq.add(priorities[i]);
        }
        
        // 우선순위큐에서 빼면서 답 구하기
        int answer = 0;
        
        while(!pq.isEmpty()){
            for(int i = 0; i<priorities.length; i++){
                if(pq.peek() == priorities[i]){
                    if(i == location){
                        answer += 1;
                        return answer;
                    }
                    pq.poll();
                    answer+= 1;
                }
            }
        }
        
        return -1;
    }
}