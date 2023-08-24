// 생각
    // n을 k 진수로 바꾼 후 돌면서 조건에 맞는 소수를 찾는다
    // k진수로 바꾸는 메소드
    // String 다루기
// 구현
    // n을 k진수로 바꾼다
    // 위의 결과를 String으로 바꾼 후 0을 기준으로 split한다
    // 위의 결과 배열을 돌면서 소수 판단

class Solution {
    public int solution(int n, int k) {
        // n을 k진수로 바꾸기
        String str = change(n, k);
        
        // 0으로 split
        String[] strArr = str.split("0");
        
        // 소수 확인
        int answer = 0;
        
        for(String s : strArr){
            if(s.equals("")){
                continue;
            }
            long num = Long.parseLong(s);
            if(checkSosu(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    // 진수 변환
    public String change(int n, int k){
        StringBuilder sb = new StringBuilder();
        
        while(n != 0){
            sb.append(n%k);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
    
    // 소수 확인
    public boolean checkSosu(long n){
        if(n == 1){
            return false;
        }
        
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }
}