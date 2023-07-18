// 생각
    // 감이 안 잡힌다... 그래서 다른 걸 참고 함
// 구현
    // dfs 돌면서 만든 단어들을 담을 list를 만든다
    // words를 돌면서 각 words를 시작점으로 해서 dfs를 돈다
    // 만든 단어 담긴 list를 돌면서 word와 같은 것의 index를 리턴한다
    
    // dfs
        // 그 동안 만들어진 단어들 담을 list와 앞으로 담을 단어를 매개변수로 보낸다
        // 앞으로 만들 단어가 만들 수 있는 최대 단어 길이보다 크면 함수 종료
        // 단어 담을 list에 앞으로 담을 단어 없으면 넣기
        // for문으로 words를 돌기
            // 재귀적으로 dfs 호출

import java.util.*;
class Solution {
    static char[] ch = {'A', 'E', 'I', 'O', 'U'};
    static int maxLen = 5;
    
    public int solution(String word) {

        int answer = 0;
        
        // 만들어진 단어 담기
        ArrayList<String> wordList = new ArrayList<String>();
        
        // ch돌기
        for(int i = 0; i<ch.length; i++){
            dfs(wordList, String.valueOf(ch[i]));
        }
        
        // 몇번째인지 찾기
        for(int i = 0; i<wordList.size(); i++){
            if(wordList.get(i).equals(word)){
                answer = i+1;
                break;
            }
        }
        
        return answer;
        
        
    }
    public void dfs(ArrayList<String> wordList, String str){
        if(str.length() > maxLen){
            return;
        }
        if(!wordList.contains(str)){
            wordList.add(str);
        }
        for(int i = 0; i<ch.length; i++){
            dfs(wordList, str+String.valueOf(ch[i]));
        }
    }
}

