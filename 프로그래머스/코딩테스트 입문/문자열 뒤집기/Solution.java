// 방법 1
class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] my_string_arr = my_string.split("");

        for(int i = my_string_arr.length-1; i>=0; i--){
            answer += my_string_arr[i];
        }

        return answer;
    }
}

// 방법 2

class Solution {
    public String solution(String my_string) {
        String answer = "";

        for(int i = my_string.length()-1; i>=0; i--){
            answer += my_string.charAt(i);
        }

        return answer;
    }
}

// 방법 3

class Solution {
    public String solution(String myString) {
        String answer = new StringBuilder(myString).reverse().toString();

        return answer;
    }
}