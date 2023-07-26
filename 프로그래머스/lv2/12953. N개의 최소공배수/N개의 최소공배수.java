class Solution {
    public int solution(int[] arr) {
        int answer = lcm(arr[0], arr[1]);
        
        // arr 돌면서 최소공배수 구하기
        for(int i = 2; i<arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    // 두 수의 곱을 최대공약수로 나누어 최소공배수 구하기
    public int lcm(int a, int b){
        return a*b/gcd(Math.max(a, b), Math.min(a, b));
    }
    // 유클리드 호제법으로 최대공약수 구하기
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
}