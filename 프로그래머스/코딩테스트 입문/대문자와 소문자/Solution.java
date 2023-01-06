class Solution {
    public String solution(String my_string) {
        // 문자열을 쭉 돌기
        // 대문자인지 소문자인지 판단
        // 대문자면 소문자로, 소문자면 대문자로

        // 첫 번째 - 내가 풀었던 방법
        // 왜 이게 더 속도 빠른거지?
        char[] resultChar = new char[my_string.length()];

        for(int i = 0; i<my_string.length(); i++){
            if(Character.isUpperCase(my_string.charAt(i))){
                resultChar[i] = Character.toLowerCase(my_string.charAt(i));
            }else{
                resultChar[i] =  Character.toUpperCase(my_string.charAt(i));

            }
        }
        String resultStr = new String(resultChar);
        return resultStr;

        // 두 번째 - 다른 사람의 풀이 중
        String answer = "";
        for(int i = 0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if(Character.isUpperCase(c)){
                answer += String.valueOf(c).toLowerCase();
            }else{
                answer += String.valueOf(c).toUpperCase();
            }
        }
        return answer;
    }
}