// 생각
    // 그래프가 명확하니 bfs/dfs
// 구현
    // computers 정보 가지고 연결리스트 만들기
    // bfs()
import java.util.*;
class Solution {
    static List<Integer>[] adj;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        // 연결리스트 만들기
        adj = new List[n];
        for(int i = 0; i<adj.length; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<computers.length; i++){
            for(int j = 0; j<computers.length; j++){
                if(i!=j && computers[i][j] != 0){
                    adj[i].add(j);
                }
            }
        }
        // 방문 배열
        visited = new boolean[n];
        
        // bfs 돌기
        bfs(0);
        
        // 한 번 돌고 난 이후 방문 안 된 거 돌면서 네트워크 구하기
        int answer = 1;
        for(int i = 0; i<visited.length; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        
        return answer;
        
    }
    
    public void bfs(int comNum){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(comNum);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            visited[curr] = true;
            for(int n : adj[curr]){
                if(!visited[n]){
                    q.add(n);
                }
            }
        }
        
    }
}