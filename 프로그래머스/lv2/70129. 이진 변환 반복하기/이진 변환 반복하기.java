// 생각
    // 그냥 문자열 처리 잘 하면 될 것 같음
// 구현
    // s가 1이 아닐 때 동안 while 돈다
        // s에서 0을 다 공백으로 바꾼다
        // 원래 s와 공백으로 바꾼후의 s의 길이의 차이를 누적 
        // s를 s의 길이를 이진수로 바꾼 걸로 변환

class Solution {
    public int[] solution(String s) {
        int zeroCount = 0;
        int count = 0;
        // while 돌기
        while(!s.equals("1")){
            int beforeLen = s.length();
            s = s.replaceAll("0", "");
            int afterLen = s.length();
            zeroCount += beforeLen - afterLen;
            s = toBinary(afterLen);
            count += 1;
        }
        
        // 결과
        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = zeroCount;
        
        return answer;
    }
    
    public String toBinary(int num){
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            sb.append(String.valueOf(num % 2));
            num = num / 2;
        }
        return sb.reverse().toString();
    }
}