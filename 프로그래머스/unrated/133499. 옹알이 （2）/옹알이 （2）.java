class Solution {
    public int solution(String[] babbling) {
        // babbling을 하나씩 살핀다
            // 하나씩 보면서 발음할 수 있는 것을 찾고 있으면 공백으로 치환한다
        // 4가지를 다 찾아 본 후 마지막에 공백이면 개수를 증가시킨다
        String[] enable = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for(int i = 0; i<babbling.length; i++){
            if(babbling[i].contains("aya")) babbling[i] = babbling[i].replaceAll("aya", "1");
            if(babbling[i].contains("ye")) babbling[i] = babbling[i].replaceAll("ye", "2");
            if(babbling[i].contains("woo")) babbling[i] = babbling[i].replaceAll("woo", "3");
            if(babbling[i].contains("ma")) babbling[i] = babbling[i].replaceAll("ma", "4");
        }
        for(int i = 0; i<babbling.length; i++){
            if(babbling[i].matches("^[0-9]*$") && checkSeq(babbling[i])){
                answer += 1;
            }
        }
        
        
        return answer;
        
    }
    
    public boolean checkSeq(String str){
        for(int i = 0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
}