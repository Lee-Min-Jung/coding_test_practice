// 생각
    // map
// 구현
    // A~Z 까지 map에 저장
    // msg를 돈다
        // map에서 발견할 수 없는 문자열을 발견할 때까지 돈다, 만약 발견
            // 해당 문자열보다 길이가 1 작은 것을 map에서 찾아 인덱스 저장
            // 해당 문자열 map에 저장
            // 해당 문자열보다 길이가 1 작은 것을 msg에서 삭제
        // 발견하지 못하거나 맨 끝이면 그냥 인덱스 찾아서 저장 후 msg에서 삭제
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // A~Z map에 저장
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int index = 26; 

        for(int i = 0; i < alphabet.length(); i++){
            hm.put(String.valueOf(alphabet.charAt(i)), i + 1);
        }

        // msg 돌기
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        int start = 0;
        int end = 1;
        while(start < msg.length()){
            while(end <= msg.length() && hm.containsKey(msg.substring(start, end))){
                end++;
            }
            answerList.add(hm.get(msg.substring(start, end-1)));
            if(end <= msg.length()){
                hm.put(msg.substring(start, end), ++index);    
            }
            start = end - 1;
        }
        

        // 답
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}

