// 생각
    // citations 정렬 후 반복문 돌기
// 구현
    // h-index 최댓값은 citations의 길이부터 시작가능
    // citations 정렬
    // citations를 돈다(내림차순으로)
        // 각 값이 h-index보다 크거나 같으면 지금까지 count 1 증가 후 다음으로
        // 각 값이 h-index보다 작으면 h-index와 count비교해서 다르면 종료 후 h-index 1 줄이고 다시 반복
        // 각 값이 h-index보다 작으면 h-index와 count비교해서 같으면 해당 h-index 리턴

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int h_index = citations.length;
        
        // 정렬
        Arrays.sort(citations);
        
        // 반복문 돌기
        int count = 0;
        
        for(int i = citations.length-1; i>=0; i--){
            int cur = citations[i];
            if(cur >= h_index){
                count += 1;
            }else{
                if(count < h_index){
                    h_index -= 1;
                    count = 0;
                    i = citations.length;
                }else{
                    break;
                }
            }
        }
        
        return h_index;
    }
}