import java.lang.*;

class Solution {
    public String[] solution(String my_str, int n) {
        // mystr을 split이용해서 배열로 만들어서 for문 돌기
        // for 돌면서 n개씩 얻기
        // 얻은 걸 답에 더하기
        int len = 0;
        if(my_str.length() % n == 0){
            len = my_str.length() / n;
        }else{
            len = (my_str.length() / n) + 1;
        }
        String[] answer = new String[len];

        for(int i = 0, j = 0; i<len; i++, j+=n){
            if(j+n <= my_str.length()){
                answer[i] = my_str.substring(j, j+n);
            }else{
                answer[i] = my_str.substring(j, my_str.length());
            }
        }

        return answer;

    }
}