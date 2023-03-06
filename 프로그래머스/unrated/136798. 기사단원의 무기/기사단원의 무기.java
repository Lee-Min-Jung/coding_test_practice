class Solution {
    public int solution(int number, int limit, int power) {
        // number를 돌면서 각 수의 약수 개수를 구한다
        // 약수 개수가 limit보다 작으면 그 개수를 저장하고,
        // 약수 개수가 limit보다 크면 power를 저장한다
        // 위에서 저장한 거를 합한다
        int answer = 0;
        
        for(int i = 1; i<=number; i++){
            int count = 0;
            for(int j = 1; j<=Math.sqrt(i); j++){
                if(i % j == 0){
                    count += 1;
                    if(Math.sqrt(i) != j){
                        count += 1;
                    }
                }
            }
            System.out.println(count);
            if(count <= limit){
                answer += count;
            }else{
                answer += power;
            }
        }
        
        return answer;
    }
}