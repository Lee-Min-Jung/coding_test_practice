import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> ponSet = new HashSet<Integer>();
        
        for(int num : nums){
            ponSet.add(num);
        }
        
        int answer = 0;
        int pickNum = nums.length/2;
        
        if(pickNum < ponSet.size()){
            answer = pickNum;
        }else{
            answer = ponSet.size();
        }
        
        return answer;
    }
    
}