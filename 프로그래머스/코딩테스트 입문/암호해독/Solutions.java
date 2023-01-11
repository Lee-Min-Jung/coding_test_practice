// 나의 풀이
class Solution {
    public String solution(String cipher, int code) {
        // cipher를 분할한다
        // 분할한 리스트를 돌면서 code의 배수번째만 answer에 담는다
        // 결과 리턴
        String answer = "";
        String[] cipherList = cipher.split("");

        for(int i = 1; i<=cipherList.length; i++){
            if(i % code == 0){
                answer += cipherList[i-1];
            }
        }

        return answer;
    }
}