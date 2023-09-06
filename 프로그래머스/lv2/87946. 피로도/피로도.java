// 생각
    // dungeons를 차례로 돌면서 모두 탐험 가능한지 세기
    // 재귀 활용한 dfs
// 구현
    // recur()

class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        // 변수
        visited = new boolean[dungeons.length];
        
        // 재귀
        recur(dungeons, k, 0);
        
        return answer;
    }
    
    public void recur(int[][] dungeons, int nowK, int count){
        for(int i = 0; i<dungeons.length; i++){
            if(!visited[i] && nowK >= dungeons[i][0]){
                visited[i] = true;
                recur(dungeons, nowK - dungeons[i][1], count+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}