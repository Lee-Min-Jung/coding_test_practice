import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // nums를 set으로 변경해서 중복 없애기
        // 고를 수 있는 최대 수와 set에 있는 개수 비교
        // 만약 최대 수가 set 개수보다 많으면 답은 set 개수
        // 만약 최대 수와 set 개수가 같으면 같은 그 값 리턴
        // 만약 최대 수가 set 개수보다 적으면 답은 최대 수
        HashSet<Integer> hs = new HashSet<Integer>();
        int max_select = nums.length / 2;
        int answer = 0;

        for(int i = 0; i<nums.length; i++){
            hs.add(nums[i]);
        }

        if(max_select >= hs.size()){
            answer = hs.size();
        }else{
            answer = max_select;
        }

        return answer;
    }
}