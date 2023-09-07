// 생각
    // 인접리스트 만들어서 첫번째부터 bfs를 돌린 후 네트워크 개수 1 증가
    // 만약 방문 안 한 컴퓨터 존재하면 그거부터 bfs 돌린 후 네트워크 개수 1 증가, 다 방문할 때까지 
// 구현
    // 인접리스트
    // bfs
    // 네트워크 개수 구하기
import java.util.*;
class Solution {
    static List<Integer>[] adj; 
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        // 변수
        visited = new boolean[n];
        
        // 인접리스트
        adj = new List[n];
        for(int i = 0; i<n; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<computers.length; i++){
            for(int j = 0; j<computers[i].length; j++){
                if(i!=j && computers[i][j] != 0){
                    adj[i].add(j);
                }
            }
        }
        // 네트워크 개수 구하기
        bfs(0);
        int answer = 1;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int num){
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.offer(num);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            for(int next : adj[cur]){
                if(!visited[next]){
                    q.offer(next);
                }
            }
        }
    }
}