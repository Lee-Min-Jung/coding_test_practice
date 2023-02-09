// 내가 푼 풀이 - 속도 이게 제일 빠름
class Solution {
    public long solution(long n) {
        String[] n_arr = String.valueOf(n).split("");

        for(int i = 0; i<n_arr.length; i++){
            for(int j = i+1; j<n_arr.length; j++){
                if(Long.parseLong(n_arr[i]) < Long.parseLong(n_arr[j])){
                    String temp = n_arr[i];
                    n_arr[i] = n_arr[j];
                    n_arr[j] = temp;
                }
            }
        }
        long answer = Long.parseLong(String.join("",n_arr));
        return answer;
    }
}

// 다른 풀이 1
import java.util.*;

class Solution {
    public long solution(long n) {
        String[] n_arr = String.valueOf(n).split("");
        StringBuilder n_sb = new StringBuilder();

        Arrays.sort(n_arr);

        for(String str : n_arr){
            n_sb.append(str);
        }

        return Long.parseLong(n_sb.reverse().toString());
    }
}

// 다른 풀이 2
import java.util.*;

class Solution {
    public long solution(long n) {
        String[] n_arr = String.valueOf(n).split("");
        StringBuilder n_sb = new StringBuilder();

        Arrays.sort(n_arr, Collections.reverseOrder());


        return Long.parseLong(String.join("", n_arr));
    }
}