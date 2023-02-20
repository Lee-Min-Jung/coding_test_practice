class Solution {
    public String solution(String s, int n) {
        String big = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isLowerCase(c)){
                int index = small.indexOf(String.valueOf(c)) + n;
                answer.append(small.charAt(index%26));
            }else if(Character.isUpperCase(c)){
                int index = big.indexOf(String.valueOf(c)) + n;
                answer.append(big.charAt(index%26));
            }else{
                answer.append(" ");
            }
            
        }
        
        return answer.toString();
    }
}