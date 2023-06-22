// 1단계: 대문자를 소문자로 치환
// 2단계: 알파벳 소문자, 숫자,-, _, . 만 남기기
// 3단계: 마침표 2번 이상인 부분 1번으로 치환
// 4단계: 마침표가 처음이나 끝이면 없애기
// 5단계: 빈 문자열이면 a 대입
// 6단계: 16자 이상이면 15개만 남기기. 만약 제거 후 마침표가 맨 마지막이면 마침표 제거
// 7단계: 길이가 2 이하라면 마지막 문자를 길이가 3될 때까지 반복

class Solution {
    public String solution(String new_id) {
        // 1단계
        String answer = new_id.toLowerCase();
        System.out.println(answer);
        // 2단계
        answer = answer.replaceAll("[^-.\\w]", "");
        System.out.println(answer);
        // 3단계
        answer = answer.replaceAll("\\.{2,}", "\\.");
        System.out.println(answer);
        // 4단계
        answer = answer.replaceAll("^(\\.)", "");
        answer = answer.replaceAll("(\\.)$", "");
        System.out.println(answer);
        // 5단계
        if(answer.equals("")){
            answer += "a";
        }
        System.out.println(answer);
        // 6단계
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
        }
        answer = answer.replaceAll("(\\.)$", "");
        System.out.println(answer);
        // 7단계
        if(answer.length() <= 2){
            String lastStr = answer.split("")[answer.length()-1];
            while(answer.length() !=3){
                answer += lastStr;
            }
        }
        
        
      
        
        return answer;
    }
}