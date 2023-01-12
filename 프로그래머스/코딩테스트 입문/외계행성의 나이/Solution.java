class Solution {
    public String solution(int age) {
        // age를 string으로 변경
        // string 하나씩 살펴보며 기준에 맞는 알파벳을 선택
        // 위에서 선택한 알파벳을 answer에 붙이기
        String answer = "";
        String ageStr = Integer.toString(age);

        for(int i = 0; i<ageStr.length(); i++){
            char c = ageStr.charAt(i);
            switch(c) {
                case '0':
                    answer += "a";
                    break;
                case '1':
                    answer += "b";
                    break;
                case '2':
                    answer += "c";
                    break;
                case '3':
                    answer += "d";
                    break;
                case '4':
                    answer += "e";
                    break;
                case '5':
                    answer += "f";
                    break;
                case '6':
                    answer += "g";
                    break;
                case '7':
                    answer += "h";
                    break;
                case '8':
                    answer += "i";
                    break;
                case '9':
                    answer += "j";
                    break;
                default:
                    answer += "";
                    break;
            }
        }
        return answer;

    }
}