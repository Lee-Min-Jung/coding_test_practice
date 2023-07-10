// 큐를 하나 만든다. 큐는 다리라고 볼 수 있다. 
// truck_weights를 돈다
    // 큐가 비어 있는 경우
        // 큐에 현재 트럭을 넣는다, 시간을 1 증가, 다리에 있는 총 트럭 무게 증가, 다음 트럭으로 이동
    // 큐가 꽉 찼다
        // 큐에서 하나 빼고, 뺀 만큼 총 트럭 무게도 빼기, 다음 트럭으로 이동하면 안 됨
    // 큐가 꽉 차지 않고 다리에 있는 총 트럭 무게 합이 weight보다 작거나 같다
        // 큐에 현재 트럭 넣기, 시간을 1 증가, 총 트럭 무게 증가, 다음 트럭으로 이동
    // 큐가 꽉 차지 않고 다리에 있는 총 트럭 무게 합이 weight보다 크다
        // 시간을 1 증가, 다음 트럭으로 이동하지 않음

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<Integer>();
        
        // 변수
        int time = 0;
        int sum = 0;
        
        // truck_weights 돌기
        for(int i = 0; i<truck_weights.length; i++){
            int target = truck_weights[i];
            
            while(true){
                if(q.isEmpty()){
                    q.add(target);
                    time += 1;
                    sum += target;
                    break;
                }else if(q.size() == bridge_length){
                    sum -= q.poll();
                }else if(sum+target <= weight){
                    q.add(target);
                    time += 1;
                    sum += target;
                    break;
                }else{
                    time += 1;
                    q.add(0);
                }
            }
        }
        
        return time+bridge_length;
    }
}