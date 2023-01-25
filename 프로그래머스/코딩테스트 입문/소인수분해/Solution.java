
import java.util.*;

class Solution {
    public int[] solution(int n) {
        // 들어온 수를 2부터 시작한 값으로 나눈다
        // 만약 2로 바로 나누어지면 나눈 수를 저장한 후 또 다시 2로 나눈다
        // 만약 2로 나누어지지 않으면 나누는 값을 1 증가해서 나눈다
        // 위에서 저장한 값을 중복 없이 만든 후 return
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int divisor = 2;
        while(n>=2){
            if(n%divisor==0){
                answer.add(divisor);
                n = n/divisor;
            }else{
                divisor++;
            }
        }
        return answer.stream().distinct().mapToInt(Integer :: intValue).toArray();
    }
}

// 이거 왜 안 되는 것인지..

import java.util.*;

class Solution {
    public int[] solution(int n) {
        // 들어온 수를 2부터 시작한 값으로 나눈다
        // 만약 2로 바로 나누어지면 나눈 수를 저장한 후 또 다시 2로 나눈다
        // 만약 2로 나누어지지 않으면 나누는 값을 1 증가해서 나눈다
        // 위에서 저장한 값을 중복 없이 만든 후 return
        HashSet<Integer> answer = new HashSet<Integer>();
        int divisor = 2;
        while(n>=2){
            if(n%divisor==0){
                answer.add(divisor);
                n = n/divisor;
            }else{
                divisor++;
            }
        }
        return answer.stream().mapToInt(Integer :: intValue).toArray();

    }
}