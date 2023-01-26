class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.replaceAll("[^0-9]", " ").split(" ");
        int answer = 0;

        for(String s : arr){
            if(s.equals("")){
                continue;
            }else{
                answer += Integer.parseInt(s);
            }
        }

        return answer;
    }
}

// trim 사용
class Solution {
    public int solution(String my_string) {
        String[] arr = my_string.replaceAll("[^0-9]", " ").trim().split(" ");
        int answer = 0;

        for(String s : arr){
            if(s.equals("")){
                continue;
            }else{
                answer += Integer.parseInt(s);
            }
        }

        return answer;
    }
}