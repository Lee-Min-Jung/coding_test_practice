class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i<=right; i++){
            int num = 1;
            int count = 0;
            while(num <= (int)Math.sqrt(i)){
                if(i % num == 0){
                    count++;
                    if(i / num != num){
                        count++;
                    }
                }
                num++;
            }
            if(count % 2 == 0){
                answer += i;
            }else{
                answer -= i;
            }
        }

        return answer;
    }
}