// 생각
    // 각 걸리는 일수를 구한 후 
    // 걸리는 일수 돌면서 배포일 구하기
// 구현
    // progresses와 sppeeds를 돌면서 각 기능별 걸리는 일수를 구한다
        // 100에서 progresses 값을 뺀 후 speeds 값으로 나눈 나머지가 0이면 몫이 값
        // 만약 나머지가 0이 아니면 몫에 1 더한 것이 값
    // 걸리는 일수를 돈다
        // 지난날과 걸리는 일수를 비교했는데 걸리는 일수가 더 크다
            // 새로운 배포 개수를 1 증가하고 지난날을 걸리는 일수로 바꿈
        // 지난날과 걸리는 일수를 비교했는데 지난날이 더 크다
            // 마지막 배포 개수를 1 증가한다
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 기능별 걸리는 일수
        int[] days = new int[progresses.length];
        
        for(int i = 0; i<progresses.length; i++){
            if((100-progresses[i]) % speeds[i] == 0){
                days[i] = (100-progresses[i]) / speeds[i];
            }else{
                days[i] = (100-progresses[i]) / speeds[i] + 1;
            }
        }
        
        // 걸리는 일수 돌기
        int pastDays = 0;
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        
        for(int i = 0; i<days.length; i++){
            if(days[i] > pastDays){
                answerList.add(1);
                pastDays = days[i];
            }else{
                int temp = answerList.get(answerList.size()-1) + 1;
                answerList.remove(answerList.size()-1);
                answerList.add(temp);
            }
        }
        
        // 배열로 바꾸기
        int[] answer = new int[answerList.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
        
    }
}