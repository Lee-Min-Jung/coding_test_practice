import java.util.*;

// 나의 풀이
class Solution {
    public long solution(String numbers) {
        // 스트링에서 각 문자 찾고 있으면 replace하기

        HashMap<String, Integer> m = new HashMap<String, Integer>(){{
            put("zero",0);
            put("one",1);
            put("two",2);
            put("three",3);
            put("four",4);
            put("five",5);
            put("six",6);
            put("seven",7);
            put("eight",8);
            put("nine",9);
        }};

        for(String key : m.keySet()){
            numbers = numbers.replaceAll(key, String.valueOf(m.get(key)));
        }

        return Long.parseLong(numbers);



    }
}
// 다른 풀이
import java.util.*;

class Solution {
    public long solution(String numbers) {
        String[] arr = {"zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"};

        for(int i = 0; i<arr.length; i++){
            numbers = numbers.replaceAll(arr[i], String.valueOf(i));
        }

        return Long.parseLong(numbers);

    }
}