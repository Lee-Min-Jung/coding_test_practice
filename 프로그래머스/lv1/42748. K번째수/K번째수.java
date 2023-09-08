// 생각
    // commands를 돌면서 각 인덱스 보고 array에서 값 구하기
// 구현
    // for(commands)
        // i, j, k 추출
        // for(i-1~j-1)
            // array[i-1] 부터 array[j-1] 까지의 값 추출
        // 새로 구한 배열 정렬
        // 새로 구한 배열에서 k-1번째 값 저장
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i<commands.length; i++){
            int startIndex = commands[i][0]-1;
            int endIndex = commands[i][1]-1;
            int k = commands[i][2]-1;
            int[] subArr = new int[endIndex-startIndex+1];
            int m = 0;
            for(int j = startIndex; j<=endIndex; j++){
                subArr[m] = array[j];
                m++;
            }
            Arrays.sort(subArr);
            answer[i] = subArr[k];
        }
        return answer;
    }
}