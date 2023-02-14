// 첫 번째 풀이
class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i<=right; i++){
            int num = 1;
            int count = 0;
            while(num <= i){
                if(i % num == 0){
                    count++;
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

// 두 번째 풀이 - 이게 더 빠름
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

// 다른 사람 풀이 - 이게 제일 빠름
class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i<=right; i++){
            if(i % Math.sqrt(i) == 0){
                answer -= i;
            }else{
                answer += i;
            }
        }
        return answer;
    }
}