// 생각
    // AEIOU 돌면서 재귀 dfs, 근데 방문배열 표시할 필요는 없고 특정 길이되면 return 하게
// 구현
    // 재귀
import java.util.*;
class Solution {
    static String[] alphabet = {"A", "E", "I", "O", "U"};
    static ArrayList<String> wordList = new ArrayList<String>();
    
    public int solution(String word) {
        int answer = 0;
        recur("");
        for(int i = 0; i<wordList.size(); i++){
            if(word.equals(wordList.get(i))){
                answer = i+1;
            }
        }
        
        return answer;
    }
    
    public void recur(String word){
        if(word.length() == 5){
            return;
        }
        for(int i = 0; i<alphabet.length; i++){
            wordList.add(word+alphabet[i]);
            recur(word+alphabet[i]);
        }
    }
}