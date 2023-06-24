// s를 보면서 영어를 포함하고 있는지 확인한 후 포함하고 있으면 해당 영어를 숫자로 바꾼다
    // zero.....ten 까지 배열을 만들어 놓은 후 해당 배열을 돌면서 contains하고 있는지 확인해서 바꾸기
    // 바꿀 때는 map에 저장해 놓은 거 찾아와서 바꾸기
import java.util.*;

class Solution {
    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i<numbers.length; i++){
            s = s.replaceAll(numbers[i], String.valueOf(i));
        }
     
        return Integer.parseInt(s);
    }
}