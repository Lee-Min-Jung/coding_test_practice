// 생각
    // 완전탐색
// 구현
    // sizes 돌기
        // 가로 세로 중 더 큰 걸 가로에 놓기
        // 가로 배열에 가로 추가, 세로 배열에 세로 추가
    // 가로 세로 배열 정렬
    // 맨 뒤에 있는 것 끼리 곱하기
import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        // sizes 돌기
        int[] widthArr = new int[sizes.length];
        int[] heightArr = new int[sizes.length];
        
        for(int i = 0; i<sizes.length; i++){
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            widthArr[i] = width;
            heightArr[i] = height;
        }
        
        // 정렬
        Arrays.sort(widthArr);
        Arrays.sort(heightArr);
        
        // 답
        int answer = 0;
        answer = widthArr[widthArr.length-1] * heightArr[heightArr.length-1];
        
        return answer;
    }
}