// 생각
    // map으로 각 개수 정리?
    // 일단 개수 제일 많은 건 넣어야 하니 그걸 먼저 살펴야 함
// 구현
    // tangerine을 돌면서 map에 크기별 개수를 구한다
    // map을 돌면서 개수만 배열로 만들어 정리한 후 내림차순 정렬
    // 위의 배열을 돌면서 k와 비교하며 구하기

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        // map 만들기
        for(int i = 0; i<tangerine.length; i++){
            hm.put(tangerine[i], hm.getOrDefault(tangerine[i],0)+1);
        }
        
        // 개수 배열 만들기
        int[] size = new int[hm.size()];
        int i = 0;
        for(int key : hm.keySet()){
            size[i] = hm.get(key);
            i++;
        }
        
        // k와 비교하며 구하기
        Arrays.sort(size);
        int answer = 0;
        
        for(int j = size.length-1; j>=0; j--){
            k = k - size[j];
            answer += 1;

            if(k <= 0){
                break;
            }
        }
        
        return answer;
    }
}