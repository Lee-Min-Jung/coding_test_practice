// 처음 나의 풀이
import java.util.*;

class Solution {
    public int solution(int[] array) {
        // map을 하나 만든다
        // array 돌면서 map 채우기
        // 다 돌고 난 후 map의 value 중 가장 큰 값 return 여러개면 -1 return
        int answer = 0;
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

        for(int i = 0; i<array.length; i++){
            int count = h.get(array[i]) != null ? h.get(array[i])+1 : 1;
            h.put(array[i], count);
        }
        int manyKey = 0;
        int manyVal = 0;
        int sameCount = 0;
        int sameVal = 0;
        for(Integer i : h.keySet()){
            if(h.get(i) > manyVal){
                manyKey = i;
                manyVal = h.get(i);
            }else if(h.get(i) == manyVal){
                sameCount += 1;
                sameVal = manyVal;
            }
        }
        if(manyVal > sameVal){
            return manyKey;
        }else{
            return -1;
        }

    }
}

// 더 나은 풀이
import java.util.*;
class Solution {
    public int solution(int[] array) {
        int maxCount = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : array){
            int count = map.getOrDefault(number, 0) + 1;
            if(count > maxCount){
                maxCount = count;
                answer = number;
            }
            else if(count == maxCount){
                answer = -1;
            }
            map.put(number, count);
        }
        return answer;
    }
}