// 생각
    // discount를 돌면서 map으로 각 개수 저장한 후 want의 항목별 개수와 비교해서 확인하며 가능하면 답 1 증가
// 구현
    // want와 number를 돌면서 map으로 항목별 개수 저장
    // 범위가 10이 되게 discount를 돌면서 항목별 개수 저장
        // want의 개수와 discount의 항목별 개수 비교하며 discount 개수가 크거나 같으면 1 증가 아니면 패스

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantMap = new HashMap<String, Integer>();
        int answer = 0;
        
        // want와 number 돌면서 개수 저장
        for(int i = 0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        // discount 돌기
        int start = 0;
        int end = 9;
        while(end < discount.length){
            HashMap<String, Integer> discountMap = new HashMap<String, Integer>();
            boolean allHave = true;
            for(int i = start; i<=end; i++){
                discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0)+1);
            }
            for(int j = 0; j<want.length; j++){
                if(wantMap.getOrDefault(want[j], 0) > discountMap.getOrDefault(want[j], 0)){
                    allHave = false;
                    break;
                }
            }
            if(allHave){
                answer += 1;
            }
            start += 1;
            end += 1;
        }
        
        return answer;
    }
}