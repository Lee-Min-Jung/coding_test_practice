import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> numSet = new HashSet<Integer>();
        List<Integer> numList = new ArrayList<Integer>();
        
        for(int i = 0; i<numbers.length; i++){
            for(int j = i+1; j<numbers.length; j++){
                numSet.add(numbers[i] + numbers[j]);
            }
        }
        for(int num : numSet){
            numList.add(num);
        }
        
        int[] answer = new int[numList.size()];
        
        for(int i = 0; i<answer.length; i++){
            answer[i] = numList.get(i);
        }
        
        Arrays.sort(answer);
        
        
        return answer;
    }
}