// 0 1 3 5 6 값
// 0 1 2 3 4 인덱스
// citations[i] 는 현재 원소의 인용 횟수
// citations.length-i 는 현재 원소보다 크거나 같은 인용 횟수 가진 논문의 개수
// 둘 중 작은 값이 h-index의 후보다. 
    // 만약 citations[i] = 5, citations.length - i = 3 이라고 할 때
    // h-index의 정의에 따라 5번 이상 인용된 논문이 5편이상 이어야 5가 h-index될 수 있는데
    // 그 원소보다 인용 횟수가 크거나 같은 논문 개수가 더 적어서 5는 h-index가 될 수 없다

import java.util.*;


class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, smaller);
        }
        return answer;
    }
}