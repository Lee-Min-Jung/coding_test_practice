class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        
        for(int i = 0; i<s.length(); i++){
            String c = String.valueOf(s.charAt(i));
            
            if(!c.equals(" ")){
                if(index % 2 == 0){
                    answer.append(c.toUpperCase());
                    index++;
                }else{
                    answer.append(c.toLowerCase());
                    index++;
                }
            }else{
                answer.append(" ");
                index = 0;
            }
        }
        
        return answer.toString();
        
    }
}