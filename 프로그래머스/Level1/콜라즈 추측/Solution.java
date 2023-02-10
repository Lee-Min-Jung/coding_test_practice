class Solution {
    public int solution(int num) {
        int answer = 0;
        long num2 = (long)num;

        while(answer <=500 && num2 != 1){
            if(num2 % 2 == 0){
                num2 = num2 / 2;
                answer ++;
            }else if(num2 % 2 == 1){
                num2 = num2 * 3 + 1;
                answer ++;
            }else if(num2 == 1){
                answer = 0;
                break;
            }
        }
        if(answer > 500){
            return -1;
        }



        return answer;
    }
}