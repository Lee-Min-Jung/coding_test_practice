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