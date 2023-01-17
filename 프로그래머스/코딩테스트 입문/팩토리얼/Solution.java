// 정답 코드
class Solution {
    public int solution(int n) {
        int answer = 1;

        for(int i = 1; i<=10; i++){
            if(n >= factorial(i)){
                answer = i;
                continue;
            }else{
                break;
            }
        }
        return answer;
    }

    public int factorial(int n){
        if(n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}

// 처음에 생각했던 코드
// 하나의 경우가 이 코드에 맞지 않아서 틀린 것 같은데 어떤 경우지?
class Solution {
    public int solution(int n) {
        int answer = 1;

        for(int i = 1; i<=n; i++){
            if(n < factorial(i)){
                answer = i-1;
                break;
            }
        }
        return answer;
    }

    public int factorial(int n){
        if(n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
