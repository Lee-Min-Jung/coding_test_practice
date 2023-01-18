import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        // 배열 돌면서 n과의 차이를 구한 후 구한 값들 가지고 있는 배열을 생성
        // 해당 배열 절댓값 씌워서 가장 작은 값의 인덱스를 이용해 원래 배열에 그 인덱스 넣어 값 추출
        // 만약 차이가 같을 경우에는 인덱스 넣어 값 추출한 것 비교해서 더 작은 값 리턴
        Arrays.sort(array);
        int[] distance = new int[array.length];

        for(int i = 0; i<array.length; i++){
            distance[i] = Math.abs(array[i] - n);
        }

        int minIndex = 0;
        int min = distance[0];
        for(int i = 0; i<distance.length; i++){
            if(distance[i] < min){
                minIndex = i;
                min = distance[i];
            }
        }

        return array[minIndex];
    }
}