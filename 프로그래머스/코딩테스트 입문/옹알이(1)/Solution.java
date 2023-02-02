import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        ArrayList<String[]> result_list = new ArrayList<String[]>();
        int answer = 0;

        for(String str : babbling){
            String[] slice_arr = str.split("aya|ye|woo|ma");
            result_list.add(slice_arr);
        }

        for(String[] arr : result_list){
            if(arr.length == 0){
                answer += 1;
            }
        }

        return answer;
    }
}

// 다른 풀이 - 이게 더 빠름
import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(String str : babbling){
            str = str.replace("aya", "*");
            str = str.replace("ye", "*");
            str = str.replace("woo", "*");
            str = str.replace("ma", "*");
            str = str.replace("*", "");

            if(str.equals("")){
                answer += 1;
            }
        }

        return answer;
    }
}