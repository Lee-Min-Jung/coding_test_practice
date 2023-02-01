class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // denom1과 denom2를 보고 분모를 같게 만들어야 한다
        // 만약 같으면 그냥 두기
        // 만약 큰수를 작은수로 나눴는데 나머지가 없으면 분모를 큰 수로 만든다
        // 만약 나머지가 있으면 두 수의 곱을 분모로 만든다
        // 분자끼리 더하고 분모는 그대로 둔다
        // 기약분수로 만든다
        // 분자와 분모 중 더 작은 값을 찾아서 2부터 작은 값까지 나눠본다

        int denom = 0;
        int number_first = numer1;
        int number_second = numer2;
        int plus_number = 0;

        if(denom1 == denom2){
            denom = denom1;
        }else if(denom1 % denom2 == 0 || denom2 % denom1 == 0){
            denom = denom1 > denom2 ? denom1 : denom2;
            number_first = number_first * (denom / denom1);
            number_second = number_second * (denom / denom2);
        }else{
            denom = denom1 * denom2;
            number_first = number_first * (denom / denom1);
            number_second = number_second * (denom / denom2);
        }

        plus_number = number_first + number_second;

        int smaller = plus_number < denom ? plus_number : denom;

        int count = 2;
        while(count <= smaller){
            if(plus_number % count == 0 && denom % count == 0){
                plus_number = plus_number / count;
                denom = denom / count;
            }else{
                count ++;
            }
        }

        int[] answer = new int[2];
        answer[0] = plus_number;
        answer[1] = denom;

        return answer;


    }
}