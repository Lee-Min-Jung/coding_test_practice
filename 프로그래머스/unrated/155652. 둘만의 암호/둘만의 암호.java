class Solution {
    public String solution(String s, String skip, int index) {
        // s를 돈다
            // 각 원소에서 skip 제외하고 index만큼 지나간 알파벳을 덧붙인다
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabetArr = alphabet.split("");
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i<s.length(); i++){
            int position = alphabet.indexOf(String.valueOf(s.charAt(i)));
            int skipCount = 0;
            while(index != skipCount){
                if(position == 25){
                    position = -1;
                }
                if(skip.contains(alphabetArr[position+1])){
                    position++;
                    continue;
                }else{
                    position++;
                    skipCount++;
                }
            }
            
            answer.append(alphabetArr[position]);
        }
        return answer.toString();
    }
}