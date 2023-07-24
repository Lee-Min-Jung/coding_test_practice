import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<String>();
        int[] answer = new int[2];

        // words를 돌기
        for (int i = 0; i < words.length; i++) {
            // 현재 단어의 첫 글자
            Character curCh = words[i].charAt(0);

            if (set.contains(words[i]) || (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != curCh)) {
                int personIndex = (i % n) + 1;
                int curTurn = (i / n) + 1;
                answer[0] = personIndex;
                answer[1] = curTurn;
                break;
            } else {
                set.add(words[i]);
            }
        }

        return answer;
    }
}
