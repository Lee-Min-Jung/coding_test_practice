import java.util.*;

// 던전 배열을 모두 돌면서 가능한 모든 순서 경우의 수를 구한다
    // 각 경우의 수에서 최소 필요 피로도가 조건에 맞는지 확인

class Solution {
    static boolean[] visited;
    static int[][] dungeons;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        // 세팅
        visited = new boolean[dungeons.length];
        this.dungeons = dungeons;
        
        // 출력할 답
        answer = 0;
        
        // 모든 던전 돌기
        for(int i = 0; i<dungeons.length; i++){
            if(k >= dungeons[i][0]){
                dfs(i, k, 1);
            }
        }
        
        // 정답
        return answer;
         
        
    }
    
    static void dfs(int nodeIndex, int k, int depth){
        
        // 방문 표시
        visited[nodeIndex] = true;
        
        // 남은 피로도 계산
        k -= dungeons[nodeIndex][1];
        
        // 나머지 다시 돌기
        for(int i = 0; i<dungeons.length; i++){
            if(!visited[i] & k >= dungeons[i][0]){
                dfs(i, k, depth+1);
            }
        }
        
        // 다 방문하고 난 이후
        visited[nodeIndex] = false;
        answer = Math.max(answer, depth);
        
    }
    
    
}