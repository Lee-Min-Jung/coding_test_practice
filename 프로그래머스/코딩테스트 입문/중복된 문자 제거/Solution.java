class Solution {
    public String solution(String my_string) {
        // 문자열을 문자열 배열로 만들어 하나씩 돌면서 살핀다
        // 해당 문자열 앞까지 돌면서 같은 거 있는지 확인

        String[] strArr = my_string.split("");
        String answer = "";

        for(int i = 0; i<strArr.length; i++){
            boolean check = true;
            if(i == 0){
                answer += strArr[i];
            }else{
                for(int j = 0; j<i; j++){
                    if(strArr[j].equals(strArr[i])){
                        check = false;
                    }
                }
                if(check){
                    answer += strArr[i];
                }
            }
        }
        return answer;
    }
}