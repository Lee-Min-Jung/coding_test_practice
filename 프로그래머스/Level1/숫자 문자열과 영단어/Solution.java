// 나의 풀이 - 이게 미세하게 더 빠름
class Solution {
    public int solution(String s) {
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int answer = 0;

        for(int i = 0; i<eng.length; i++){
            if(s.contains(eng[i])){
                s = s.replaceAll(eng[i], num[i]);
            }
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}

// 약간 수정한
class Solution {
    public int solution(String s) {
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int answer = 0;

        for(int i = 0; i<eng.length; i++){
            if(s.contains(eng[i])){
                s = s.replaceAll(eng[i], String.valueOf(i));
            }
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}

