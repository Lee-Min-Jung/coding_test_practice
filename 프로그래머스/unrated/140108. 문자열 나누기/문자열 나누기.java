class Solution {
    private static int answer = 0;
    public int solution(String s) {
        // s를 읽어나가면서 s의 맨 처음 개수 저장하는 변수에 개수 1이라고 저장
        // 맨 처음 이후, 
            // s와 같으면 위 변수 개수를 늘리고
            // s와 다르면 다른 변수 개수를 늘린다
        // 만약 두 변수의 값이 같아지면 해당 인덱스까지 자른 문자열을 제거하고 답을 1 증가
      
        
        while(s.length() != 0){
            s = getStr(s);
        }
        
        return answer;
        
    }
    
    public String getStr(String s){
        int sameCount = 1;
        int diffCount = 0;
        char baseChar = s.charAt(0);
        for(int i = 1; i<s.length(); i++){
            if(baseChar == s.charAt(i)){
                sameCount++;
            }else{
                diffCount++;
            }
            
            if(sameCount == diffCount){
                answer++;
                return s.substring(i+1, s.length());
            }
            
        }
        answer++;
        return "";
    }
}