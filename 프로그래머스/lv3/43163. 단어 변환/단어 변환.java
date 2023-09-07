class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        // 변수
        visited = new boolean[words.length];
        
        // 재귀
        recur(words, begin, target, 0);
        
        if(answer != Integer.MAX_VALUE){
            return answer;
        }
        return 0;
       
    }
    
    public void recur(String[] words, String word, String target, int count){
        if(word.equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        for(int i = 0; i<words.length; i++){
            if(!visited[i]){
                if(onlyOneDiffer(word, words[i])){
                    visited[i] = true;
                    recur(words, words[i], target, count+1);
                    visited[i] = false;
                }
            }
        }
    }
    
    public boolean onlyOneDiffer(String str1, String str2){
        int count = 0;
        for(int i = 0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }
}