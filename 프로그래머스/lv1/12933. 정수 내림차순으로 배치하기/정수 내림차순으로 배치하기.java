// 다른 풀이
import java.util.*;

class Solution {
    public long solution(long n) {
        String[] n_arr = String.valueOf(n).split("");
        StringBuilder n_sb = new StringBuilder();

        Arrays.sort(n_arr, Collections.reverseOrder());


        return Long.parseLong(String.join("", n_arr));
    }
}