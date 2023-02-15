class Solution {
    public int solution(int[] numbers) {
        int[] numList = new int[10];
        int answer = 0;
        
        for(int num : numbers){
            numList[num]++;
        }
        
        for(int i = 0; i<numList.length; i++){
            if(numList[i] == 0){
                answer += i;
            }
        }
        
        return answer;
    }
}