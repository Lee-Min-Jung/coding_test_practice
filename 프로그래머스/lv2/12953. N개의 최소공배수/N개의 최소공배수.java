// 생각
    // 두 수의 최소공배수 구하는 걸 반복
// 구현
    // 두 수의 최소 공배수 구하기
        // 두 수 중 작은수까지 돌면서 두 수를 특정 수로 나눈다(1 제외)
            // 만약 둘 다 나눠진다
                // 두 수를 나눠진 수로 리셋
                // 다시 돌기
            // 둘 다 나눠지지 않는다
                // 두 수 각 곱한 거에 나누는 수 곱한 것이 최소공배수

class Solution {
    public int solution(int[] arr) {
        
        int answer = minGongbasu(Math.min(arr[0], arr[1]), Math.max(arr[0], arr[1]));

        // arr 돌면서 공배수 구하기
        for(int i = 2; i<arr.length; i++){
            answer = minGongbasu(Math.min(answer, arr[i]), Math.max(answer, arr[i]));
        }
        
        
        return answer;
    }
    
    public int minGongbasu(int a, int b){
        int temp = 2;
        int result = 1;
        
        
        while(temp <= a){
            if(a % temp == 0 && b % temp == 0){
                a = a / temp;
                b = b / temp;
                result *= temp;
            }else{
                temp++;
            }
        }
        
        result *= a*b;
        
        return result;
    }
}