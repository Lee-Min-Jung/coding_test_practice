// citations를 오름차순으로 정렬한다
// 정렬된 citations을 돈다
    // 값 0 1 3 5 6
    // 인 0 1 2 3 4
    // citations[i]은 citations[i]번 이상 인용된 논문임을 의미
    // 전체 개수 - i는 citations[i]번 이상 인용된 논문의 개수
    // 전체 개수 - i와 citations[i] 의 값이 같은 것 중 최소 i를 구한다
        // 전체 개수 - i와 citations[i]의 값이 다르면 다음 i로 넘어감
        // 
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 정렬
        Arrays.sort(citations);
        
        // 돌기
        for(int i = 0; i<citations.length; i++){
            if(citations.length - i <= citations[i]){
                return citations.length - i;
            }
        }
        
        return 0;
    }
}