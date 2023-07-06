// progresses 별로 며칠 후에 끝나는 지 구하기
// 위에서 구한 값을 바탕으로 돌기
    // curr <= prev : 이전 것과 같이 배포 가능하니 이전 count + 1
    // curr > prev : 기존 count를 push 
                    // count를 1로 재설정, prev도 재설정
// 스택 값 거꾸로 뺀 것이 답


import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        int[] times = new int[N];

        // progresses 별로 며칠 후에 끝나는 지 구하기
        for (int i = 0; i < N; i++) {
            int time = 0;
            if ((100 - progresses[i]) % speeds[i] == 0) {
                time = (100 - progresses[i]) / speeds[i];
            } else {
                time = (100 - progresses[i]) / speeds[i] + 1;
            }
            times[i] = time;
        }

        // 배포일에 배포될 기능의 수 계산
        Stack<Integer> st = new Stack<>();
        
        int count = 1;
        int prev = times[0];
        
        for(int i = 1; i<N; i++){
            int curr = times[i];
            
            if(curr <= prev){
                count++;
            }else{
                st.push(count);
                count = 1;
                prev = times[i];
            }
        }
        st.push(count);
        
        
        // 결과 배열 생성
        int[] answer = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }

        return answer;
    }
}
