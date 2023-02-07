import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // commands를 돌면서 범위와 인덱스를 구해서 array에 적용하여 값 하나 얻은 후 추가
        int[] answer = new int[commands.length];

        for(int i = 0; i<commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int index = commands[i][2]-1;
            int[] slice_arr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(slice_arr);
            answer[i] = slice_arr[index];
        }



        return answer;
    }
}