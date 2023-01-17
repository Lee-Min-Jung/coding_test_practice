// 내가 처음에 생각했던 것
    // 테스트 케이스는 되는데 제출 후 채점에서 틀린 게 생김..왜?
class Solution {
    public int solution(String before, String after) {
        // before의 순서를 바꾸어 저장
        // 위의 결과와 after 결과 비교

        String beforeReverseStr = "";

        for(int i = before.length()-1 ; i>=0; i--){
            beforeReverseStr += Character.toString(before.charAt(i));
        }

        if(beforeReverseStr.equals(after)){
            return 1;
        }else{
            return 0;
        }
    }
}

// 위에 거 틀려서 이걸로 함
import java.util.*;

class Solution {
    public int solution(String before, String after) {


        // before 정렬, after 정렬 후 둘이 같은지 비교

        char[] beforeCharArr = before.toCharArray();
        char[] afterCharArr = after.toCharArray();

        Arrays.sort(beforeCharArr);
        Arrays.sort(afterCharArr);

        String beforeStr = new String(beforeCharArr);
        String afterStr = new String(afterCharArr);

        if(beforeStr.equals(afterStr)){
            return 1;
        }else{
            return 0;
        }


    }
}

