// 나의 풀이
class Solution {
    public int solution(int[] numbers) {

        int answer = 0;


        for(int i = 0; i<10; i++){
            boolean check = true;
            for(int j = 0; j<numbers.length; j++){
                if(i == numbers[j]){
                    check = false;
                }
            }
            if(check){
                answer += i;
            }
        }

        return answer;
    }
}

// 다른 풀이 1 - 속도 이게 더 빠름
class Solution {
    public int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
}

// 다른 풀이 2
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] count = new int[10];

        for(int i=0; i<numbers.length; i++){
            count[numbers[i]]++;
        }

        for(int i=0; i<count.length; i++){

            if(count[i] == 0){
                answer += i;
                System.out.print(i);
            }
        }

        return answer;
    }
}