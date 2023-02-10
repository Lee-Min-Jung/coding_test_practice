
// 내 풀이 - 속도 더 빠름
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(arr);

        for(int i = 0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                answer.add(arr[i]);
            }
        }
        if(answer.size() == 0){
            answer.add(-1);
        }

        int[] answer2 = new int[answer.size()];

        for(int i = 0; i<answer2.length; i++){
            answer2[i] = answer.get(i);
        }

        return answer2;
    }
}

// 다른 풀이
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(arr);

        for(int i = 0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                answer.add(arr[i]);
            }
        }
        if(answer.size() == 0){
            answer.add(-1);
        }
        return answer.stream().mapToInt(Integer :: intValue).toArray() ;
    }
}
