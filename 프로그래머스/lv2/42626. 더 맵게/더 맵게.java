// 작은 값이 우선순위 갖는 우선순위큐를 만든다
// scoville을 돌면서 우선순위큐에 값들을 다 넣는ㄷ
// 우선순위큐를 돈다
    // 꺼낸 값이 k보다 작다
        // 값 하나 꺼내고 그 다음 값 하나 꺼내서 스코빌 지수를 새로 계산한 후 큐에 넣는다
        // 섞은 횟수를 증가
    // 꺼낸 값이 k보다 크거나 같다
        // 멈춤
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int answer = 0;
        
        // scoville 돌면서 pq에 넣기
        for(int i = 0; i<scoville.length; i++){
            int target = scoville[i];
            pq.add(target);
        }
        
        // pq돌기
        while(!pq.isEmpty()){
            if(pq.peek() >= K){
                break;
            }else if(pq.peek() < K && pq.size() >= 2){
                int low = pq.poll();
                int low2 = pq.poll();
                int newSco = low + low2*2;
                pq.add(newSco);
                answer++;
            }else if(pq.size() <= 1){
                return -1;
            }
        }
        
        return answer;
    }
}