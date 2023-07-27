// 생각
    // 중복된 합 세면 안 되니까 집합
    // 
// 구현
    // 반복문 돌아야하는데 총 도는 횟수가 elements길이*(elements길이-1)+1이다
    // 확인해야 하는 길이수만큼 반복문을 돈다(1개~elements길이)
        // 배열을 돌면서 위의 길이 안에 속하는 원소들의 합을 구한다
            // 집합에 넣는다

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> answer = new HashSet<Integer>();
        
        // 길이수만큼 반복문 돌기
        for(int len = 1; len<=elements.length; len++){
            // 배열돌기
            for(int i = 0; i<elements.length; i++){
                int sum = 0;
                // 배열에서 길이만큼 구하기 위한 반복문
                for(int k = i; k < i+len; k++){
                    sum += elements[k%elements.length];
                }
                answer.add(sum);
            }
        }
        
        return answer.size();
    }
}