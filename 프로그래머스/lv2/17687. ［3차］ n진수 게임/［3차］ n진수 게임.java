// 생각
    // 문자열 다루기 및 진법 변환
// 구현
    // while(true) 로 돌기 시작
        // 숫자 0부터 시작해서 해당 숫자를 특정 진법으로 바꾼 결과를 구한다
        // 위의 결과를 돈다
            // 순서를 가리키는 index를 참여 인원수로 나눈 나머지가 0이면서 m == p
                // 말해야 하는 숫자에 추가
            // 순서를 가리키는 index를 참여 인원수로 나눈 나머지가 p랑 같다
                // 말해야 하는 숫자에 추가
            // index 1 증가

class Solution {
    public String solution(int n, int t, int m, int p) {
        // 변수
        int num = 0;
        int index = 1;
        StringBuilder sb = new StringBuilder();
        
        // 0부터 말하기 위해 while로 돌기
        while(sb.toString().length() != t){
            String str = Integer.toString(num, n).toUpperCase();
            for(int i = 0; i<str.length(); i++){
                if(index % m == 0 && m == p){
                    sb.append(String.valueOf(str.charAt(i)));
                }else if(index % m == p){
                    sb.append(String.valueOf(str.charAt(i)));
                }
                if(sb.toString().length() == t){
                    break;
                }
                index++;
            }
            num++;
            
        }
        
        // 정답
        return sb.toString();
    }
}