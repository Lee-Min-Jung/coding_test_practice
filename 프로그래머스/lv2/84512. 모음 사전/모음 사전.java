// 생각
    // 만들 수 있는 단어들을 만들다가 word랑 같은 단어 나오면 인덱스 리턴
// 구현
    // 알파벳 담은 배열 선언
    // for(알파벳 배열) : 재귀 함수에 각 알파벳 보내기
    // 재귀 함수(String str, int len, 알파벳 배열)
        // if(len > 5) : 종료
        // count++
        // if(str == word) : count 리턴
        // for(알파벳 배열) : 재귀 함수에 각 알파벳 보내기
import java.util.*;
class Solution {
    static ArrayList<String> wordList;
    public int solution(String word) {
        // 초기화
        wordList = new ArrayList<String>();
        int answer = 0;
        
        // 알파벳 배열
        String[] strArr = {"A", "E", "I", "O", "U"};
        
        // 알파벳 배열 돌기
        for(int i = 0; i<strArr.length; i++){
            recur(strArr[i], strArr);
        }
    
        // index 찾기
        answer = wordList.indexOf(word)+1;
        return answer;
    }
    
    public void recur(String str, String[] strArr){
        if(str.length() > 5){
            return;
        }
        wordList.add(str);
        for(int i = 0; i<strArr.length; i++){
            recur(str+strArr[i], strArr);
        }
    }
}