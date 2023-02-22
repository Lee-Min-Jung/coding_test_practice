import java.util.*;

class Solution {
    public int solution(int[] nums) {
        List<Integer> numList = new ArrayList<Integer>();
        int answer = 0;
        
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                    numList.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        
        for(int num : numList){
            int divider = 1;
            int count = 0;
            while(divider <= (int)Math.sqrt(num)){
                if(num % divider == 0){
                    count++;
                    if(num / divider != divider){
                        count++;
                    }
                }
                divider++;
            }
            if(count == 2){
                answer++;
            }
        }
        return answer;
        
    }
}