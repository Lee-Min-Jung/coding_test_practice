//나의 풀이
class Solution {
    public int solution(int num, int k) {
        //num을 string으로 바꿔서 하나씩 살펴보기
        //하나씩 살펴보다가 k를 char이나 string으로 바꾼 것과 같은 게 있으면 인덱스 리턴
        //만약 없으면 끝까지 간 후 -1 리턴

        String numStr = Integer.toString(num);
        char c = Character.forDigit(k, 10);
        int answer = 0;

        for(int i = 0; i<numStr.length(); i++){
            if(numStr.charAt(i) == c){
                answer = i+1;
                break;
            }
        }
        if(answer == 0){
            answer = -1;
        }

        return answer;
    }
}

//다른 풀이
class Solution {
    public int solution(int num, int k) {
        String numStr = String.valueOf(num);
        String kStr = String.valueOf(k);

        int answer = numStr.indexOf(kStr);

        return answer < 0 ? -1 : answer +1;
    }
}
