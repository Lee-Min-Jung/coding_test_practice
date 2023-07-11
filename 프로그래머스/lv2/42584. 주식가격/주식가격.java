// 스택을 하나 만든다
// 정답 배열을 만든다
// prices를 돈다
    // 스택이 비어 있다
        // 스택에 현재 가격 인덱스를 넣는다
    // 스택이 비어 있지 않고 현재 인덱스의 가격이 스택에서 꺼낸 인덱스의 가격보다 작다(가격 하락 발생)
        // 스택에서 꺼낸 인덱스에 있는 정답 배열의 값을 현재 인덱스 - 꺼낸 인덱스로 수정, 스택에서 값 하나 제거
    // 스택이 비어 있지 않고 현재 인덱스의 가격이 스택에서 꺼낸 인덱스의 가격보다 크다(가격 하락하지 않음)
        // 스택에 현재 가격 인덱스를 넣는다
    // 현재 가격 인덱스의 값과 앞에 있는 값 다 비교해야 하니 whlie로 돌아야 한다

// 스택에 빌 때 까지 스택 돌기(현재 여기 남아있는 인덱스는 가격 하락이 발생하지 않은 인덱스들)
    // 스택에서 꺼낸 인덱스에 있는 정답 배열의 값을 prices 길이 - 꺼낸 인덱스 - 1 로 수정, 스택에서 하나 제거

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> st = new Stack<Integer>();
        int[] answer = new int[prices.length];
        
        // prices 돌기
        for(int i = 0; i<prices.length; i++){
            int currIndex = i;
    
            while(!st.isEmpty() && prices[currIndex] < prices[st.peek()]){
                answer[st.peek()] = currIndex - st.peek();
                st.pop();
            }
            
            st.push(currIndex);
        }
        
        // 스택 나머지 값 돌기
        while(!st.isEmpty()){
            int idx = st.pop();
            answer[idx] = prices.length - idx - 1;
        }
        
        return answer;
    }
}