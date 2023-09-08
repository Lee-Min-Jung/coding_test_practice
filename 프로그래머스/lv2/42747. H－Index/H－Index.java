// 생각
    // citations를 정렬한 다음 임의로 h index 정해서 살피면서 구하기
// 구현
    // citations 정렬
    // for(citations) : 내림차순으로 돌아야 함
        // h = citations[i];
        // for(citations)
            // h보다 크거나 같은 개수(u), h보다 작은 개수 구하기(d)
        // if(u>=h && d <= h) : 해당 h가 정답이니 멈추기
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        // 정렬
        Arrays.sort(citations);
        
        // citations 돌기
        int hIndex = citations.length;
        for(int i = citations.length-1; i>=0; i--){
            int upCount = 0;
            int downCount = 0;
            for(int j = 0; j<citations.length; j++){
                if(citations[j] >= hIndex){
                    upCount++;
                }
                if(citations[j] < hIndex){
                    downCount++;
                }
            }
            if(upCount>=hIndex && downCount <= hIndex){
                break;
            }
            hIndex--;
        }
        return hIndex;
    }
}