// 생각
    // words 돌면서 맨 마지막 글자 저장하고 다음 단어 맨 처음이랑 아까 저장한 거 비교... 
    // index 계산도 하고..
// 구현
    // words를 돈다
        // set에 현재 단어가 있다
            // 
        // set에 현재 단어가 없다
            // set에 현재 단어 저장
            // 해당 단어의 맨 첫 글자와 저장된 맨 마지막 글자가 같다
                // 이번의 마지막 글자 저장
                // 다음 턴으로
            // 해당 단어의 맨 첫 글자와 저장된 맨 마지막 글자가 다르다
                // 몇 번째 사람인지 구하고
                // 몇 번째 턴인지 구함
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Character prev = words[0].charAt(0);
        HashSet<String> set = new HashSet<String>();
        int[] answer = new int[2];
        int turn = 1;
        // words를 돌기
        for(int i = 0; i<words.length; i++){
            Character curCh = words[i].charAt(0);
            
            
            //
            if(set.contains(words[i]) || prev != curCh){
                int personIndex = (i+1)%n != 0 ? (i+1)%n : n;
                int curTurn = (i+1) / (words.length / n) +1;
                answer[0] = personIndex;
                answer[1] = turn;
                break;
            }else{
                set.add(words[i]);
                prev = words[i].charAt(words[i].length()-1);
            }
            
            // 턴 세기
            if((i+1) == turn *n){
                turn += 1;
            }
        }
        
        return answer;
    }
}