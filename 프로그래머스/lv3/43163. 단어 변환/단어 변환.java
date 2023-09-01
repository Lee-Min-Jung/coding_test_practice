// 생각
    // words를 탐색해야 함... 
    // 예전에 계속했던 재귀를 활용한 완전탐색
// 구현
    // recur(String[] words, String begin)
        // if(begin == target) : 종료
        // for(words)
            // begin과 words[i]가 하나 차이 && !visited[i]
                // count++
                // visited[i] = true
                // recur(words, words[i])
                // visited[i] = false;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        recur(words, begin, target, 0);
        
        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        
        return answer;
    }
    
    public void recur(String[] words, String begin, String target, int count){
        
        if(begin.equals(target)){
            answer = count;
            return;
        }
        for(int i = 0; i<words.length; i++){
            if(!visited[i] && compareStr(begin, words[i]) == 1){
                visited[i] = true;
                recur(words, words[i], target, count+1);
                visited[i] = false;
            }
        }
        
    }
    
    public int compareStr(String str1, String str2){
        int count = 0;
        for(int i = 0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }
        return count;
    }
}