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
        Stack<Integer> stack = new Stack<>();
        int prevTime = times[0];
        int count = 1;

        for (int i = 1; i < N; i++) {
            int currTime = times[i];

            if (currTime <= prevTime) {
                count++;
            } else {
                stack.push(count);
                count = 1;
                prevTime = currTime;
            }
        }
        stack.push(count);

        // 결과 배열 생성
        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
