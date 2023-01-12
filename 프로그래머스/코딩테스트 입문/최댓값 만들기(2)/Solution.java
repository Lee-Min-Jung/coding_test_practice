import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        // 양수와 음수 나누어 배열에 저장
        // 양수 배열 정렬
        // 양수 배열 길이 2이상인지 확인
        // 2이상이면 두 개 곱한 값 저장
        // 음수 배열 정렬
        // 음수 배열 길이 2이상인지 확인
        // 2이상이면 두 개 곱한 값 저장
        //양수배열에서 곱한 값과 음수배열 곱한 값 비교
        // 둘 다 결과 있으면 큰 값 return
        // 한 쪽 결과가 없을 경우
        // 음수 결과가 없음
        // 양수 결과 리턴
        // 양수 결과가 없음
        // 음수 결과 리턴
        // 둘 다 결과 없을 경우
        // 그 두개 곱한 결과 리턴

        ArrayList<Integer> minusVal = new ArrayList<Integer>();
        ArrayList<Integer> plusVal = new ArrayList<Integer>();
        int answer = 0;

        for(int i = 0; i<numbers.length; i++){
            if(numbers[i] < 0){
                minusVal.add(numbers[i]);
            }else{
                plusVal.add(numbers[i]);
            }
        }

        Collections.sort(minusVal);
        Collections.sort(plusVal);

        if(minusVal.size() >= 2 && plusVal.size() >= 2){ // 양수 2개이상, 음수 2개이상
            int minusAnswer = minusVal.get(0)*minusVal.get(1);
            int plusAnswer = plusVal.get(plusVal.size()-1) * plusVal.get(plusVal.size()-2);
            if(minusAnswer > plusAnswer){
                answer = minusAnswer;
            }else{
                answer = plusAnswer;
            }


        }else if(minusVal.size() == 1 && plusVal.size() == 1){ // 양수 1개, 음수 1개
            answer = minusVal.get(0) * plusVal.get(0);
        }else if(minusVal.size() >= 1 && plusVal.size() == 0){ // 음수만 존재
            answer = minusVal.get(minusVal.size()-1) * minusVal.get(minusVal.size()-2);
        }else if(plusVal.size() >= 1 && minusVal.size() == 0){ // 양수만 존재
            answer = plusVal.get(plusVal.size()-1) * plusVal.get(plusVal.size()-2);
        }else if(plusVal.size() == 1 && minusVal.size() >= 2){ // 양수 1개, 음수 여러개
            answer = minusVal.get(minusVal.size()-1) * minusVal.get(minusVal.size()-2);
        }else if(minusVal.size() == 1 && plusVal.size() >= 2){  // 음수 1개, 양수 여러개
            answer = plusVal.get(plusVal.size()-1) * plusVal.get(plusVal.size()-2);
        }

        return answer;

    }
}