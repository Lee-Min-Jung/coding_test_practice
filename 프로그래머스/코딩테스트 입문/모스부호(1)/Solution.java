import java.util.*;

class Solution {
    public String solution(String letter) {
        // letter를 공백으로 나누어 배열 한 원소에 한 모스부호 문자 들어가게
        // 모스부호 리스트와 연결해서 알파벳 구하기
        // 소문자로 변경 후 출력


        HashMap<String, String> mosAlphabet = new HashMap<String, String>(){{
            put(".-", "a");
            put("-...", "b");
            put("-.-.", "c");
            put("-..", "d");
            put(".", "e");
            put("..-.", "f");
            put("--.", "g");
            put("....", "h");
            put("..", "i");
            put(".---", "j");
            put("-.-", "k");
            put(".-..", "l");
            put("--", "m");
            put("-.", "n");
            put("---", "o");
            put(".--.", "p");
            put("--.-", "q");
            put(".-.", "r");
            put("...", "s");
            put("-", "t");
            put("..-", "u");
            put("...-", "v");
            put(".--", "w");
            put("-..-", "x");
            put("-.--", "y");
            put("--..", "z");
        }};
        String[] mosLetterArr = letter.split(" ");
        String answer = "";

        for(int i = 0; i<mosLetterArr.length; i++){
            answer += mosAlphabet.get(mosLetterArr[i]);
        }
        return answer;
    }
}