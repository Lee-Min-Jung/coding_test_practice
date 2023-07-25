
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(people);
        
        // people 돌기
        int start = 0;
        int end = people.length-1;
        while(start <= end){
            if(start == end){
                answer += 1;
                break;
            }
            if(people[start] + people[end] <= limit){
                answer += 1;
                start += 1;
                end -= 1;
            }else{
                answer += 1;
                end -= 1;
            }
        }
        
        
        return answer;
    }
}