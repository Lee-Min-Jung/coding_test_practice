class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] sArr = s.split("");
        int index = 0;
        
        for(String str : sArr){
            index = str.equals(" ") ? 0 : index + 1;
            
            if(index % 2 == 0){
                answer.append(str.toLowerCase());
            }else{
                answer.append(str.toUpperCase());
            }
        }
        
        
        return answer.toString();
        
    }
}