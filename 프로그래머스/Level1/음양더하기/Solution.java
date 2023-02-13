class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i<signs.length; i++){
            int num = 0;
            if(signs[i]){
                num = absolutes[i];
            }else{
                num = -absolutes[i];
            }
            answer += num;
        }
        return answer;
    }
}