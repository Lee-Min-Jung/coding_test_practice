// 생각
    // wires 인접리스트로 만들어서 시작 wire 끊고 bfs 각각 돌아서 차이 계산
// 구현
    // 인접리스트 만들기
    // 하나씩 끊으면서 확인
    // bfs
import java.util.*;

class Solution {
    static List<Integer>[] adj;
    public int solution(int n, int[][] wires) {
        // 변수
        int answer = Integer.MAX_VALUE;
        
        
        // 인접리스트 만들기
        adj = new List[n+1];
        for(int i = 1; i<=n; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            adj[start].add(end);
            adj[end].add(start);
        }
      
        
        // 하나씩 끊으면서 확인
        for(int i = 0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            boolean[] visited = new boolean[n+1];
            
            adj[start].remove(Integer.valueOf(end));
            adj[end].remove(Integer.valueOf(start));
            answer = Math.min(answer, Math.abs(bfs(start, visited)-bfs(end, visited)));
            adj[start].add(end);
            adj[end].add(start);
        }
        
        return answer;
    }
    
    // bfs
    public int bfs(int num, boolean[] visited){
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        q.add(num);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            count++;
            for(int next : adj[cur]){
                if(!visited[next]){
                    q.add(next);
                }
            }
        }
        
        return count;
    }
}